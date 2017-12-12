package com.sa45.team3.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.annotation.JsonTypeInfo.None;
import com.sa45.team3.model.Product;
import com.sa45.team3.model.ProductUsage;
import com.sa45.team3.model.Reorders;
import com.sa45.team3.model.UsageDetailsPrimaryKey;
import com.sa45.team3.model.UsageRecord;
import com.sa45.team3.model.UsageRecordDetails;
import com.sa45.team3.repository.ProductRepository;
import com.sa45.team3.repository.UsageRecordDetailsRepository;
import com.sa45.team3.repository.UsageRecordRepository;

import com.sa45.team3.service.StaffService;
import com.sa45.team3.service.SupplierService;

import com.sa45.team3.service.ProductCatalogService;

import com.sa45.team3.service.UsageRecordService;

@RequestMapping("/mechanic")
@Controller
public class UsageRecordControl {

	@Autowired
	private UsageRecordService uService;
	
	@Autowired
	private ProductCatalogService pService;
	
	@Autowired
	private StaffService sService;

	@InitBinder
	private void initUsageRecordBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

	}

	@Resource
	UsageRecordRepository prepo;

	@Autowired
	ProductCatalogService productRepository;

	@Resource
	UsageRecordDetailsRepository urdRepo;

	@RequestMapping(value = "/usage-record", method = RequestMethod.GET)
	public ModelAndView recordListPage() {

		ModelAndView mav = new ModelAndView("usage-record"); // create jsp
		List<UsageRecord> usageRecordList = prepo.findAll();
		mav.addObject("recordList", usageRecordList);
		return mav;

	}

	@RequestMapping(value = "/admin-usage-record", method = RequestMethod.GET)
	public ModelAndView AdminrecordListPage() {

		ModelAndView mav = new ModelAndView("admin-usage-record"); // create jsp
		List<UsageRecord> usageRecordList = prepo.findAll();
		mav.addObject("recordList", usageRecordList);
		return mav;

	}

	@RequestMapping(value = "/usage-record-create", method = RequestMethod.GET)
	public ModelAndView usageRecordAdd() {

		ModelAndView mav = new ModelAndView("usage-record-add", "usageRecord", new UsageRecord());
		mav.addObject("usageRecordList", uService.findAllrecordIDs());

		List<Product> productList = productRepository.findAll();
		mav.addObject("pList", productList);
		List<UsageRecord> usageRecordList = prepo.findAll();
		if (usageRecordList.isEmpty()) {
			mav.addObject("PK",null);
		}else {
			int lastRecordID =  usageRecordList.get(usageRecordList.size()-1).getRecordID();
			String pkID = String.valueOf(lastRecordID+1);
			mav.addObject("PK", pkID);
		}
		
		ArrayList<Integer> staffID = sService.findAllStaffIDs();
		if (staffID.isEmpty()) {
			mav.addObject("dropList",staffID);
		}else {
			mav.addObject("dropList", staffID);
		}
		
		return mav;
		// learn how to do dropdown fields in the web page
	}

	@RequestMapping(value = "/usage-record-create", method = RequestMethod.POST)
	public ModelAndView createNewUsageRecord(@ModelAttribute UsageRecord usageRecord, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpServletRequest Request) {

		// what does bindingresult do?

		if (result.hasErrors())
			return new ModelAndView("usage-record-add"); // return to this page if error

		ModelAndView mav = new ModelAndView();
		String message = "New usage record: " + usageRecord.getRecordID() + " was successfully created.";

		uService.createUsageRecord(usageRecord);

		// added by Alex
		Map<String, String[]> params = new HashMap<>(Request.getParameterMap());

		params.remove("recordID");
		params.remove("UsageDate");
		params.remove("staffID");
		params.remove("customerName");
		params.remove("contactNumber");

		Iterator<String> i = params.keySet().iterator();

		int recordID = usageRecord.getRecordID();

		while (i.hasNext())

		{

			String key = (String) i.next();
			String value = ((String[]) params.get(key))[0];

			int partNum = Integer.parseInt(key);
			int partQty = Integer.parseInt(value);
			if (partQty != 0) {

				urdRepo.addNewDetail(recordID, partNum, partQty);

				// UPDATES THE QUANTITY IN PRODUCT TABLE AFTER USAGE IS RECORDED
				productRepository.updateQuantity(partQty, partNum);

				// START OF AUTRO TRIGGER CODE //
				Product cProduct = productRepository.findProductByID(partNum);

				if (cProduct.getQuantity() <= cProduct.getReorderPoint()) {

					/*
					 * //Refine logic for reordering quantity !!!!! // int minOrder =
					 * cProduct.getMinOrder(); List<Reorders> reOrdersList = reRepo.findAll(); int
					 * nextReorderID = reOrdersList.size() + 1; reRepo.addNewRecord(nextReorderID,
					 * partNum, partQty);
					 */
				}
			}
		}

		mav.setViewName("redirect:/mechanic/usage-record");

		redirectAttributes.addFlashAttribute("message", message); // what does this do?

		return mav;
	}

	@RequestMapping(value = "/usage-record-display-{id}", method = RequestMethod.GET)
	public ModelAndView newUsageRecordDetailsPage(@PathVariable Integer id) {

		ArrayList<UsageRecordDetails> d = uService.findAllRecordDetailsByID(id);
		UsageRecord d2 = uService.findUsageRecordbyID(id);
		ModelAndView mav = new ModelAndView("usage-record-details");
		mav.addObject("usageRecordDetails", d);
		mav.addObject("recordList", d2);
		return mav;
	}

	@RequestMapping(value = "usage-record-edit/{id}", method = RequestMethod.GET)
	public ModelAndView editUsageRecordPage(@PathVariable Integer id) {
		//ArrayList<UsageRecordDetails> d = uService.findAllRecordDetailsByID(id);
		UsageRecord d2 = uService.findUsageRecordbyID(id);
	
		ArrayList<Product> products = pService.findAll();
		
		ModelAndView mav = new ModelAndView("admin-usage-record-edit");
		Integer quantity;
		ArrayList<ProductUsage> productUsages = new ArrayList<>();
		UsageRecordDetails usageRecordDetails = new UsageRecordDetails();
		Integer num = id;
		for (int i =0;i<products.size();i++) {
			quantity =0;
			ProductUsage productUsage = new ProductUsage();
			
			productUsage.setPartNumber((products.get(i).getPartNumber()));
			productUsage.setPartName(products.get(i).getProductName());		
			
			try {
				usageRecordDetails = urdRepo.findUsageDetailsByCompositeID(num, (products.get(i).getPartNumber()));
				usageRecordDetails.toString();
				quantity = usageRecordDetails.getUsedQuantity();
			}catch(Exception e) {
				productUsage.setQuantity(0);
			}				
			productUsage.setQuantity(quantity);
			productUsages.add(productUsage);
		}
		ArrayList<Integer> staffID = sService.findAllStaffIDs();
		if (staffID.isEmpty()) {
			mav.addObject("dropList",staffID);
		}else {
			mav.addObject("dropList", staffID);
		}
		mav.addObject("usageRecordDetails", productUsages);
		mav.addObject("recordList", d2);
		return mav;
	}

	@RequestMapping(value = "usage-record-edit-{id}", method = RequestMethod.POST)
	public ModelAndView editUsageRecord(@ModelAttribute @Valid UsageRecord usageRecord, BindingResult result,
			@PathVariable Integer id, final RedirectAttributes redirectAttributes, HttpServletRequest Request) {

		if (result.hasErrors())
			return new ModelAndView("usage-record-edit-{id}");

		ModelAndView mav = new ModelAndView();
		String message = "Usage Record: " + usageRecord.getRecordID() + " was successfully updated.";

		uService.editUsageRecord(usageRecord);
		
		Map<String, String[]> params = new HashMap<>(Request.getParameterMap());

		params.remove("recordID");
		params.remove("UsageDate");
		params.remove("staffID");
		params.remove("customerName");
		params.remove("contactNumber");

		Iterator<String> i = params.keySet().iterator();

		int recordID = usageRecord.getRecordID();

		while (i.hasNext())

		{

			String key = (String) i.next();
			String value = ((String[]) params.get(key))[0];

			int partNum = Integer.parseInt(key);
			int partQty = Integer.parseInt(value);
			if (partQty != 0) {

				urdRepo.addNewDetail(recordID, partNum, partQty);

				// UPDATES THE QUANTITY IN PRODUCT TABLE AFTER USAGE IS RECORDED
				//productRepository.updateEditQuantity(partQty, partNum);
				
			}
		}
		
		mav.setViewName("redirect:/mechanic/usage-record");
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
}


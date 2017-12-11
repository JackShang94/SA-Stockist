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

import com.sa45.team3.model.Product;
import com.sa45.team3.model.UsageRecord;
import com.sa45.team3.model.UsageRecordDetails;
import com.sa45.team3.repository.ProductRepository;
import com.sa45.team3.repository.UsageRecordDetailsRepository;
import com.sa45.team3.repository.UsageRecordRepository;
import com.sa45.team3.service.UsageRecordService;

@RequestMapping("/mechanic")
@Controller
public class UsageRecordControl {

	@Autowired
	private UsageRecordService uService;

	@InitBinder
	private void initUsageRecordBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
	}
	
	@Resource
	UsageRecordRepository prepo;

	@Resource
	ProductRepository productRepository;

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

			int intKey = Integer.parseInt(key);
			int intValue = Integer.parseInt(value);
			if (intValue != 0) {

				urdRepo.addNewDetail(recordID, intKey, intValue);
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
		// ModelAndView mav2 = new ModelAndView("usage-record-add", "recordList", d2);
		mav.addObject("usageRecordDetails", d);
		mav.addObject("recordList", d2);
		return mav;
	}

}
/*
 * @RequestMapping(value="/")
 * 
 * @Controller public class UsageRecordControl {
 * 
 * @Resource SupplierRepository sprepo;
 * 
 * @RequestMapping(value="/list", method= RequestMethod.GET) public ModelAndView
 * supplierListPage() {
 * 
 * ModelAndView mav = new ModelAndView("supplier-list"); //create jsp
 * List<Supplier> supplierList = sprepo.findAll(); mav.addObject("slist",
 * supplierList); return mav;
 * 
 * 
 * }
 * 
 * @RequestMapping(value="/create", method= RequestMethod.GET) public
 * ModelAndView supplierAdd() {
 * 
 * ModelAndView mav = new ModelAndView("supplier-add"); Supplier supl = new
 * Supplier(); mav.addObject("supl", supl); return mav; //learn how to do
 * dropdown fields in the web page }
 * 
 * @RequestMapping(value="/create", method=RequestMethod.POST) public
 * ModelAndView createNewUser(@ModelAttribute Supplier supplier, BindingResult
 * result, final RedirectAttributes redirectAttributes) {
 * 
 * //what does bindingresult do?
 * 
 * if (result.hasErrors()) return new ModelAndView("supplier-add"); //return to
 * this page if error
 * 
 * ModelAndView mav = new ModelAndView(); String message = "New user " +
 * supplier.getSupplierName() + " was successfully created.";
 * 
 * sprepo.saveAndFlush(supplier); mav.setViewName("redirect:/list");
 * 
 * redirectAttributes.addFlashAttribute("message", message); //what does this
 * do? return mav; }
 * 
 * //{id} and String id must match
 * 
 * @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET) public
 * ModelAndView editUserPage(@PathVariable String id) { ModelAndView mav = new
 * ModelAndView("supplier-edit"); ID = Integereger.parseInteger(id); Supplier
 * supplier = sprepo.findOne(ID); mav.addObject("supl", supplier); return mav; }
 * 
 * @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST) public
 * ModelAndView editUser(@ModelAttribute @Valid Supplier supplier, BindingResult
 * result, @PathVariable String id, final RedirectAttributes redirectAttributes)
 * {
 * 
 * if (result.hasErrors()) return new ModelAndView("supplier-edit");
 * 
 * ModelAndView mav = new ModelAndView("redirect:/list"); String message =
 * "Supplier was successfully updated.";
 * 
 * sprepo.saveAndFlush(supplier);
 * 
 * redirectAttributes.addFlashAttribute("message", message); return mav; }
 */

// }

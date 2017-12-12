package com.sa45.team3.controller;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

//import javax.annotation.Resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sa45.team3.exception.SupplierCantDelete;
import com.sa45.team3.exception.SupplierNotFound;
import com.sa45.team3.model.Supplier;
import com.sa45.team3.model.Supplier;
import com.sa45.team3.repository.ProductRepository;
//import com.sa45.team3.repository.SupplierRepository;
import com.sa45.team3.service.SupplierService;
import com.sa45.team3.validator.SupplierValidator;

@RequestMapping("/admin")
@Controller
public class AdminSupplierControl {

	@Autowired 
	SupplierService supService;
	
	@Resource
	ProductRepository proRepository;
	
	
	@Autowired
	private SupplierService sService;
	@Autowired
	private SupplierValidator sValidator;

	@InitBinder("supplier")
	private void initSupplierBinder(WebDataBinder binder) {
		binder.addValidators(sValidator);
	}

	
	/*@Resource
	SupplierRepository supRepository;*/
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView supplierListPage(@RequestParam(required = false) Integer page) {
		ModelAndView mav = new ModelAndView("supplier-list");
		ArrayList<Supplier> supplierList = (ArrayList<Supplier>)supService.findAllSuppliers();//supRepository.findAll();
		
		PagedListHolder<Supplier> ph = new PagedListHolder<>();
		ph.setSource(supplierList);
		ph.setPageSize(8);
		if (page == null || page < 1 || page > ph.getPageCount()) {
			ph.setPage(0);
		}
		else {
			ph.setPage(page);
		}
		mav.addObject("page", ph.getPage()); // current page
		mav.addObject("supplierList", ph.getPageList());
		mav.addObject("maxPages", ph.getPageCount()-1); // number of pages
		
		//mav.addObject("supplierList", supplierList);
		
		return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ModelAndView SupplierListPage(HttpServletRequest request) {

		String error;
		ModelAndView mav = new ModelAndView("supplier-list"); // create jsp
		String filter = request.getParameter("filter");
		String searchVar = request.getParameter("searchVar");
		ArrayList<Supplier> supplierList = new ArrayList<Supplier>();

		try {
			switch (filter) {

			case "contactNumber":
				Integer searchInt = Integer.parseInt(searchVar);
				supplierList = supService.searchSupplierByContactNumber(searchInt);
				break; 

			case "supplierName":
				supplierList = supService.searchSupplierByName(searchVar);
				break;

			
			}
		} catch (NumberFormatException e) {

			error = "Contact Number only accepts digits.";
			supplierList = (ArrayList<Supplier>) supService.findAllSuppliers();

		}
		
		catch (Exception e) {

			error = "No entries returned.";
		}

		finally {
			String supplierCount = Integer.toString(supplierList.size());
			mav.addObject("supplierCount", supplierCount);

			mav.addObject("supplierList", supplierList);
		}
		return mav;
	}
	
	@RequestMapping(value = "/supplier-show-list", method = RequestMethod.GET)
	public ModelAndView ShowSupplierList(@RequestParam(required = false) Integer page) {

		ModelAndView mav = new ModelAndView("supplier-show-list"); // create jsp
		List<Supplier> supplierList = supService.findAllSuppliers();

		PagedListHolder<Supplier> ph = new PagedListHolder<>();
		ph.setSource(supplierList);
		ph.setPageSize(8);
		if (page == null || page < 1 || page > ph.getPageCount()) {
			ph.setPage(0);
		}
		else {
			ph.setPage(page);
		}
		mav.addObject("page", ph.getPage()); // current page
		mav.addObject("supplierList", ph.getPageList());
		mav.addObject("maxPages", ph.getPageCount()-1); // number of pages
		return mav;
	}

	@RequestMapping(value = "/supplier-show-list", method = RequestMethod.POST)
	public ModelAndView SupplierListPageFilter(HttpServletRequest request) {

		String error;
		ModelAndView mav = new ModelAndView("supplier-show-list"); // create jsp
		String filter = request.getParameter("filter");
		String searchVar = request.getParameter("searchVar");
		ArrayList<Supplier> supplierList = new ArrayList<Supplier>();

		try {
			switch (filter) {


			case "contactNumber":
				Integer searchInt = Integer.parseInt(searchVar);
				supplierList = supService.searchSupplierByContactNumber(searchInt);
				break; 

			case "supplierName":
				supplierList = supService.searchSupplierByName(searchVar);
				break;

			
			}
		} catch (NumberFormatException e) {

			error = "Contact Number only accepts digits.";
			supplierList = (ArrayList<Supplier>) supService.findAllSuppliers();

		}
		
		catch (Exception e) {

			error = "No entries returned.";
		}

		finally {
			String supplierCount = Integer.toString(supplierList.size());
			mav.addObject("supplierCount", supplierCount);

			mav.addObject("supplierList", supplierList);
		}
		return mav;
	}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newSupplierPage() {
		ModelAndView mav = new ModelAndView("supplier-new", "supplier", new Supplier());
		ArrayList<Integer> sidList = supService.findAllSupplierIDs();
		mav.addObject("sidlist", sidList);
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewSupplier(@ModelAttribute @Valid Supplier supplier, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("supplier-new");

		ModelAndView mav = new ModelAndView();
		String message = "New supplier " + supplier.getSupplierID() + " was successfully created.";

		supService.createSupplier(supplier);
		mav.setViewName("redirect:/admin/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
		
	@RequestMapping(value = "/{supplierID}", method = RequestMethod.GET)
	public ModelAndView editSupplierPage(@PathVariable Integer supplierID) {
		
		ModelAndView mav = new ModelAndView("supplier-edit");
		Supplier supplier = supService.findSupplierById(supplierID);//findSupplier(supplierID.toString());
		
		mav.addObject("supplier", supplier);
		mav.addObject("sidlist", supService.findAllSupplierIDs());
		return mav;
	}

	@RequestMapping(value = "/{supplierID}", method = RequestMethod.POST)
	public ModelAndView editSupplier(@ModelAttribute @Valid Supplier supplier, BindingResult result,
			@PathVariable Integer supplierID, final RedirectAttributes redirectAttributes) throws SupplierNotFound {

		if (result.hasErrors())
			return new ModelAndView("supplier-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/list");
		String message = "Supplier " + supplier.getSupplierID() + " was successfully updated.";

		supService.editSupplier(supplier);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	/*@RequestMapping(value = "/{supplierIDsearch}", method = RequestMethod.POST)
	public ModelAndView editSearchSupplier(@ModelAttribute @Valid Supplier supplier, BindingResult result,
			@PathVariable Integer supplierID, final RedirectAttributes redirectAttributes) throws SupplierNotFound {

		if (result.hasErrors())
			return new ModelAndView("supplier-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/supplier-show-list");
		String message = "Supplier " + supplier.getSupplierID() + " was successfully updated.";

		supService.editSupplier(supplier);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}*/

	@RequestMapping(value = "/delete/{supplierID}", method = RequestMethod.GET)
	public ModelAndView deleteSupplier(@PathVariable Integer supplierID, final RedirectAttributes redirectAttributes)
			throws SupplierNotFound,SupplierCantDelete {
		
		ModelAndView mav = new ModelAndView("redirect:/admin/list");
		Supplier supplier = supService.findSupplierById(supplierID);//.findSupplier(supplierID.toString());
		
			supService.deleteSupplier(supplier);
			String message = "The supplier " + supplier.getSupplierID() + " was successfully deleted.";
	
			redirectAttributes.addFlashAttribute("message", message);
			return mav;
	}

}



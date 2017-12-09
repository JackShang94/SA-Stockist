package com.sa45.team3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sa45.team3.model.Product;
import com.sa45.team3.model.Supplier;
import com.sa45.team3.repository.ProductRepository;
import com.sa45.team3.repository.SupplierRepository;

@RequestMapping(value = "/Mechanic")
@Controller
public class BrowseCatalogControl {

	@Resource
	ProductRepository prepo;

	@RequestMapping(value = "/browse-catalog", method = RequestMethod.GET)
	public ModelAndView supplierListPage() {

		ModelAndView mav = new ModelAndView("browse-catalog"); // create jsp
		List<Product> productList = prepo.findAll();
		mav.addObject("pList", productList);
		return mav;

	}

	@RequestMapping(value="/browse-catalog", method= RequestMethod.POST)
	public ModelAndView supplierListPage(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("browse-catalog"); //create jsp
		String filter = request.getParameter("filter");
		String searchVar = request.getParameter("searchVar");
		ArrayList <Product> productList = new ArrayList<Product>();
		switch(filter) {
		
		case "ID":
			Integer searchInt = Integer.parseInt(searchVar);
/*			productList = prepo.findProductByID(searchVar);*/
			productList= prepo.findProductByID(searchInt);
			break; //dont forget to BREAK!!!!!!!!!!!!!!!
			
		case "Name":
			productList = prepo.findProductByName(searchVar);
			break;
			
		case "Description":
			productList = prepo.findProductByDescrp(searchVar);
			break;
			
		case "Color":
			productList = prepo.findProductByColor(searchVar);
			break;
		
		case "Dimension":
			productList = prepo.findProductByDimension(searchVar);
			
			

		}
		
/*		String productCount = Integer.toString(productList.size());
		mav.addObject("productCount", productCount);*/
		mav.addObject("pList", productList);
		
		
		return mav;
		
	}

	// @RequestMapping(value="/create", method= RequestMethod.GET)
	// public ModelAndView supplierAdd() {
	//
	// ModelAndView mav = new ModelAndView("supplier-add");
	// Supplier supl = new Supplier();
	// mav.addObject("supl", supl);
	// return mav;
	// //learn how to do dropdown fields in the web page
	// }
	//
	// @RequestMapping(value="/create", method=RequestMethod.POST)
	// public ModelAndView createNewUser(@ModelAttribute Supplier supplier,
	// BindingResult result,
	// final RedirectAttributes redirectAttributes) {
	//
	// //what does bindingresult do?
	//
	// if (result.hasErrors())
	// return new ModelAndView("supplier-add"); //return to this page if error
	//
	// ModelAndView mav = new ModelAndView();
	// String message = "New user " + supplier.getSupplierName() + " was
	// successfully created.";
	//
	// sprepo.saveAndFlush(supplier);
	// mav.setViewName("redirect:/list");
	//
	// redirectAttributes.addFlashAttribute("message", message); //what does this
	// do?
	// return mav;
	// }
	//
	//// {id} and String id must match
	// @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	// public ModelAndView editUserPage(@PathVariable String id) {
	// ModelAndView mav = new ModelAndView("supplier-edit");
	// int ID = Integer.parseInt(id);
	// Supplier supplier = sprepo.findOne(ID);
	// mav.addObject("supl", supplier);
	// return mav;
	// }
	//
	// @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	// public ModelAndView editUser(@ModelAttribute @Valid Supplier supplier,
	// BindingResult result, @PathVariable String id,
	// final RedirectAttributes redirectAttributes) {
	//
	// if (result.hasErrors())
	// return new ModelAndView("supplier-edit");
	//
	// ModelAndView mav = new ModelAndView("redirect:/list");
	// String message = "Supplier was successfully updated.";
	//
	// sprepo.saveAndFlush(supplier);
	//
	// redirectAttributes.addFlashAttribute("message", message);
	// return mav;
	// }

}

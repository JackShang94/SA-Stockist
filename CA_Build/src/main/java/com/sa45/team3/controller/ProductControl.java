package com.sa45.team3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sa45.team3.model.Product;
import com.sa45.team3.model.Supplier;
import com.sa45.team3.model.Staff;
import com.sa45.team3.repository.ProductRepository;
import com.sa45.team3.repository.SupplierRepository;
import com.sa45.team3.service.ProductService;
import com.sa45.team3.service.SupplierService;

import antlr.collections.AST;

import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "/product")
public class ProductControl {
	@Resource
	private ProductService productService;
	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping(value = "/product-list",method = RequestMethod.GET)
	public ModelAndView ShowProductListToAdmin(@RequestParam(required = false) Integer page) {

		ModelAndView mav = new ModelAndView("product-list"); // create jsp
		List<Product> productList = productService.findAll();

		PagedListHolder<Product> ph = new PagedListHolder<>();
		ph.setSource(productList);
		ph.setPageSize(5);
		if (page == null || page < 1 || page > ph.getPageCount()) {
			ph.setPage(0);
		}
		else {
			ph.setPage(page);
		}
		mav.addObject("page", ph.getPage()); // current page
		mav.addObject("pList", ph.getPageList());
		mav.addObject("maxPages", ph.getPageCount()-1); // number of pages
		return mav;
	}
	
	@RequestMapping(value = "/product-list", method = RequestMethod.POST)
	public ModelAndView ProductListPage(HttpServletRequest request) {

		String error;
		ModelAndView mav = new ModelAndView("product-list"); // create jsp
		String filter = request.getParameter("filter");
		String searchVar = request.getParameter("searchVar");
		ArrayList<Product> productList = new ArrayList<Product>();

		try {
			switch (filter) {

			case "ID":
				Integer searchInt = Integer.parseInt(searchVar);
				productList.add(productService.findProductByID(searchInt));
				break; 

			case "Name":
				productList = productService.findProductByName(searchVar);
				break;

			case "Description":
				productList = productService.findProductByDescrp(searchVar);
				break;

			case "Color":
				productList = productService.findProductByColor(searchVar);
				break;

			case "Dimension":
				productList = productService.findProductByDimension(searchVar);

			}
		} catch (NumberFormatException e) {

			error = "PoductID only accepts digits.";
			productList = (ArrayList<Product>) productService.findAll();

		}

		catch (Exception e) {

			error = "No entries returned.";
		}

		finally {
			String productCount = Integer.toString(productList.size());
			mav.addObject("productCount", productCount);

			mav.addObject("pList", productList);
		}
		return mav;
	}
	
	@RequestMapping(value = "/product-show-list", method = RequestMethod.GET)
	public ModelAndView ShowProductListToMechanic(@RequestParam(required = false) Integer page) {

		ModelAndView mav = new ModelAndView("product-show-list"); // create jsp
		List<Product> productList = productService.findAll();

		PagedListHolder<Product> ph = new PagedListHolder<>();
		ph.setSource(productList);
		ph.setPageSize(5);
		if (page == null || page < 1 || page > ph.getPageCount()) {
			ph.setPage(0);
		}
		else {
			ph.setPage(page);
		}
		mav.addObject("page", ph.getPage()); // current page
		mav.addObject("pList", ph.getPageList());
		mav.addObject("maxPages", ph.getPageCount()-1); // number of pages
		return mav;
	}

	@RequestMapping(value = "/product-show-list", method = RequestMethod.POST)
	public ModelAndView ProductListPageFilter(HttpServletRequest request) {

		String error;
		ModelAndView mav = new ModelAndView("product-show-list"); // create jsp
		String filter = request.getParameter("filter");
		String searchVar = request.getParameter("searchVar");
		ArrayList<Product> productList = new ArrayList<Product>();

		try {
			switch (filter) {

			case "ID":
				Integer searchInt = Integer.parseInt(searchVar);
				productList.add(productService.findProductByID(searchInt));
				break; 
						
			case "Name":
				productList = productService.findProductByName(searchVar);
				break;

			case "Description":
				productList = productService.findProductByDescrp(searchVar);
				break;

			case "Color":
				productList = productService.findProductByColor(searchVar);
				break;

			case "Dimension":
				productList = productService.findProductByDimension(searchVar);

			}
		} catch (NumberFormatException e) {

			error = "PoductID only accepts digits.";
			productList = (ArrayList<Product>) productService.findAll();

		}

		catch (Exception e) {

			error = "No entries returned.";
		}

		finally {
			String productCount = Integer.toString(productList.size());
			mav.addObject("productCount", productCount);

			mav.addObject("pList", productList);
		}
		return mav;
	}

	@RequestMapping(value = "editproduct-{partNumber}", method = RequestMethod.GET)
	public ModelAndView editProductPage(@PathVariable Integer partNumber) {
		
		ModelAndView mav = new ModelAndView("product-edit");
		Product product = productService.findProductByPartnumber(partNumber);
		
		ArrayList<Integer> supplierList = supplierService.findAllSupplierIDs();
		if (supplierList.isEmpty()) {
			mav.addObject("dropList",supplierList);
		}else {
			mav.addObject("dropList", supplierList);
		}
		mav.addObject("product", product);
		return mav;
	}

	@RequestMapping(value = "editproduct-{partNumber}", method = RequestMethod.POST)
	public ModelAndView editProduct(@ModelAttribute @Valid Product product, BindingResult result,
			@PathVariable Integer partNumber, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("product-edit");

		ModelAndView mav = new ModelAndView();
		String message = "product " + product.getPartNumber() + " was successfully updated.";

		productService.editProduct(product);
		mav.setViewName("redirect:/product/product-list");
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/deleteproduct/{partNumber}", method = RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute @Valid Product product, BindingResult result,
			@PathVariable Integer partNumber, final RedirectAttributes redirectAttributes) {

		ModelAndView mav = new ModelAndView("redirect:/product/product-list");
		Product p = productService.findProductByPartnumber(partNumber);
		productService.deleteProduct(p);
		String message = "The employee " + p.getPartNumber() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;

	}
	
	@RequestMapping(value = "/productcreate", method = RequestMethod.GET)
	public ModelAndView createget(@ModelAttribute Product product, HttpSession session, BindingResult result) {

		ModelAndView mav = new ModelAndView("product-add");
		
		List<Product> productList = productService.findAll();
		if (productList.isEmpty()) {
			mav.addObject("PK",1);
		}else {
			int lastPN =  productList.get(productList.size()-1).getPartNumber();
			String pkID = String.valueOf(lastPN+1);
			mav.addObject("PK", pkID);
		}
		
		ArrayList<Integer> supplierList = supplierService.findAllSupplierIDs();
		if (supplierList.isEmpty()) {
			mav.addObject("dropList",supplierList);
		}else {
			mav.addObject("dropList", supplierList);
		}
		return mav;

	}

	@RequestMapping(value = "/productcreate", method = RequestMethod.POST)
	public ModelAndView createpost(@ModelAttribute @Valid Product product, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("product-add");

		ModelAndView mav = new ModelAndView();
		String message = "New product " + product.getPartNumber() + " was successfully created.";
		
		productService.createProduct(product);
		mav.setViewName("redirect:/product/product-list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
}
package com.sa45.team3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "/product")
public class ProductControl {
	@Resource
	private ProductService productService;

	@RequestMapping(value = "/list")
	public ModelAndView productlist(Model model) {

		ModelAndView mav = new ModelAndView("product-list"); // create jsp
		List<Product> productList = productService.findAll();
		mav.addObject("pList", productList);
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
		mav.addObject("maxPages", ph.getPageCount()); // number of pages
		
		return mav;

	}

	@RequestMapping(value = "/product-show-list", method = RequestMethod.POST)
	public ModelAndView supplierListPageFilter(HttpServletRequest request) {

		String error;
		ModelAndView mav = new ModelAndView("product-show-list"); // create jsp
		String filter = request.getParameter("filter");
		String searchVar = request.getParameter("searchVar");
		ArrayList<Product> productList = new ArrayList<Product>();

		try {
			switch (filter) {

			case "ID":
				Integer searchInt = Integer.parseInt(searchVar);
				productList = productService.findProductByID(searchInt);
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

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView validation(@ModelAttribute Product product, HttpSession session, BindingResult result) {

		ModelAndView mav = new ModelAndView("product-list"); // create jsp
		// mav.addObject("message", product.getPassword());
		return mav;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView logout(@ModelAttribute Staff staff, HttpSession session, BindingResult result) {

		ModelAndView mav = new ModelAndView("logout");
		session.invalidate();
		return mav;

	}
}
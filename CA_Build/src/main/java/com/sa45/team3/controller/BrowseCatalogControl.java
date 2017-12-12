package com.sa45.team3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import com.sa45.team3.repository.ProductRepository;
import com.sa45.team3.repository.SupplierRepository;
import com.sa45.team3.service.ProductCatalogService;

@RequestMapping(value = "/mechanic")
@Controller
public class BrowseCatalogControl {
	
	@Autowired
	private ProductCatalogService prepo ;

/*	@Resource
	ProductRepository prepo;*/

	@RequestMapping(value = "/browse-catalog", method = RequestMethod.GET)
	public ModelAndView supplierListPage(@RequestParam(required = false) Integer page) {

		ModelAndView mav = new ModelAndView("browse-catalog"); // create jsp
		List<Product> productList = prepo.findAll();
		PagedListHolder<Product> ph = new PagedListHolder<>(productList);
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

	@RequestMapping(value = "/browse-catalog", method = RequestMethod.POST)
	public ModelAndView supplierListPageFilter(HttpServletRequest request) {

		String error;
		ModelAndView mav = new ModelAndView("browse-catalog"); // create jsp
		String filter = request.getParameter("filter");
		String searchVar = request.getParameter("searchVar");
		ArrayList<Product> productList = new ArrayList<Product>();

		try {
			switch (filter) {

			case "ID":
				Integer searchInt = Integer.parseInt(searchVar);
				productList.add(prepo.findProductByID(searchInt));
				break; // don't forget to BREAK!!!!!!!!!!!!!!!

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
		} catch (NumberFormatException e) {

			error = "PoductID only accepts digits.";
			productList = (ArrayList<Product>) prepo.findAll();

		}
		
		catch(Exception e) {
			
			error = "No entries returned.";
		}

		finally {
			String productCount = Integer.toString(productList.size());
			mav.addObject("productCount", productCount);

			mav.addObject("pList", productList);

			
		}
		return mav;

	}

}

package com.sa45.team3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import com.sa45.team3.model.Staff;
import com.sa45.team3.repository.ProductRepository;
import com.sa45.team3.repository.SupplierRepository;

import org.springframework.ui.Model;
@Controller
@RequestMapping(value="/product")
public class ProductControl{
	@Resource
	ProductRepository productRepository;	
	@RequestMapping(value="/list")
	public ModelAndView productlist(Model model) {
		
		ModelAndView mav = new ModelAndView("product-list"); //create jsp
		List<Product> productList = productRepository.findAll();
		mav.addObject("pList", productList);
		return mav;
		
	}
	
	
	@RequestMapping(value="/create", method= RequestMethod.POST)
	public ModelAndView validation(@ModelAttribute Product product, HttpSession session, BindingResult result) {
		
		
		ModelAndView mav = new ModelAndView("product-list"); //create jsp
		//mav.addObject("message", product.getPassword());
		return mav;
		
	}
	
	
	@RequestMapping(value="/edit", method= RequestMethod.GET)
	public ModelAndView logout(@ModelAttribute Staff staff, HttpSession session, BindingResult result) {
		
		ModelAndView mav = new ModelAndView("logout");
		session.invalidate();
		return mav;
		
	}
}
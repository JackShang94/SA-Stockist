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
@RequestMapping(value="/Authorize")
public class AuthorizeControl{
	

	@RequestMapping(value="/login")
	public ModelAndView login(Model model) {
		
		ModelAndView mav = new ModelAndView("login"); //create jsp
		model.addAttribute(new Staff());
		return mav;
		
	}
	
	
	@RequestMapping(value="/validate", method= RequestMethod.POST)
	public ModelAndView validation(@ModelAttribute Staff staff, HttpSession session, BindingResult result) {
		
		ModelAndView mav = new ModelAndView("product-list"); //create jsp
		session.setAttribute("role", "admin");
		return mav;
		
	}
	
	
	@RequestMapping(value="/logout", method= RequestMethod.GET)
	public ModelAndView logout(@ModelAttribute Staff staff, HttpSession session, BindingResult result) {
		
		ModelAndView mav = new ModelAndView("login");
		session.invalidate();
		return mav;
		
	}
}
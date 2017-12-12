package com.sa45.team3.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sa45.team3.model.Staff;
import com.sa45.team3.service.ProductService;
import com.sa45.team3.service.StaffService;
@Controller
@RequestMapping(value="/Authorize")
@Resource

public class AuthorizeControl{
	
	@Resource
	private ProductService productService;
	@Autowired
	private StaffService sService;
	private HttpSession request;
	
	
	@RequestMapping(value="/login")
	public ModelAndView login(Model model) {
		
		ModelAndView mav = new ModelAndView("login"); //create jsp
		model.addAttribute(new Staff());
		return mav;
		
	}
	
	
	@RequestMapping(value="/validate", method= RequestMethod.POST)
	public ModelAndView validation(@ModelAttribute Staff staff, HttpSession session, BindingResult result) {
		ModelAndView mav=new ModelAndView("login");
		
		if(staff.getName().isEmpty() || staff.getPassword().isEmpty())
		{
			session.setAttribute("errorMessage", "Empty user or password");
			return mav;
		}else 
		{
			Staff s= sService.authenticate(staff.getName(), staff.getPassword());
			if(s!=null)
			{	
				if(s.getActive()!=0) {
					session.setAttribute("role", s.getRole());
					if (s.getRole().equalsIgnoreCase("Admin")) {
						mav =new ModelAndView("redirect:/product/product-list");
					}else {
						mav =new ModelAndView("redirect:/product/product-show-list");
					}
					return mav;
				}
				else
					{
						session.setAttribute("errorMessage", "User is not active");
						return mav;
					}
			}
			else {
				session.setAttribute("errorMessage", "Invalid user or password");
				return mav;
				
			}
			
		}
	}
	
	
	@RequestMapping(value="/logout", method= RequestMethod.GET)
	public ModelAndView logout(@ModelAttribute Staff staff, HttpSession session, BindingResult result) {
		
		ModelAndView mav = new ModelAndView("login");
		session.invalidate();
		return mav;
		
	}
}
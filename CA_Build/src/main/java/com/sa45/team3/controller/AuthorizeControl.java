package com.sa45.team3.controller;

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
import com.sa45.team3.service.StaffService;
@Controller
@RequestMapping(value="/Authorize")
public class AuthorizeControl{
	

	@Autowired
	private StaffService sService;
	
	@RequestMapping(value="/login")
	public ModelAndView login(Model model) {
		
		ModelAndView mav = new ModelAndView("login"); //create jsp
		model.addAttribute(new Staff());
		return mav;
		
	}
	
	
	@RequestMapping(value="/validate", method= RequestMethod.POST)
	public ModelAndView validation(@ModelAttribute Staff staff, HttpSession session, BindingResult result) {
		ModelAndView mav=new ModelAndView("login");
		
		if(staff.getName()!=null && staff.getPassword()!=null)
		{
			Staff s= sService.authenticate(staff.getName(), staff.getPassword());
			if(s!=null)
			{				
				session.setAttribute("role", s.getRole());
				if (s.getRole()=="Admin") {
					mav = new ModelAndView("product-list");
				}else {
					mav = new ModelAndView("product-show-list");
				}
				return mav;
			}
		}
		//create jsp
		
		return mav;
		
	}
	
	
	@RequestMapping(value="/logout", method= RequestMethod.GET)
	public ModelAndView logout(@ModelAttribute Staff staff, HttpSession session, BindingResult result) {
		
		ModelAndView mav = new ModelAndView("login");
		session.invalidate();
		return mav;
		
	}
}
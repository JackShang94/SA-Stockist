package com.sa45.team3.controller;

import java.util.ArrayList;

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
@RequestMapping(value="/home")
public class LoginControl {

	@Autowired
	private StaffService sService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String logic(Model model) {
		model.addAttribute("staff", new Staff());
		return "login";
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute Staff staff, HttpSession session, BindingResult result) {
		ModelAndView mav = new ModelAndView("login");
		if (result.hasErrors())
			return mav;
		else mav = new ModelAndView("redirect:/Mechanic/browse-catalog");
	/*	UserSession us = new UserSession();
		if (staff.getName() != null && staff.getPassword() != null) {
			Staff s = sService.authenticate(staff.getName(), staff.getPassword());
			us.setStaff(s);
			// PUT CODE FOR SETTING SESSION ID
			us.setSessionId(session.getId());
			us.setStaff(sService.findStaffById(us.getStaff().getId()));
			ArrayList<Staff> subordinates = sService.findSubordinates(us.getStaff().getId());
			if (subordinates != null) {
				us.setSubordinates(subordinates);

			}
			mav = new ModelAndView("redirect:/Mechanic/browse-catalog");
		} else {
			return mav;
		}
		session.setAttribute("USERSESSION", us); */
		return mav;
	}
}

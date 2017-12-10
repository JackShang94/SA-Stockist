package com.sa45.team3.controller;

import java.util.ArrayList;

//import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sa45.team3.model.Supplier;
//import com.sa45.team3.repository.SupplierRepository;
import com.sa45.team3.service.SupplierService;




@RequestMapping("/admin")
@Controller
public class AdminSupplierControl {

	@Autowired 
	SupplierService supService;
	
	

	
	/*@Resource
	SupplierRepository supRepository;*/
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView supplierListPage(HttpSession session) {
		ModelAndView mav = new ModelAndView("supplier-list");
		ArrayList<Supplier> supplierList = (ArrayList<Supplier>)supService.findAllSuppliers();//supRepository.findAll();
		mav.addObject("supplierList", supplierList);
		session.setAttribute("role", "admin");
		return mav;
	}
	
	
}



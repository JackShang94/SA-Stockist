package com.sa45.team3.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sa45.team3.model.Product;
import com.sa45.team3.model.UsageRecordDetails;
import com.sa45.team3.repository.ProductRepository;
import com.sa45.team3.repository.UsageRecordDetailsRepository;

@RequestMapping("/mechanic")
@Controller
public class UsageRecordSupportController {

	
	@Resource
	ProductRepository productRepository;	
	@Resource
	UsageRecordDetailsRepository urdRepo;

	
	@RequestMapping(value="/add-items", method= RequestMethod.GET)
	public ModelAndView productlist() {
		
		ModelAndView mav = new ModelAndView("add_usedproduct"); //create jsp
		List<Product> productList = productRepository.findAll();

		mav.addObject("pList", productList);

		return mav;
		
	}
	
/*	@RequestMapping(value="/add-items", method= RequestMethod.POST)
	public String productlist(HttpServletRequest Request, RedirectAttributes redirectAtttributes) {

		Map idToQty = Request.getParameterMap();
		redirectAtttributes.addFlashAttribute("idToQty", idToQty);
		urdRepo.addNewDetail(recordid, partnumber, usedquantity);
		
		return "redirect:/xxxx";
		
	}*/
	
	
}

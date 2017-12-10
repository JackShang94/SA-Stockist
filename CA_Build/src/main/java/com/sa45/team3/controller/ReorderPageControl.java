package com.sa45.team3.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sa45.team3.model.Product;
import com.sa45.team3.model.Staff;
import com.sa45.team3.model.Supplier;
import com.sa45.team3.repository.ProductRepository;

@RequestMapping(value = "/admin")
@Controller
public class ReorderPageControl {

	@Resource
	ReorderRepository reorderRepository;

	@RequestMapping(value = "/list")
	public ModelAndView reorderlist(Model model) {

		ModelAndView mav = new ModelAndView("reorder-page"); // create jsp
		List<Reorder> reorderList = reoderRepository.findAll();
		mav.addObject("rList", reorderList);
		return mav;
	}
}

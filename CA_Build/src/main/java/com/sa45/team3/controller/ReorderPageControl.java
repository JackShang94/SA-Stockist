package com.sa45.team3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sa45.team3.model.Product;
import com.sa45.team3.model.ReorderReport;
import com.sa45.team3.model.Reorders;
import com.sa45.team3.model.Staff;
import com.sa45.team3.model.Supplier;
import com.sa45.team3.repository.ProductRepository;
import com.sa45.team3.repository.ReorderRepository;
import com.sa45.team3.service.ProductService;
import com.sa45.team3.service.SupplierService;

@RequestMapping(value = "/reorder")
@Controller
public class ReorderPageControl {
	
	@Autowired
	ProductRepository ps;

	@Autowired
	private SupplierService sService;
	
	@Resource
	ReorderRepository reorderRepository;
	

	@RequestMapping(value="/lists",method=RequestMethod.GET)
	public ModelAndView reorder()
	{
		//Staff staff = new Staff();
		float sum = 0;
		ArrayList<Integer> sList = sService.findAllSupplierIDs();
		ArrayList<Product> reorderList = (ArrayList<Product>) ps.findAll();
		ArrayList<Integer> reorderQty = ps.findQty_ReorderQty();
		ArrayList<ReorderReport> reorderReports = new ArrayList<>();
		ModelAndView mv=new ModelAndView("reorder-page");
		for (int j = 0; j < reorderQty.size(); j++) {
			if (reorderQty.get(j)<=0) {
				if (reorderList.get(j).getMinOrder()<=Math.abs(reorderQty.get(j))) {
					ReorderReport reorderReport = new ReorderReport();
					reorderReport.setPartNumber(reorderList.get(j).getPartNumber());
					reorderReport.setUnitPrice(reorderList.get(j).getUnitPrice());
					reorderReport.setQuantity(reorderList.get(j).getQuantity());
					reorderReport.setReorderquantity(reorderList.get(j).getReorderPoint());
					reorderReport.setMinorderQty(reorderList.get(j).getMinOrder());
					reorderReport.setOrderQty(Math.abs(reorderQty.get(j)));
					reorderReport.setPrice(Math.abs(reorderQty.get(j))*reorderList.get(j).getUnitPrice());
					sum = (int) (sum + Math.abs(reorderQty.get(j))*reorderList.get(j).getUnitPrice());
					reorderReports.add(reorderReport);
				}else {
					ReorderReport reorderReport = new ReorderReport();
					reorderReport.setPartNumber(reorderList.get(j).getPartNumber());
					reorderReport.setUnitPrice(reorderList.get(j).getUnitPrice());
					reorderReport.setQuantity(reorderList.get(j).getQuantity());
					reorderReport.setReorderquantity(reorderList.get(j).getReorderPoint());
					reorderReport.setMinorderQty(reorderList.get(j).getMinOrder());
					reorderReport.setOrderQty(reorderList.get(j).getMinOrder());
					reorderReport.setPrice(reorderList.get(j).getMinOrder()*reorderList.get(j).getUnitPrice());
					sum = (int) (sum + reorderList.get(j).getMinOrder()*reorderList.get(j).getUnitPrice());
					reorderReports.add(reorderReport);
					
				}
			}else {
				ReorderReport reorderReport = new ReorderReport();
				reorderReport.setPartNumber(reorderList.get(j).getPartNumber());
				reorderReport.setUnitPrice(reorderList.get(j).getUnitPrice());
				reorderReport.setQuantity(reorderList.get(j).getQuantity());
				reorderReport.setReorderquantity(reorderList.get(j).getReorderPoint());
				reorderReport.setMinorderQty(reorderList.get(j).getMinOrder());
				reorderReport.setOrderQty(0);
				reorderReport.setPrice(0*reorderList.get(j).getUnitPrice());
				reorderReports.add(reorderReport);
			}
		}
		//ArrayList<staff> uList=uService.findAllUsers();
		mv.addObject("sList",sList);
		mv.addObject("reorderReport", reorderReports);
		mv.addObject("sum",sum);
		return mv;
	}
	
	@RequestMapping(value="/lists",method=RequestMethod.POST)
	public ModelAndView reorderCheck(HttpServletRequest request)
	{
		//Staff staff = new Staff();
		float sum = 0;
		ModelAndView mv= new ModelAndView("redirect:/reorder/lists");
		String filter = request.getParameter("select_supplier");
		if (filter.equals("ALL")) {
			return mv;
		}
	    Integer supplierID = Integer.valueOf(filter);
	    ArrayList<Integer> supplerIDs = new ArrayList<>();
	    supplerIDs.add(supplierID);
		ArrayList<Integer> sList = sService.findAllSupplierIDs();
		ArrayList<Product> reorderList = ps.findProductsBySupplier(supplierID);
		ArrayList<Integer> reorderQty = ps.findQty_ReorderQtyBysupplierID(supplierID);
		ArrayList<ReorderReport> reorderReports = new ArrayList<>();
		
		for (int j = 0; j < reorderQty.size(); j++) {
			if (reorderQty.get(j)<=0) {
				if (reorderList.get(j).getMinOrder()<=Math.abs(reorderQty.get(j))) {
					ReorderReport reorderReport = new ReorderReport();
					reorderReport.setPartNumber(reorderList.get(j).getPartNumber());
					reorderReport.setUnitPrice(reorderList.get(j).getUnitPrice());
					reorderReport.setQuantity(reorderList.get(j).getQuantity());
					reorderReport.setReorderquantity(reorderList.get(j).getReorderPoint());
					reorderReport.setMinorderQty(reorderList.get(j).getMinOrder());
					reorderReport.setOrderQty(Math.abs(reorderQty.get(j)));
					reorderReport.setPrice(Math.abs(reorderQty.get(j))*reorderList.get(j).getUnitPrice());
					sum = sum + Math.abs(reorderQty.get(j))*reorderList.get(j).getUnitPrice();
					reorderReports.add(reorderReport);
				}else {
					ReorderReport reorderReport = new ReorderReport();
					reorderReport.setPartNumber(reorderList.get(j).getPartNumber());
					reorderReport.setUnitPrice(reorderList.get(j).getUnitPrice());
					reorderReport.setQuantity(reorderList.get(j).getQuantity());
					reorderReport.setReorderquantity(reorderList.get(j).getReorderPoint());
					reorderReport.setMinorderQty(reorderList.get(j).getMinOrder());
					reorderReport.setOrderQty(reorderList.get(j).getMinOrder());
					reorderReport.setPrice(reorderList.get(j).getMinOrder()*reorderList.get(j).getUnitPrice());
					sum = sum + reorderList.get(j).getMinOrder()*reorderList.get(j).getUnitPrice();
					reorderReports.add(reorderReport);
					
				}
			}else {
				ReorderReport reorderReport = new ReorderReport();
				reorderReport.setPartNumber(reorderList.get(j).getPartNumber());
				reorderReport.setUnitPrice(reorderList.get(j).getUnitPrice());
				reorderReport.setQuantity(reorderList.get(j).getQuantity());
				reorderReport.setReorderquantity(reorderList.get(j).getReorderPoint());
				reorderReport.setMinorderQty(reorderList.get(j).getMinOrder());
				reorderReport.setOrderQty(0);
				reorderReport.setPrice(0*reorderList.get(j).getUnitPrice());
				reorderReports.add(reorderReport);
			}
		}
		
		mv = new ModelAndView("reorder-page");
		//ArrayList<staff> uList=uService.findAllUsers();
		mv.addObject("xlist", supplerIDs);
		mv.addObject("sList", sList);
		mv.addObject("reorderReport", reorderReports);
		mv.addObject("sum",sum);
		return mv;
	}

}

package com.sa45.team3.controller;


	import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
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

import com.sa45.team3.exception.staffNotFound;
import com.sa45.team3.model.Staff;
import com.sa45.team3.repository.StaffRepository;
import com.sa45.team3.service.StaffService;
import com.sa45.team3.validator.UserValidator;



	

	@Controller
	@RequestMapping("/staff")

	public class UserController {
		@Autowired
		private StaffService uService;
		
		@Resource
		private StaffRepository sRepo;

		@Autowired
		private UserValidator uValidator;
		
		@InitBinder("staff")
		private void initSupplierBinder(WebDataBinder binder) {
			binder.addValidators(uValidator);
		}
		
		@RequestMapping(value="/create",method=RequestMethod.GET)
		public ModelAndView newUserPage()
		{
			
			Staff staff = new Staff();
			ModelAndView mav=new ModelAndView("user-new","staff",staff);
			
			//ArrayList<staff> uList=uService.findAllUsers();
			mav.addObject("staff",staff);
			mav.setViewName("user-new");
			List<Staff> productList = sRepo.findAll();
			if (productList.isEmpty()) {
				mav.addObject("PK",null);
			}else {
				int lastPN =  productList.get(productList.size()-1).getStaffID();
				String pkID = String.valueOf(lastPN+1);
				mav.addObject("PK", pkID);
			}
			ArrayList<String> roleList=uService.findAllRole();
			if (roleList.isEmpty()) {
				mav.addObject("dropList",roleList);
			}else {
				mav.addObject("dropList", roleList);
			}
			
			return mav;
			
		}
		
		
		@RequestMapping(value = "/create", method = RequestMethod.POST)
		public ModelAndView createNewUser(@ModelAttribute @Valid Staff staff, BindingResult result,
				final RedirectAttributes redirectAttributes) {

			if (result.hasErrors()) {
				ModelAndView mav=new ModelAndView("user-new");
				ArrayList<String> roleList=uService.findAllRole();
				if (roleList.isEmpty()) {
					mav.addObject("dropList",roleList);
				}else {
					mav.addObject("dropList", roleList);
				}
				return mav;
				
			}

			ModelAndView mv = new ModelAndView();
			String message = "New user " + staff.getStaffID() + " was successfully created !!!";

			uService.createUser(staff);
			mv.setViewName("redirect:/staff/list");

			redirectAttributes.addFlashAttribute("message", message);
			return mv;
		}
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public ModelAndView userListPage() {
			ModelAndView mv = new ModelAndView("user-list");
			List<Staff> uList = uService.findAllUsers();
			mv.addObject("userList", uList);
			return mv;
		}
		@RequestMapping(value = "/edit-{id}", method = RequestMethod.GET)
		public ModelAndView editUserPage(@PathVariable Integer id) {
			ModelAndView mav = new ModelAndView("user-edit");
			Staff user = uService.findUser(id);
			mav.addObject("user", user);	
			ArrayList<Staff>uList=uService.findAllUsers();
			mav.addObject("uList", uList);
			mav.setViewName("user-edit");
			ArrayList<String> roleList=uService.findAllRole();
			if (roleList.isEmpty()) {
				mav.addObject("dropList",roleList);
			}else {
				mav.addObject("dropList", roleList);
			}
			return mav;
		}

		@RequestMapping(value = "/edit-{id}", method = RequestMethod.POST)
		public ModelAndView editUser(@ModelAttribute @Valid Staff staff, BindingResult result, @PathVariable Integer id,
				final RedirectAttributes redirectAttributes) throws staffNotFound {

			if (result.hasErrors())
				return new ModelAndView("user-edit");

			ModelAndView mav = new ModelAndView("redirect:/staff/list");
			String message = "User was successfully updated.";

			uService.changeUser(staff);

			redirectAttributes.addFlashAttribute("message", message);
			return mav;
		}

		@RequestMapping(value = "/delete-{id}", method = RequestMethod.GET)
		public ModelAndView deleteUser(@PathVariable String id, final RedirectAttributes redirectAttributes)
				throws staffNotFound {
			int idInt=Integer.parseInt(id);
			ModelAndView mav = new ModelAndView("redirect:/staff/list");
			Staff staff = uService.findUser(idInt);
			uService.removeUser(staff);
			String message = "The user " + staff.getStaffID() + " was successfully deleted.";

			redirectAttributes.addFlashAttribute("message", message);
			return mav;
		}
		

		

	}




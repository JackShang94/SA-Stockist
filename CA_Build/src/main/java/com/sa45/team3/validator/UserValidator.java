package com.sa45.team3.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sa45.team3.model.Staff;

@Component
public class UserValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> arg0) {
		return Staff.class.isAssignableFrom(arg0);

	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Staff staff = (Staff) arg0;
		ValidationUtils.rejectIfEmpty(arg1, "staffID", "Enter staff ID! ");
		ValidationUtils.rejectIfEmpty(arg1, "name", "Enter staff Name! ");
		ValidationUtils.rejectIfEmpty(arg1, "password", "Enter password! ");
		
		ValidationUtils.rejectIfEmpty(arg1, "role", "Enter role! ");
		ValidationUtils.rejectIfEmpty(arg1, "contactNumber", "Enter Contact Number! ");
		
		System.out.println(staff.toString());
	}

}

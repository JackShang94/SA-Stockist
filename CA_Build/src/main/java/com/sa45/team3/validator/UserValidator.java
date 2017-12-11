package com.sa45.team3.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sa45.team3.model.Staff;


@Component
public class UserValidator implements Validator  {
	@Override
	public boolean supports(Class<?> clazz) {
		return Staff.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Staff s = (Staff) target;
		ValidationUtils.rejectIfEmpty(errors, "staffID", "Staff Id cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "name", "Name cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "contactNumber", "Contact number cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "Password cannot be empty");
		System.out.println(s.toString());
	}
	

}

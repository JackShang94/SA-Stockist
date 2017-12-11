package com.sa45.team3.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sa45.team3.model.Supplier;


@Component
public class SupplierValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return Supplier.class.isAssignableFrom(arg0);

	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Supplier supplier = (Supplier) arg0;
		ValidationUtils.rejectIfEmpty(arg1, "supplierID", "Enter Supplier ID! ");
		ValidationUtils.rejectIfEmpty(arg1, "supplierName", "Enter Supplier Name! ");
		ValidationUtils.rejectIfEmpty(arg1, "contactNumber", "Enter Contact Number! ");
		ValidationUtils.rejectIfEmpty(arg1, "address", "Enter Address! ");
		ValidationUtils.rejectIfEmpty(arg1, "contactPerson", "Enter Contact Person! ");
		System.out.println(supplier.toString());
	}
}

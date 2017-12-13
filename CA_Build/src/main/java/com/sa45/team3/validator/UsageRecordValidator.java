package com.sa45.team3.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sa45.team3.model.UsageRecord;
import com.sa45.team3.model.UsageRecord;

@Component
public class UsageRecordValidator  implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return UsageRecord.class.isAssignableFrom(arg0);

	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		UsageRecord usageRecord = (UsageRecord) arg0;
		
		ValidationUtils.rejectIfEmpty(arg1, "contactNumber", "Enter contact Number! ");
		ValidationUtils.rejectIfEmpty(arg1, "customerName", "Enter customer Name! ");
		ValidationUtils.rejectIfEmpty(arg1, "usageDate", "Choose usage date! ");
		
		System.out.println(usageRecord.toString());
	}
}

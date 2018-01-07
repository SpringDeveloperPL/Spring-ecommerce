package com.ecommerce.customer.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.customer.service.CustomerService;
import com.ecommerce.customer.service.CustomerServiceImpl;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	@Autowired
	private CustomerService customerService;
	
	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String userName, ConstraintValidatorContext context) {
		if(customerService==null) {
			return true;
		}
		return customerService.findCustomerByName(userName)==null;
	}

}

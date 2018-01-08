/*
 * #%L 
 * BroadleafCommerce Profile Web 
 * %% 
 * Copyright (C) 2009 - 2013 Broadleaf Commerce 
 * %% 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 *  
 *       http://www.apache.org/licenses/LICENSE-2.0 
 *  
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 * #L% 
 */
package com.ecommerce.customer.controller.validator;

import com.ecommerce.customer.domain.Customer;
import com.ecommerce.customer.domain.forms.RegisterCustomerForm;
import com.ecommerce.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author bpolster
 */

@Component
public class RegisterCustomerValidator implements Validator {

	@Autowired
	CustomerService customerService;
	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public boolean supports(Class<?> clazz) {
		return RegisterCustomerForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		RegisterCustomerForm customerForm = (RegisterCustomerForm) target;

		String customerName = customerForm.getCustomer().getUserName();
		String email = customerForm.getCustomer().getEmailAdress();
		String password = customerForm.getPassword();
		String confPassword = customerForm.getPasswordConfirm();

		System.out.println(customerForm.getPasswordConfirm());

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Validator.customerForm..password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "Validator.customerForm..passwordConfirm");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customer.userName", "Validator.customerForm..userName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customer.userName", "Validator.customerForm..userName.nul");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customer.emailAdress", "Validator.customerForm..email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customer.emailAdress", "Validator.customerForm..email.double");

		Customer customer = customerService.findCustomerByName(customerName);

		if (customerName == null) {
			errors.rejectValue("customer.userName", "Validator.customerForm..userName.null");

		} else if (!(customer == null) && (customerName.length() > 0)) {
			errors.rejectValue("customer.userName", "Validator.customerForm..userName");
		}
		
		if (!(email != null && email.isEmpty())) {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(email);
			if (!matcher.matches()) {
				errors.rejectValue("customer.emailAdress", "Validator.customerForm..email");
			}
		}
		
		if(customerService.isDoubleEmail(email)==true){
			errors.rejectValue("customer.emailAdress", "Validator.customerForm..email.double");

		}

		// Business validation
		if (!password.equals(confPassword)) {
			errors.rejectValue("password", "Validator.customerForm..password");
			errors.rejectValue("passwordConfirm", "Validator.customerForm..passwordConfir");
		}

	}

}
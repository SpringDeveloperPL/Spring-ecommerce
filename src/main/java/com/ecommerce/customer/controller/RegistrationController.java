/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.customer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.ResourceEditorRegistrar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.customer.controller.validator.RegisterCustomerValidator;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.customer.domain.forms.RegisterCustomerForm;
import com.ecommerce.customer.service.CustomerService;

/**
 *
 * @author Daniel
 */

@Controller
public class RegistrationController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	RegisterCustomerValidator registerCustomerValidator;

	@RequestMapping("/registration")
	public String customerRegistration() {

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerCustomer(@ModelAttribute("registerCustomerForm")@Valid RegisterCustomerForm registerCustomerForm, BindingResult bindingResult) {
		registerCustomerValidator.validate(registerCustomerForm, bindingResult);

		if(bindingResult.hasErrors()) {			
			return "registration";
		}else 
		customerService.registerCustomer(registerCustomerForm.getCustomer(),registerCustomerForm.getPassword(), registerCustomerForm.getPasswordConfirm());
	
		return "redirect:registration?success=true";
	}
	


	@ModelAttribute("registerCustomerForm")
	public RegisterCustomerForm initCustomerRegistrationForm() {
		RegisterCustomerForm customerRegistrationForm = new RegisterCustomerForm();
		Customer customer = customerService.createCustomer(new Customer());
		customerRegistrationForm.setCustomer(customer);
		return customerRegistrationForm;

	}
	
	public RegisterCustomerValidator getCustomerValidator() {
		return registerCustomerValidator;
	}

	public void setCustomerValidator(RegisterCustomerValidator customerValidator) {
		this.registerCustomerValidator = customerValidator;
	}

	
//	
//	@InitBinder
//	public void initialiseBinder(WebDataBinder binder) {
//	binder.setAllowedFields("customer.userName");
//	binder.setValidator(registerCustomerValidator);
//	}

}

package com.ecommerce.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginCustomerController {

	@RequestMapping("/customer-account")
	public String customerLoginGetway() {
		
		return "customer-account";
	}
	
	@RequestMapping("/sign-in")
	public String customerLogin() {
		
		return "sign-in";
	}
	

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
		model.addAttribute("error", "true");
		return "sign-in";
	}

	

}

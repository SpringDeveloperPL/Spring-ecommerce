package com.ecommerce.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginAdminController {

	@RequestMapping("/admin")
	public String admin(){
		return "dashboard";
	}
	@RequestMapping("/dashboard")
	public String dishboard(){
		return "dashboard";
	}

	@RequestMapping("/admlogin")
	public String loginAuthorizationRedirect() {

		return "admlogin";
	}

	@RequestMapping("/customer-logout")
	public String customerLogoutPage() {
		return "logout";
	}

	@RequestMapping("/logout")
	public String adminLogoutPage() {
		return "logout";
	}
}

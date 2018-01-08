package com.ecommerce.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

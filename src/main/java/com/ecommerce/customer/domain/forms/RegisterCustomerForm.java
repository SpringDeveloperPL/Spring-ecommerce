package com.ecommerce.customer.domain.forms;

import com.ecommerce.customer.domain.Customer;

import javax.validation.constraints.Size;

public class RegisterCustomerForm {

	
	private Customer customer;
	@Size(min = 6, message = "Password must at least 6 characters")
	private String password;
	@Size(min = 6, message = "{Size.RegisterCustomerForm.password.validation}")
	private String passwordConfirm;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	protected String redirectUrl;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

}

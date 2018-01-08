package com.ecommerce.customer.service;

import com.ecommerce.customer.domain.Customer;
import com.ecommerce.customer.domain.CustomerRole;

import java.util.List;

public interface CustomerService {

	public Customer createCustomer (Customer customer);
	public void createRegisteredCustomerRoles(Customer customer);
	public Customer saveCustomer(Customer customer);
	public Customer saveCustomer(Customer customer,boolean registred);
	public Customer createNewCustomer();
	public void registerCustomer(Customer customer, String password, String passwordConfirm);
	public Customer findCustomerByName(String username);
	public CustomerRole readRoleByCustomerRoleiD(long customerRoleId);
	public Boolean isDoubleEmail(String email);
	public List<CustomerRole> findAllCustomerRole();
}

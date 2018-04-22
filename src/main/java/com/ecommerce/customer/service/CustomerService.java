package com.ecommerce.customer.service;

import com.ecommerce.customer.domain.Customer;
import com.ecommerce.customer.domain.CustomerRole;
import com.ecommerce.customer.domain.Role;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
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

	/**
	 * Check if pressed e-mail is used for any Cnustomer
	 * @param email
	 * @return
	 */
	public Boolean isEmailUsed(String email);
	public List<CustomerRole> findAllCustomerRole();

	/**
	 * Find Customer by Email
	 * @param email
	 * @return
	 */
	public Customer getCustomerByEmail(String email);

	public List<Customer> findAllCustomers();

	/**
	 * Getting list of all Customer Roles
	 * @param username
	 * @return
	 */
	public List<Role> getAllCustomerRole(String username);

	/**
	 * Getting list of All Customer Grand Authority
	 * @param username
	 * @return
	 */
	public Collection<GrantedAuthority> getAllCustomerGrandAuthority(String username);

	/**
	 * Getting Logged Customer
	 * @return
	 */
	public Customer getLoggedCustomer();


}

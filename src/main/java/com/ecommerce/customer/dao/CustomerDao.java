package com.ecommerce.customer.dao;

import com.ecommerce.customer.domain.Customer;

import java.util.List;

public interface CustomerDao {

	public Customer save(Customer customer);	
	public Customer findCustomerById(int userId);
	public Customer findCustomerByName(String username);

	/**
	 * Find Customer by Email DAO
	 * @param email
	 * @return
	 */
    Customer getCustomerByEmail(String email);


	/**
	 * Getting list of all customers
	 * @return
	 */
	List<Customer> findAllCustomers();

	/**
	 * Update Customer
	 * @param customer
	 */
	void updateCustomer(Customer customer);
}

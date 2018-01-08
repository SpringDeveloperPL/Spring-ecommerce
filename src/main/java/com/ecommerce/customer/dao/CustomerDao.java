package com.ecommerce.customer.dao;

import com.ecommerce.customer.domain.Customer;

public interface CustomerDao {

	public Customer save(Customer customer);	
	public Customer findCustomerById(int userId);
	public Customer findCustomerByName(String username);
	public Boolean isDoubleMail(String adressEmail);
}

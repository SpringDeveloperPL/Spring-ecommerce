package com.ecommerce.customer.dao;

import com.ecommerce.customer.domain.Adress;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.customer.domain.CustomerAdress;

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

	/**
	 * Getting all Customer Adress
	 * @return
	 */
    List<CustomerAdress> getAllCustomerAdress();

	/**
	 * Gettng Customer Adress
	 * @param customer
	 * @return
	 */
	Adress getAdress(Long customer);

	/**
	 * Save or Update Customer Adress
	 * @param customerAdress
	 */
    void saveOrUpdateAdress(Adress customerAdress);

	/**
	 * Save or update Customer Adress
	 * @param customerAdress
	 */
	void saveOrUpdateCustomerAdress(CustomerAdress customerAdress);
}

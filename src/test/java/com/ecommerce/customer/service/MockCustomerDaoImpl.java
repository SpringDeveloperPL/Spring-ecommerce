package com.ecommerce.customer.service;

import com.ecommerce.customer.dao.CustomerDao;
import com.ecommerce.customer.domain.Adress;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.customer.domain.CustomerAdress;

import java.util.ArrayList;
import java.util.List;

public class MockCustomerDaoImpl implements CustomerDao {

    List<Customer> customerList = new ArrayList<>();

    MockCustomerDaoImpl() {
        Customer customer = new Customer();
        customer.setUserName("kowalski");
        customer.setEmailAdress("kowalski@wp.pl");
        customer.setIsRegistred(true);
        customerList.add(customer);
    }

    @Override
    public Customer save(Customer customer) {
        customerList.add(customer);
        return customer;
    }

    @Override
    public Customer findCustomerById(int userId) {
        return null;
    }

    @Override
    public Customer findCustomerByName(String username) {
        Customer customer = new Customer();
        customer.setUserName("kowalski");
        return customer;
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        for (Customer customer : customerList) {
            if(customer.getEmailAdress().equals(email)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public List<CustomerAdress> getAllCustomerAdress() {
        return null;
    }

    @Override
    public Adress getAdress(Long customer) {
        return null;
    }

    @Override
    public void saveOrUpdateAdress(Adress customerAdress) {

    }

    @Override
    public void saveOrUpdateCustomerAdress(CustomerAdress customerAdress) {

    }
}

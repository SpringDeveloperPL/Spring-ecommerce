package com.ecommerce.customer.service;

import com.ecommerce.customer.domain.Customer;
import com.ecommerce.customer.domain.Role;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.*;


public class CustomerServiceImplTest {

    CustomerServiceImpl customerService;
    MockCustomerDaoImpl customerDao;
    Customer customer;

    @Before
    public void setUp() throws Exception {
    customerDao = new MockCustomerDaoImpl();
    customerService= new CustomerServiceImpl(customerDao);
    customer = new Customer();
    customer.setEmailAdress("kowalski@wp.pl");
    customer.setIsRegistred(true);
    customer.setUserName("kowalski");
    }

    @Test
    public void saveCustomer() throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        customer.setPassword(passwordEncoder.encode("password"));
        customerService.saveCustomer(customer);
        Customer customer =customerService.getCustomerByEmail("kowalski@wp.pl");
        assertEquals(true,customer.getIsRegistred());
    }

    @Test
    public void findCustomerByName() throws Exception {
        Customer customer = customerService.findCustomerByName("kowalski");
        assertEquals("kowalski",customer.getUserName());
    }

    @Test
    public void isEmailUsed() throws Exception {
        boolean isEmailUserd = false;
        isEmailUserd=customerService.isEmailUsed("kowalski@wp.pl");
        assertEquals(true,isEmailUserd);
    }
    @Test
    public void createRegisteredCustomerRoles() throws Exception {
    }


    @Test
    public void registerCustomer() throws Exception {
    }

    @Test
    public void readRoleByCustomerRoleiD() throws Exception {
    }

    @Test
    public void findAllCustomerRole() throws Exception {
    }

    @Test
    public void getCustomerByEmail() throws Exception {
    }

    @Test
    public void findAllCustomers() throws Exception {
    }

    @Test
    public void getAllCustomerRole() throws Exception {
    }

    @Test
    public void getAllCustomerGrandAuthority() throws Exception {
    }

    @Test
    public void getLoggedCustomer() throws Exception {
    }

    @Test
    public void getAllCustomerAdress() throws Exception {
    }

    @Test
    public void getCustomerAdress() throws Exception {
    }

    @Test
    public void saveAdress() throws Exception {
    }

    @Test
    public void saveCustomerAdres() throws Exception {
    }


}
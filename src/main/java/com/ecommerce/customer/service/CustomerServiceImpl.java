package com.ecommerce.customer.service;

import com.ecommerce.cart.service.CartService;
import com.ecommerce.customer.dao.CustomerDao;
import com.ecommerce.customer.dao.RoleDao;
import com.ecommerce.customer.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	@Autowired
	RoleDao roleDao;
	@Autowired
	CartService cartService;

	CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		customer.setIsRegistred(true);

		return customer;
	}

	@Override
	public void createRegisteredCustomerRoles(Customer customer) {

		List<Role> roleList = roleDao.findAllRole();
		Role nameCustomerRole = null;
		for(Role role : roleList) {
		if(role.getRoleName().equals("ROLE_CUSTOMER")) {
			nameCustomerRole=role;
		}
	}
		CustomerRole customerRole = new CustomerRole();
		customerRole.setRole(nameCustomerRole);
		customerRole.setCustomer(customer);
		roleDao.addRoleToCustomer(customerRole);

	}

	public Customer saveCustomer(Customer customer) {
		return saveCustomer(customer, customer.getIsRegistred());
	}

	@Override
	public Customer saveCustomer(Customer customer, boolean registred) {

		return customerDao.save(customer);
	}

	@Override
	public Customer createNewCustomer() {
		// TODO Auto-generated method stub
		return new Customer();
	}

	@Override
	public void registerCustomer(Customer customer, String password, String passwordConfirm) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//cripting password
		customer.setPassword(encoder.encode(password));
		//saving Customer
		saveCustomer(customer, true);
		//register Customer Role
		createRegisteredCustomerRoles(customer);
		//Creating Customer Cart
		cartService.createCustomerCard(customer);

	}

	@Override
	public Customer findCustomerByName(String username) {
		
		Customer customer =customerDao.findCustomerByName(username);
		return customer;
	}

	public CustomerRole readRoleByCustomerRoleiD(long customerRoleId) {
		
		CustomerRole customerRole = roleDao.readRoleByCustomerRoleiD(customerRoleId);
		return customerRole;
	}

	@Override
	public Boolean isEmailUsed(String email) {

		if(customerDao.getCustomerByEmail(email)==null) {
			return false;

		}else return true;
	}


	@Override
	public List<CustomerRole> findAllCustomerRole() {
		return roleDao.findAllCustomerRole();
	}

	@Override
	public Customer getCustomerByEmail(String email) {

		return customerDao.getCustomerByEmail(email);
	}

	@Override
	public List<Customer> findAllCustomers() {
		return customerDao.findAllCustomers();
	}

	@Override
	public List<Role> getAllCustomerRole(String username) {

		List<CustomerRole> customerRoleList = roleDao.findAllCustomerRole();
		List<Role> roleList = new ArrayList<>();

		for (CustomerRole customerRole : customerRoleList) {
			if (customerRole.getCustomer().getUserName().equals(username)) {
				roleList.add(customerRole.getRole());
			}
		}
		return roleList;
	}

	@Override
	public Collection<GrantedAuthority> getAllCustomerGrandAuthority(String username) {

		Collection<GrantedAuthority> authorityCollection = new ArrayList<>();
		List<Role> roleList = getAllCustomerRole(username);

		if(roleList!=null) {
			for (Role role : roleList) {
				authorityCollection.add(new SimpleGrantedAuthority(role.getRoleName()));
			}
		}

		return authorityCollection;
	}

	@Override
	public Customer getLoggedCustomer() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String custoemrName = auth.getName();
		Customer customer = findCustomerByName(custoemrName);
		return customer;
	}

	@Override
	public boolean isCustomerAdresEntered(Customer customer) {

		List<CustomerAdress> customerAdressesList = getAllCustomerAdress();
		boolean isCustomerAdresEntered= false;
		for (CustomerAdress customerAdress : customerAdressesList) {
			if(customerAdress.getCustomer().getCustomerId()==customer.getCustomerId()){
				isCustomerAdresEntered=true;
			}else isCustomerAdresEntered = false;
		}
		return isCustomerAdresEntered;
	}

	@Override
	public List<CustomerAdress> getAllCustomerAdress() {

		return customerDao.getAllCustomerAdress();
	}

	@Override
	public Adress getAdress(Long adressID) {
		return customerDao.getAdress(adressID);
	}

	@Override
	public Adress getCustomerAdress(Customer customer) {
		List<CustomerAdress> customerAdressList = getAllCustomerAdress();
		Adress adress= new Adress();
		Long adressID = new Long(0);
		for (CustomerAdress customerAdress : customerAdressList) {
			if(customerAdress.getCustomer().getCustomerId()==customer.getCustomerId()){
			adressID = customerAdress.getAdress().getAdressId();
			adress.setAdressId(adressID);
			}
		}
		adress = getAdress(adressID);
		return adress;
	}

	@Override
	public void saveAdress(Adress customerAdress) {
		customerDao.saveOrUpdateAdress(customerAdress);
	}

	@Override
	public void saveCustomerAdres(CustomerAdress cs) {
		customerDao.saveOrUpdateCustomerAdress(cs);
	}
}

package com.ecommerce.customer.dao;

import java.util.List;
import java.util.Set;

import com.ecommerce.customer.domain.Customer;
import com.ecommerce.customer.domain.CustomerRole;
import com.ecommerce.customer.domain.Role;

public interface RoleDao {
	
	public void addRoleToCustomer(CustomerRole customerRole);
	public Role readRoleById(Long roleId);
	public CustomerRole readRoleByCustomer(Customer customer);
	public CustomerRole readRoleByCustomerRoleiD(long customerRoleId);
	public List<CustomerRole> findAllCustomerRole();

	/**
	 * Creating new Role available into System
	 * @param role
	 */
	public void createRole(Role role);

	/**
	 * Getting Roles by Name
	 * @param name
	 * @return
	 */
	Role getRoleByName(String name);

	/**
	 * Find all Roles in system
	 * @return
	 */
	List<Role> findAllRole();
}

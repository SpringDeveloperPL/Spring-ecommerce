package com.ecommerce.customer.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.customer.domain.Customer;
import com.ecommerce.customer.domain.CustomerRole;
import com.ecommerce.customer.service.CustomerService;

@Service("userDetailsService")
public class CustomerDetailsServiceImpl implements UserDetailsService {

	@Autowired
	CustomerService customerService;

	@SuppressWarnings("deprecation")
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//getting customer from form 
//		Customer customer = customerService.findCustomerByName(username);
		Customer customer = null;
		List<CustomerRole> customerRoleList= customerService.findAllCustomerRole();
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (CustomerRole customerRole : customerRoleList) {
			if(customerRole.getCustomer().getUserName().equals(username)) {
				customer = customerRole.getCustomer();
				authorities.add(new SimpleGrantedAuthority(customerRole.getRole().getRoleName()));

			}
		}

		if (customer != null) {
			//custmer password is encrypted
			String password = customer.getPassword();
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
		
			org.springframework.security.core.userdetails.User securityUser = new User(username, password, enabled,
					accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

			return securityUser;

		} else
			throw new UsernameNotFoundException("User not found");

	}

}

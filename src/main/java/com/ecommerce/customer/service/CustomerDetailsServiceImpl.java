package com.ecommerce.customer.service;

import com.ecommerce.customer.domain.Customer;
import com.ecommerce.customer.domain.CustomerRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userDetailsService")
public class CustomerDetailsServiceImpl implements UserDetailsService {

	@Autowired
	CustomerService customerService;

	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Collection<GrantedAuthority> authorities = customerService.getAllCustomerGrandAuthority(username);
		Customer customer = customerService.findCustomerByName(username);

		if (customer != null) {

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

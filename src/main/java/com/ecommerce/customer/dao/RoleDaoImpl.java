package com.ecommerce.customer.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.customer.domain.Customer;
import com.ecommerce.customer.domain.CustomerRole;
import com.ecommerce.customer.domain.Role;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {
	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}


	@Override

	public void addRoleToCustomer(CustomerRole customerRole) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(customerRole);
		tx.commit();
		session.close();

	}

	@Override
	public Role readRoleById(Long roleId) {
		
		Session session = getCurrentSession();
		Role role= session.get(Role.class,new Long(roleId));
		return role;
	}

	@Override
	public CustomerRole readRoleByCustomer(Customer customer) {
		Session session = getCurrentSession();
		CustomerRole role= session.get(CustomerRole.class,customer);
		
		return role;
	}

	@Override
	public CustomerRole readRoleByCustomerRoleiD(long customerRoleId) {
				
		Session session = getCurrentSession();
		CustomerRole custoemrRole= session.get(CustomerRole.class,customerRoleId);
		
		return custoemrRole;
		
		
	}


	@Override
	public List<CustomerRole> findAllCustomerRole() {
		Session session = getCurrentSession();
		return session.createCriteria(CustomerRole.class).list();
	}

	@Override
	public void createRole(Role role) {
		Session session = getCurrentSession();
		session.save(role);
	}

	@Override
	public Role getRoleByName(String name) {
		Session session= getCurrentSession();
		Criteria criteria = session.createCriteria(Role.class);
		criteria.add(Restrictions.eq("roleName", name));
		Role role = (Role) criteria.uniqueResult();
		return role;
	}

	@Override
	public List<Role> findAllRole() {
		Session session = getCurrentSession();
		return session.createCriteria(Role.class).list();
	}


}

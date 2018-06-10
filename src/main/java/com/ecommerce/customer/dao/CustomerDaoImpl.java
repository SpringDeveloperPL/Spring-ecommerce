package com.ecommerce.customer.dao;


import com.ecommerce.category.domain.Category;
import com.ecommerce.customer.domain.Adress;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.customer.domain.CustomerAdress;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Repository("CustomerDaoImpl")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory sessionFactory;	

	public SessionFactory getSessionFactory() {
	
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Customer save(Customer customer) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(customer);
		tx.commit();
		session.close();
		return customer;
	}

	@Override
	public Customer findCustomerById(int userId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Customer.class, userId);
	}

	@Override
	public Customer findCustomerByName(String username) {

		Customer customer = null;		
		Session session = this.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("userName", username));
		customer = (Customer) criteria.uniqueResult();
		tx.commit();
		session.close();
		return customer;
	}

	@Override
	public Customer getCustomerByEmail(String email) {

		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("emailAdress",email));
		Customer customer = (Customer) criteria.uniqueResult();
		return customer;
	}

	@Override
	public List<Customer> findAllCustomers() {
		Session session = getCurrentSession();
		return 	session.createCriteria(Customer.class).list();

	}

	@Override
	public void updateCustomer(Customer customer) {
		Session session = getCurrentSession();
		session.update(customer);
	}

	@Override
	public List<CustomerAdress> getAllCustomerAdress() {
		Session session = getCurrentSession();
		return session.createCriteria(CustomerAdress.class).list();
	}

	@Override
	public Adress getAdress(Long adressID) {

		Session session= getCurrentSession();
		Criteria criteria = session.createCriteria(Adress.class);
		criteria.add(Restrictions.eq("adressId",new Long(adressID)));
		Adress adress = (Adress) criteria.uniqueResult();
		return adress;
	}

	@Override
	public void saveOrUpdateAdress(Adress customerAdress) {
		Session session = getCurrentSession();
		session.saveOrUpdate(customerAdress);
	}

	@Override
	public void saveOrUpdateCustomerAdress(CustomerAdress customerAdress) {
		Session session = getCurrentSession();
		session.saveOrUpdate(customerAdress);
	}


}

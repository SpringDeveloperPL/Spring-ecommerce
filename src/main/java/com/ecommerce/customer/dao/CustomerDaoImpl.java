package com.ecommerce.customer.dao;


import com.ecommerce.customer.domain.Customer;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory sessionFactory;	

	public SessionFactory getSessionFactory() {
	
		return sessionFactory;
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
	public Boolean isDoubleMail(String adressEmail) {
		Customer customer = null;	
		Boolean flag=false;
		Session session = this.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		
		String selectQuery = "FROM Customer where emailAdress= :usernameParam";
		Query query = session.createQuery(selectQuery);
		query.setParameter("usernameParam", adressEmail);
		
		if(!(query.list().isEmpty())) {
			flag=true;
		}else flag = false;
		tx.commit();
		session.close();
		
		return flag;
	}


}

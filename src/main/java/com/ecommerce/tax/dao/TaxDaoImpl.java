package com.ecommerce.tax.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.category.domain.Category;
import com.ecommerce.product.doimain.Tax;

@Repository
@Transactional
public class TaxDaoImpl implements TaxDao {

	@Autowired
	SessionFactory sessionFactory;
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Tax> fintAllTaxes() {
		List<Tax> allTaxes = new ArrayList<>();
		allTaxes = getCurrentSession().createCriteria(Tax.class).list();
		return allTaxes;
	}

	@Override
	public void createTax(Tax tax) {
		Session session= getCurrentSession();
		session.saveOrUpdate(tax);
	}

	@Override
	public Tax findTaxByName(String taxName) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Tax.class);
		criteria.add(Restrictions.eq("name",taxName));
		Tax tax = (Tax) criteria.uniqueResult();
		return tax;
	}

}

package com.ecommerce.manufacturer.dao;

import com.ecommerce.product.doimain.Manufacturer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ManufacturerDaoImpl implements ManufacturerDao {

	@Autowired
	SessionFactory sessionFactory;
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	
	@Override
	public List<Manufacturer> fintAllManufacturers() {
		List<Manufacturer> allManufacturer = getCurrentSession().createCriteria(Manufacturer.class).list();
		return allManufacturer;
	}

	@Override
	public void addNewManufacturer(Manufacturer manufacturer) {
		Session session = getCurrentSession();
		session.save(manufacturer);
	}

	@Override
	public Manufacturer getManufacturerById(Long id) {
		Session session =getCurrentSession();
		return session.get(Manufacturer.class,id);
	}

	@Override
	public void removeManufacturer(Manufacturer manufacturer) {
		Session session = getCurrentSession();
		session.delete(manufacturer);
	}

}

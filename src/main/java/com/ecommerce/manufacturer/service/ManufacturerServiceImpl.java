package com.ecommerce.manufacturer.service;

import com.ecommerce.manufacturer.dao.ManufacturerDao;
import com.ecommerce.product.doimain.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	ManufacturerDao manufacturerDao;
	
	@Override
	public List<Manufacturer> fintAllManufacturers() {
		return manufacturerDao.fintAllManufacturers();
	}

	@Override
	public List<String> gedAllNamedManufacturers() {
		List<String> namedManufacturers = new  ArrayList<>();
		List<Manufacturer> manufacturers = fintAllManufacturers();
		
		for (Manufacturer manufacturer : manufacturers) {
			namedManufacturers.add(manufacturer.getName());
		}
		return namedManufacturers;
	}

	@Override
	public void addNewManufacturer(Manufacturer manufacturer) {
		manufacturerDao.addNewManufacturer(manufacturer);
	}

	@Override
	public Manufacturer getManufacturerById(Long id) {
		return manufacturerDao.getManufacturerById(id);
	}

	@Override
	public void removeManufacturer(Manufacturer manufacturer) {
		manufacturerDao.removeManufacturer(manufacturer);
	}

}

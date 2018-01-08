package com.ecommerce.tax.service;

import com.ecommerce.product.doimain.Tax;
import com.ecommerce.tax.dao.TaxDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaxServiceImpl implements TaxService {

	@Autowired
	TaxDao taxDao;

	public List<Tax> fintAllTaxes() {
		return taxDao.fintAllTaxes();
	}

	@Override
	public List<String> gedAllNamedTaxes() {
		List<String> namedTaxList = new ArrayList<>();
		List<Tax> taxList = fintAllTaxes();
		for (Tax tax : taxList) {
			namedTaxList.add(tax.getName());
		}
		return namedTaxList;
	}

	@Override
	public void createTax(Tax tax) {
		taxDao.createTax(tax);
	}

	@Override
	public boolean isSetTax(String taxName) {

		Tax tax = taxDao.findTaxByName(taxName);

		if(tax!=null) {
			return true;
		}else  return false;
	}

	@Override
	public Tax findTaxByName(String taxName) {
		return taxDao.findTaxByName(taxName);
	}

}
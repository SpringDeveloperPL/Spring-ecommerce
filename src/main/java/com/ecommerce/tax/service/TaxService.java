package com.ecommerce.tax.service;

import com.ecommerce.product.doimain.Tax;

import java.util.List;

public interface TaxService {

	public List<Tax> fintAllTaxes();
	public List<String> gedAllNamedTaxes();

	/**
	 * Creating new Tax role
	 * @param tax
	 */
	public void createTax(Tax tax);

	/**
	 * Checking if tax exist
	 * If Tax exist return TRUE ,else return FALSE
	 * @param taxName
	 */
	public boolean isSetTax(String taxName);

	/**
	 * Find role By name
	 * @param taxName
	 * @return
	 */
	public Tax findTaxByName(String taxName);
}

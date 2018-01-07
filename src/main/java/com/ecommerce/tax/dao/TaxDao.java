package com.ecommerce.tax.dao;

import java.util.List;

import com.ecommerce.product.doimain.Tax;

public interface TaxDao {

	public List<Tax> fintAllTaxes();

    /**
     * Create new Tax role
     * @param tax
     */
    void createTax(Tax tax);

    /**
     * Find Role By Name
     * @param taxName
     * @return
     */
    Tax findTaxByName(String taxName);
}

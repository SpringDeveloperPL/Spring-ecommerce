package com.ecommerce.tax.dao;

import com.ecommerce.product.doimain.Tax;

import java.util.List;

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

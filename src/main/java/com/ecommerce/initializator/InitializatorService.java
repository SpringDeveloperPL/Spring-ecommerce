package com.ecommerce.initializator;
import com.ecommerce.product.doimain.Tax;
import java.util.List;
public interface InitializatorService {

    /**
     * Initalizing Customer Role available in Application
     */
    void initializeCustomerRole();

    /**
     * Initialize example Customers who using application
     */
    void initializeCustomers();

    /**
     * Initialize Admin ,password=admin12,username=admin12 available under URL htttp://base_domain/admin
     * * @param admin
     */
    void initializeAdmin();

    /**
     * Initialize example Application Category Prodeucts
     */
    void initializeCategorys();

    /**
     * Initialize example Tax Rates
     */
    void initializeTaxs();

    /**
     * Inserting all chased components into Database
     */
    void initializeDatabase();
}

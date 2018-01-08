package com.ecommerce.initializator;

import com.ecommerce.category.service.CategoryService;
import com.ecommerce.customer.domain.Role;
import com.ecommerce.customer.service.CustomerService;
import com.ecommerce.customer.service.RoleService;
import com.ecommerce.product.doimain.Tax;
import com.ecommerce.tax.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Component
@Service
public class InitializatorServiceImpl implements InitializatorService{

    public static boolean IS_INITIALIZED_DATABASE_VALUES = false;

    @Autowired
    CustomerService customerService;
    @Autowired
    TaxService taxService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    RoleService roleService;


    @Override
    public void initializeCustomerRole() {

        String roleNameAdmin = "ROLE_ADMIN";
        String roleNameCustomer = "ROLE_CUSTOMER";

        List<String> roleNames= new ArrayList<>();
        roleNames.add(roleNameAdmin);
        roleNames.add(roleNameCustomer);

        for (String name :roleNames) {
                if(!roleService.isSetRole(name)) {
                    Role newRole = new Role();
                    newRole.setRoleName(name);
                    roleService.createRole(newRole);
                }
        }

    }

    @Override
    public void initializeCustomers() {

    }

    @Override
    public void initializeAdmin() {


    }

    @Override
    public void initializeCategorys() {
        String homeCategory = "Home";

        List<String> categoryNamedList = new ArrayList<>();
        categoryNamedList.add(homeCategory);
        for (String categoryName : categoryNamedList) {

            if(!categoryService.isSetCategory(categoryName)) {

                categoryService.createCategory(categoryName,-1);
            }
        }
    }


    public void initializeTaxs() {

        String taxVat = "VAT";
        Integer taxTate=23;
        Map<Integer, String> taxList = new TreeMap<>();

        taxList.put(23,taxVat);


        for(Map.Entry<Integer, String> entry: taxList.entrySet()) {
            if(!taxService.isSetTax(entry.getValue())) {
                Tax tax = new Tax();
                tax.setName(entry.getValue());
                tax.setRate(entry.getKey());
                taxService.createTax(tax);
            }
        }

        

    }

    @Override
//    @PostConstruct
    public void initializeDatabase() {
        if(IS_INITIALIZED_DATABASE_VALUES==false) {
            initializeCustomerRole();
            initializeCategorys();
            initializeTaxs();

            IS_INITIALIZED_DATABASE_VALUES=true;
        }

    }
}

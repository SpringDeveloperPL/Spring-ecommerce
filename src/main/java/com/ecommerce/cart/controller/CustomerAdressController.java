package com.ecommerce.cart.controller;

import com.ecommerce.cart.domain.Cart;
import com.ecommerce.cart.service.CartService;
import com.ecommerce.customer.domain.Adress;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.customer.domain.CustomerAdress;
import com.ecommerce.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class CustomerAdressController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CartService cartService;

    CustomerAdress customerAdress = new CustomerAdress();

    Adress adress = new Adress();

    Customer customer = new Customer();

    Map<String, String> erorList = new HashMap<>();

    @RequestMapping("/adress-detail")
    public String showCustomerCartAdressDetails(Model model) {


        Cart custoemrCart = cartService.getCustomerCart();
        customer = custoemrCart.getCustomer();


        if (!customer.getUserName().equals("anonymousUser")) {

            if (customerService.isCustomerAdresEntered(customer)) {

                adress = customerService.getCustomerAdress(customer);
                model.addAttribute("adress", adress);

            } else erorList.put("Warning", "Please enter your adress information ");

        } else {
            erorList.put("Danger", "You havent acces to Cart ,please login");
        }

        if (!erorList.isEmpty()) {
            model.addAttribute("errorList", erorList);
        }
        return "customerAdresCart";

    }

    @RequestMapping(value = "/adress-detail", method = RequestMethod.POST,params = "goShipment")
    public String showShipmentCart(Model model,
                                   @RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam String city,
                                   @RequestParam String postalCode,
                                   @RequestParam String primaryPhone) {


        adress.setIsActive(true);
        adress.setFirstName(firstName);
        adress.setLastName(lastName);
        adress.setCity(city);
        adress.setPostCode(postalCode);
        adress.setPrimaryPhone(primaryPhone);

        customerAdress.setCustomer(customer);
        customerAdress.setAdress(adress);

        Set<Adress> customerAdressesSet = new HashSet<>();
        customerAdressesSet.add(adress);
        adress.setCustomerAdress(customerAdressesSet);
        customerService.saveAdress(adress);
        customerService.saveCustomerAdres(customerAdress);

        if (customerService.isCustomerAdresEntered(customer)) {

            return "shipment";

        } else return "customerAdresCart";
    }

}

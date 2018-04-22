package com.ecommerce.cart.controller;

import com.ecommerce.cart.domain.Cart;
import com.ecommerce.cart.domain.CartDetail;
import com.ecommerce.cart.domain.Payment;
import com.ecommerce.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class CartController {

    @Autowired
    CartService cartService;


    @RequestMapping("/cart")
    public String showShoppingCard(Model model) {

        Cart cart = cartService.getCustomerCart();
        List<CartDetail> cartItems = cartService.getCustomerCartItems();

        model.addAttribute("cartItems",cartItems);
        model.addAttribute("cartInfo",cart);

        return "cart";
    }

    @RequestMapping(value = "cart",method = RequestMethod.POST,params = "removeItem")
    public void removeCartItem(Model model, @RequestParam String removeItem ) {
        cartService.removeCartItem(Integer.parseInt(removeItem));
        showShoppingCard(model);
    }
}

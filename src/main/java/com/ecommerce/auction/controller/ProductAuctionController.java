package com.ecommerce.auction.controller;

import com.ecommerce.auction.domain.AuctionBidd;
import com.ecommerce.auction.service.AuctionService;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.customer.service.CustomerService;
import com.ecommerce.product.doimain.Product;
import com.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;


@Controller
public class ProductAuctionController {

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;

    @Autowired
    AuctionService auctionService;

    @RequestMapping(value = "/category/product",method = RequestMethod.POST)
    public String productBidd(Model model, @RequestParam("id") String productId, @RequestParam("name") String bidPrice) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Product product = productService.getProductById(Integer.parseInt(productId));

        String name = auth.getName();
        System.out.println(name);

        if(!name.equals("anonymousUser")) {

            Customer customer = customerService.findCustomerByName(name);
            AuctionBidd auctionBidd = new AuctionBidd();
            auctionBidd.setBidder(customer);
            auctionBidd.setAuctionItem(product);
            BigDecimal biddPriceFromString = new BigDecimal(bidPrice);
            auctionBidd.setBiddPrice(biddPriceFromString);

            auctionBidd.setBiddDate(auctionService.getBiddDate());

            auctionService.productBidd(auctionBidd);
        }
        long countdownTimestamp = auctionService.getAuctionCountDownNanos(product.getAuctionEndDate());
        model.addAttribute("countdownTimestamp",countdownTimestamp);
        model.addAttribute("product",product);
        model.addAttribute("observerCount",auctionService.getCountProductAuctionObserver(product));
        return "product";

    }
}

package com.ecommerce.auction.controller;

import com.ecommerce.auction.service.AuctionService;
import com.ecommerce.product.doimain.Product;
import com.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuctionManagerController {

    @Autowired
    ProductService productService;

    @Autowired
    AuctionService auctionService;
    @RequestMapping("/dashboard/auction-manager")
    public String manageAuctions(Model model) {

        model.addAttribute("auctions",productService.getActiveProductList(productService.findAllProducts()));
        return "auction-manager";
    }

    @RequestMapping("/dashboard/auction-manager/auction/{auctionID}")
    public String auctioDetail(Model model,@PathVariable int auctionID ) {


        Product product = productService.getProductById(auctionID);
        model.addAttribute("historyBidds",auctionService.getBiddsHistory(product));
        return "auction-detail";
    }
}

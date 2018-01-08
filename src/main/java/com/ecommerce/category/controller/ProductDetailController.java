package com.ecommerce.category.controller;

import com.ecommerce.auction.service.AuctionService;
import com.ecommerce.product.doimain.Product;
import com.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductDetailController {
	
	@Autowired
	ProductService productService;

	@Autowired
	AuctionService auctionService;

	@RequestMapping("/category/product")
	public String getProductById(Model model,@RequestParam("id") String productId) {


		Product product = productService.getProductById(Integer.parseInt(productId));
		long countdownTimestamp = auctionService.getAuctionCountDownNanos(product.getAuctionEndDate());
		model.addAttribute("countdownTimestamp",countdownTimestamp);
		model.addAttribute("product",product);
		return "product";

	}




}



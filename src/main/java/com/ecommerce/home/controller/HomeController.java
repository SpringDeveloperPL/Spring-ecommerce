package com.ecommerce.home.controller;

import com.ecommerce.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@Autowired
	ProductService productService;
	private static Logger logger= LoggerFactory.getLogger(HomeController.class);
	@RequestMapping("/")
	public String welcome() {
		logger.info("info from logger");
		return "welcome";
	}


}
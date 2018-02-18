package com.ecommerce.home.controller;

import com.ecommerce.ContextProvider.ApplicationContextProvider;
import com.ecommerce.auction.domain.AuctionBidd;
import com.ecommerce.auction.service.AuctionSchedulerService;
import com.ecommerce.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
	@Autowired
	ProductService productService;

	@Autowired
	AuctionSchedulerService auctionSchedulerService;
	private static Logger logger= LoggerFactory.getLogger(HomeController.class);
	@RequestMapping("/")
	public String welcome() {
		logger.info("info from logger");

		ApplicationContextProvider applicationContextProvider = new ApplicationContextProvider();

		auctionSchedulerService = applicationContextProvider.getApplicationContext().getBean("auctionSchedulerService",AuctionSchedulerService.class);

		List<AuctionBidd> auctionBiddList = auctionSchedulerService.getAllActiveAuctionsBidds();


		try {
			for (AuctionBidd auctionBidd : auctionBiddList) {
                System.out.println(auctionBidd.getAuctionItem().getName());
            }
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "welcome";
	}


}
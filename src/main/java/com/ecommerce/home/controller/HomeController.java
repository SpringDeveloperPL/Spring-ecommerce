package com.ecommerce.home.controller;

import com.ecommerce.auction.service.AuctionSchedulerService;
import com.ecommerce.product.service.ProductService;
import com.ecommerce.promotion.domain.PromotionBox;
import com.ecommerce.promotion.service.UploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class HomeController {

	@Autowired
	UploadFileService uploadFileService;

	@RequestMapping("/")
	public String welcome(Model model) {

		model.addAttribute("imagesList",uploadFileService.getOrderedAllImages());
		model.addAttribute("promotionBoxList",uploadFileService.getListOfAllPromotionBoxesOrderedById());
		model.addAttribute("largeBoxList",uploadFileService.getListOfAllLargeBoxesOrderedById());
		return "welcome";
	}

}
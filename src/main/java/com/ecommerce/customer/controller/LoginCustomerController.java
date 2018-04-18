package com.ecommerce.customer.controller;

import com.ecommerce.auction.domain.AuctionMessage;
import com.ecommerce.auction.service.AuctionService;
import com.ecommerce.cart.domain.Payment;
import com.ecommerce.cart.service.PaymentService;
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

import java.util.List;
import java.util.Map;

@Controller
public class LoginCustomerController {

	@Autowired
	AuctionService auctionService;

	@Autowired
	CustomerService customerService;

	@Autowired
	ProductService productService;

	@Autowired
	PaymentService paymentService;

	@RequestMapping("/customer-account")
	public String customerLoginGetway(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();

		if(!name.equals("anonymousUser")) {

			Customer customer = customerService.findCustomerByName(name);
			Map<Product,AuctionMessage> auctionMessageMap = auctionService.getAuctionMessageAttachedCustomerProductAuction(customer);
			List<Payment> pendingPayments = paymentService.getCustomerPendingPayments(customer);
			List<Payment> successfulPayments = paymentService.getcustomerSuccesfulPayments(customer);
			model.addAttribute("customer",customerService.findCustomerByName(name));
			model.addAttribute("auctionMessageMap", auctionMessageMap);
			model.addAttribute("pendingPayments",pendingPayments);
			model.addAttribute("successfulPayments",successfulPayments);

			return "customer-account";

		} else  return "sign-in";
	}
	
	@RequestMapping("/sign-in")
	public String customerLogin() {
		
		return "sign-in";
	}
	

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
		model.addAttribute("error", "true");
		return "sign-in";
	}

	

}

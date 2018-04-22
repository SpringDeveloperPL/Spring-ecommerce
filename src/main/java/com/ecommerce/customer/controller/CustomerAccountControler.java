package com.ecommerce.customer.controller;

import com.ecommerce.auction.domain.AuctionMessage;
import com.ecommerce.auction.service.AuctionService;
import com.ecommerce.cart.domain.Cart;
import com.ecommerce.cart.domain.CartDetail;
import com.ecommerce.cart.domain.Payment;
import com.ecommerce.cart.service.CartService;
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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerAccountControler {

	@Autowired
	AuctionService auctionService;

	@Autowired
	CustomerService customerService;

	@Autowired
	ProductService productService;

	@Autowired
	PaymentService paymentService;

	@Autowired
	CartService cartService;

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
			Customer customer1 = customerService.getLoggedCustomer();
			Cart cart = customer1.getCart();
			System.out.println(cart.getCartID().toString());
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

	@RequestMapping(value = "/customer-account",method = RequestMethod.POST,params = "addItem")
	public void  addItemToCart(Model model, HttpServletRequest httpServletRequest,@RequestParam String addItem) {
		cartService.addCartItem(Integer.parseInt(addItem));
		customerLoginGetway(model);
	}

	@RequestMapping(value = "/customer-account",method = RequestMethod.POST,params = "removeItem")
	public void  removeCartItem(Model model, HttpServletRequest httpServletRequest,@RequestParam String removeItem) {
		int cartID =  cartService.getCartItemIDByPaymentID(Integer.parseInt(removeItem));
		cartService.removeCartItem(cartID);
		customerLoginGetway(model);
	}

	

}

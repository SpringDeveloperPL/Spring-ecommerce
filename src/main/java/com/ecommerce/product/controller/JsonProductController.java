package com.ecommerce.product.controller;

import com.ecommerce.product.doimain.Product;
import com.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dashboard/manageproduct/json")
public class JsonProductController {

	@Autowired
	ProductService productService;

	/**
	 *Product list in Json format pressed onder url /dashboard/manageproduct/json/product
	 * @return
	 */
	@RequestMapping("/products")
	@ResponseBody
	public List<Product> getAllPRoducts() {

		return productService.findAllProducts();
	}
	@RequestMapping(value="/{id}/activation") 
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		
		Product product = productService.getProductById(id);
		
		Boolean productIsActive = product.getActive();
		if(productIsActive.equals(true)) {
			product.setActive(false);
		}else product.setActive(true);
		
		productService.updateProduct(product);
		
		return (!productIsActive) ? "You have beanm activate product "+product.getName() 
									: "You have beanm deactivate  product " +product.getName();
	}
}

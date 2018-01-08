package com.ecommerce.category.controller;

import com.ecommerce.category.service.CategoryService;
import com.ecommerce.product.doimain.Product;
import com.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class ProductCategoryController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	@RequestMapping("/{category}")
	public String getProductByCategory(Model model, @PathVariable("category") String category) {

		List<Product> activeProductList = productService.getActiveProductList(categoryService.getProductsByCategory(category));

		// model.addAttribute("productsByCategory",categoryService.getProductsByCategory(category));
		if(category.equals(null) || category.isEmpty()) {
			category="Home";
		}
		model.addAttribute("productCategoryList", activeProductList);
		model.addAttribute("category",category);

		return "category";
	}
}

package com.ecommerce.category.controller;

import com.ecommerce.category.service.CategoryService;
import com.ecommerce.product.doimain.Product;
import com.ecommerce.category.domain.Category;
import com.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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

	@ResponseBody
	@RequestMapping("json/{category}")
	public List<Product> getProductByCategoryJSON(Model model, @PathVariable("category") String category) {

		List<Product> activeProductList = productService.getActiveProductList(categoryService.getProductsByCategory(category));

		return activeProductList;
	}

	@ResponseBody
	@RequestMapping("json/allProducts")
	public List<Product> getProductByCategoryJSON(Model model) {

		List<Product> activeProductList = productService.getActiveProductList(productService.findAllProducts());

		return activeProductList;
	}

	@ResponseBody
	@RequestMapping("json/list")
	public List<String> getListNamedCategoryJSON(Model model) {

		ModelAndView modelAndView = new ModelAndView();
		List<Category> categoryList = categoryService.findAllCategory();
		List<String> categoryNameList = new ArrayList<>();
		for (Category category : categoryList) {
			categoryNameList.add(category.getName());
		}

		return categoryNameList;
	}

}

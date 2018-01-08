package com.ecommerce.category.controller;

import com.ecommerce.category.domain.JsonResponse;
import com.ecommerce.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/dashboard")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping("/managecategory")
	public String menuView() {

		return "managecategory";
	}

	@RequestMapping(value = "/managecategory.do", method = RequestMethod.POST)
	public ResponseEntity<JsonResponse> menuVeiw(HttpServletRequest request) {
		
		JsonResponse jsonResonse = categoryService.JsonResponse(request);
		ResponseEntity<JsonResponse> re = new ResponseEntity<JsonResponse>(jsonResonse, HttpStatus.OK);

		return re;
	}

}

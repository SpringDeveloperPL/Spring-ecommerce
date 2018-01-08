package com.ecommerce.category.service;

import com.ecommerce.category.domain.*;
import com.ecommerce.product.doimain.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface CategoryService {

	public List<Category> findAllCategory();

	public JsonResponse JsonResponse(HttpServletRequest httpServletRequest);

	public ClientHttpRequest createClientHttpRequest(HttpServletRequest httpServletRequest);

	public List<Factor> createFactorsList(List<Category> allJsonNode, ClientHttpRequest clientHttpRequest);
	
	public void changeNameCategory(int categoryId, String categoryName);
	
	public void printHtppRequestConsole(HttpServletRequest httpServletRequest);
	
	public void deleteCategory(int categoryId);
	
	public void createCategory(String categoryName,int parent);

	public List<Product> getProductsByCategory(String category);

	public List<ProductCategory> findAllProductCategory();	
	
	/**
	 * @param productId
	 * @return Return List of if Category aligned to Product
	 */
	public List<Integer> getIdProductAcignedCategory(int productId);

	/**
	 * Finding category by Name
	 * @param name
	 * @return Category
	 */
	public Category findCategoryByName(String name);

	/**
	 * Check if category is set
	 * If Category exist then return True ,else return False
	 * @param categoryName
	 * @return
	 */
	public boolean isSetCategory(String categoryName);


}

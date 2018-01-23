package com.ecommerce.product.service;

import com.ecommerce.product.doimain.Color;
import com.ecommerce.product.doimain.Manufacturer;
import com.ecommerce.product.doimain.Product;
import com.ecommerce.product.doimain.ProductImage;

import java.util.List;


public interface ProductService {

	/**
	 * Creane new Product
	 * @param product
	 */
	public void addProduct(Product product);
	public List<Color> findAllColors();

	/**
	 * Find All Manufacturers
	 * @return
	 */
	public List<Manufacturer> findAllManufacturer();

	/**
	 * Find all product consist in service
	 * @return
	 */
	public List<Product> findAllProducts();

	/**
	 * Adding Images to Product
	 * @param imageList
	 */
	public void addProductImage(List<ProductImage> imageList);
	public String getUniqueFileName();

	/**
	 * Getting Product by Identificator
	 * @param producId
	 * @return
	 */
	public Product getProductById(Integer producId);

	/**
	 * Update Product state
	 * @param product
	 */
	public void updateProduct(Product product);

	/**
	 * Gettting Active product List
	 * @return
	 */
	public List<Product> getActiveProductList(List<Product> allProducts);

}

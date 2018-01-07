package com.ecommerce.product.service;

import java.util.LinkedList;
import java.util.List;

import com.ecommerce.product.doimain.Color;
import com.ecommerce.product.doimain.Manufacturer;
import com.ecommerce.product.doimain.Product;
import com.ecommerce.product.doimain.ProductImage;


public interface ProductService {

	public void addProduct(Product product);
	public List<Color> findAllColors();
	public List<Manufacturer> findAllManufacturer();
	public List<Product> findAllProducts();
	public void addProductImage(List<ProductImage> imageList);
	public String getUniqueFileName();
	public Product getProductById(Integer producId);
	public void updateProduct(Product product);

	/**
	 * Gettting Active product List
	 * @return
	 */
	public List<Product> getActiveProductList(List<Product> allProducts);
}

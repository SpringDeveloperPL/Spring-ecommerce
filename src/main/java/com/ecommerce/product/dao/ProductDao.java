package com.ecommerce.product.dao;

import com.ecommerce.category.domain.ProductCategory;
import com.ecommerce.product.doimain.Color;
import com.ecommerce.product.doimain.Manufacturer;
import com.ecommerce.product.doimain.Product;
import com.ecommerce.product.doimain.ProductImage;

import java.util.List;

public interface ProductDao {

	public void addProduct(Product product);

	public List<Color> findAllColor();

	public void addProductImage(List<ProductImage> imageList);

	public List<Manufacturer> findAllManufacturer();

	public List<Product> findAllProducts();

	public List<ProductCategory> findAllProductCategory();

	public Product getProductById(Integer producId);

	/**Update Product information
	 * @param product
	 */
	public void updateProduct(Product product);

}

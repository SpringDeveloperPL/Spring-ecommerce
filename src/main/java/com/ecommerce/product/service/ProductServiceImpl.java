package com.ecommerce.product.service;

import com.ecommerce.product.dao.ProductDao;
import com.ecommerce.product.doimain.Color;
import com.ecommerce.product.doimain.Manufacturer;
import com.ecommerce.product.doimain.Product;
import com.ecommerce.product.doimain.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	

	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	@Override
	public List<Color> findAllColors() {
		return productDao.findAllColor();
	}

	@Override
	public void addProductImage(List<ProductImage> imageList) {
		productDao.addProductImage(imageList);

	}

	@Override
	public String getUniqueFileName() {

		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();
		randomUUIDString = randomUUIDString + ".jpg";
		String uniqueFileName = randomUUIDString.replaceAll("-", "");
		return uniqueFileName;
	}

	@Override
	public List<Manufacturer> findAllManufacturer() {
		return productDao.findAllManufacturer();
	}

	@Override
	public List<Product> findAllProducts() {
		return productDao.findAllProducts();

	}

	@Override
	public Product getProductById(Integer producId) {
		return productDao.getProductById(producId);
	}

	@Override
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	@Override
	public List<Product> getActiveProductList(List<Product> allProducts) {


		List<Product> activeProductList = new ArrayList<>();
		for (Product product: allProducts) {
			if(product.getActive().equals(true)) {
				activeProductList.add(product);
			}
		}

		return activeProductList;

	}

}

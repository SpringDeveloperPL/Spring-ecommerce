package com.ecommerce.product.dao;

import com.ecommerce.category.domain.ProductCategory;
import com.ecommerce.product.doimain.Color;
import com.ecommerce.product.doimain.Manufacturer;
import com.ecommerce.product.doimain.Product;
import com.ecommerce.product.doimain.ProductImage;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {


	@Autowired
	SessionFactory sessionFactory;
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}


	public void addProduct(Product product) {
		Session session = getCurrentSession();
		session.save(product);
	}

	public List<Color> findAllColor() {
		List<Color> allColors = new ArrayList<>();
		allColors = getCurrentSession().createCriteria(Color.class).list();
		return allColors;
	}

	public void addProductImage(List<ProductImage> imageList) {
		Session session = getCurrentSession();

		for (ProductImage productImage : imageList) {
			productImage.setName(productImage.getName());
			session.save(productImage);
		}
	}


	public List<Manufacturer> findAllManufacturer() {
		Session session = getCurrentSession();
		return session.createCriteria(Manufacturer.class).list();
	}


	public List<Product> findAllProducts() {
		List<Product> productList = getCurrentSession().createCriteria(Product.class).list();

		return productList;
	}


	public List<ProductCategory> findAllProductCategory() {
		List<ProductCategory> prod = getCurrentSession().createCriteria(ProductCategory.class).list();
		return prod;
	}


	public Product getProductById(Integer producId) {
		Session session = getCurrentSession();
		return session.get(Product.class, producId);
	}


	public void updateProduct(Product product) {
		Session session = getCurrentSession();
		session.saveOrUpdate(product);
	}



}

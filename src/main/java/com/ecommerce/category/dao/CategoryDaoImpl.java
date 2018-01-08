package com.ecommerce.category.dao;

import com.ecommerce.category.domain.Category;
import com.ecommerce.category.domain.ProductCategory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Category> findAllCategory() {

		List<Category> allCategory = new ArrayList<>();
		allCategory = getCurrentSession().createCriteria(Category.class).list();
		return allCategory;
	}

	@Override
	public void changeCategoryName(int categoryId, String categoryName) {
		Session session = getCurrentSession();
		categoryName = categoryName.replaceAll("%20", " ");
		Query query = session
				.createQuery("update Category c set c.name = :categoryName where c.categoryId = :categoryId");
		query.setLong("categoryId", categoryId);
		query.setParameter("categoryName", categoryName);
		query.executeUpdate();

	}

	@Override
	public void deleteCategory(int categoryId) {
		Session session = getCurrentSession();
		Query query = session
				.createQuery("delete from Category c where c.categoryId = :categoryId OR c.parent= :categoryId");
		query.setLong("categoryId", categoryId);
		query.executeUpdate();

	}

	@Override
	public void createCategory(String categoryName, int parent) {
		Session session = getCurrentSession();
		Category category = new Category();
		categoryName = categoryName.replaceAll("%20", " ");
		System.err.println(categoryName + " " + parent);
		category.setName(categoryName);
		category.setParent(parent);
		category.setType(2);
		session.persist(category);

	}

	@Override
	public List<ProductCategory> findAllProductCategory() {
		
		return getCurrentSession().createCriteria(ProductCategory.class).list();
	}

	@Override
	public Category findCategoryByName(String name) {
		Session session= getCurrentSession();
		Criteria criteria = session.createCriteria(Category.class);
		criteria.add(Restrictions.eq("name",name));
		Category category = (Category) criteria.uniqueResult();
		return category;
	}

}

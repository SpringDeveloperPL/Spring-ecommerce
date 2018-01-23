/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package com.ecommerce.category.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Proxy(lazy = false)
@Table(name="PRODUCT_CATEGORY")
public class ProductCategory implements Serializable {
	public ProductCategory() {
	}
	
	@Column(name="productCategoryId", nullable=false, length=20)	
	@Id	
	@GeneratedValue(generator="COM_ECOMMERCE_PRODUCTCATEGORY_PRODUCTCATEGORYID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_ECOMMERCE_PRODUCTCATEGORY_PRODUCTCATEGORYID_GENERATOR", strategy="native")	
	private long productCategoryId;
	
	@ManyToOne(targetEntity=com.ecommerce.category.domain.Category.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="categoryId", referencedColumnName="categoryId", nullable=false) })	
	private com.ecommerce.category.domain.Category category;
	
	@Column(name="promotionMessage", nullable=true, length=255)	
	private String promotionMessage;
	
	@Column(name="orderSequence", nullable=true, length=11)	
	private Integer orderSequence;
	
	@ManyToOne(targetEntity=com.ecommerce.product.doimain.Product.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="productID", referencedColumnName="productId", nullable=false) })	
	private com.ecommerce.product.doimain.Product product;
	
	private void setProductCategoryId(long value) {
		this.productCategoryId = value;
	}
	
	public long getProductCategoryId() {
		return productCategoryId;
	}
	
	public long getORMID() {
		return getProductCategoryId();
	}
	
	public void setPromotionMessage(String value) {
		this.promotionMessage = value;
	}
	
	public String getPromotionMessage() {
		return promotionMessage;
	}
	
	public void setOrderSequence(int value) {
		setOrderSequence(new Integer(value));
	}
	
	public void setOrderSequence(Integer value) {
		this.orderSequence = value;
	}
	
	public Integer getOrderSequence() {
		return orderSequence;
	}
	
	public void setCategory(com.ecommerce.category.domain.Category value) {
		this.category = value;
	}
	
	public com.ecommerce.category.domain.Category getCategory() {
		return category;
	}
	
	public void setProduct(com.ecommerce.product.doimain.Product value) {
		this.product = value;
	}
	
	public com.ecommerce.product.doimain.Product getProduct() {
		return product;
	}
	
	public String toString() {
		return String.valueOf(getProductCategoryId());
	}
	
}

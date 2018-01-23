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
package com.ecommerce.product.doimain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="PRODUCT_IMAGE")
public class ProductImage implements Serializable {
	public ProductImage() {
	}
	
	@Column(name="id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="COM_ECOMMERCE_PRODUCTIMAGE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_ECOMMERCE_PRODUCTIMAGE_ID_GENERATOR", strategy="native")	
	private int id;
	
	@ManyToOne(targetEntity=Product.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="productId", referencedColumnName="productId", nullable=false) })	
	private Product product;
	
	@Column(name="name", nullable=true, length=255)	
	private String name;
	
	@Column(name="isMainImage", nullable=true, length=1)	
	private Boolean isMainImage;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setIsMainImage(boolean value) {
		setIsMainImage(new Boolean(value));
	}
	
	public void setIsMainImage(Boolean value) {
		this.isMainImage = value;
	}
	
	public Boolean getIsMainImage() {
		return isMainImage;
	}
	
	public void setProduct(Product value) {
		this.product = value;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}

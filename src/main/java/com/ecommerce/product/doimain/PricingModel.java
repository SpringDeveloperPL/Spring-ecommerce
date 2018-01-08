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
@Table(name="pricingmodel")
public class PricingModel implements Serializable {
	public PricingModel() {
	}
	
	@Column(name="pricingModelId", nullable=false, length=20)	
	@Id	
	@GeneratedValue(generator="COM_ECOMMERCE_PRICINGMODEL_PRICINGMODELID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_ECOMMERCE_PRICINGMODEL_PRICINGMODELID_GENERATOR", strategy="native")	
	private long pricingModelId;
	
	@Column(name="price", nullable=true, length=11)	
	private Integer price;
	
	@Column(name="name", nullable=true, length=255)	
	private String name;
	
	@Column(name="category", nullable=true, length=255)	
	private String category;
	
	@Column(name="dateActive", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date dateActive;
	
	@Column(name="dateUnactive", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date dateUnactive;
	
	@Column(name="isDefault", nullable=true, length=1)	
	private Boolean isDefault;
	
	@Column(name="isActive", nullable=true, length=1)	
	private Boolean isActive;
	
	@OneToMany(mappedBy="pricingModel", targetEntity=com.ecommerce.product.doimain.ProductGroup.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set productGroup = new java.util.HashSet();
	
	private void setPricingModelId(long value) {
		this.pricingModelId = value;
	}
	
	public long getPricingModelId() {
		return pricingModelId;
	}
	
	public long getORMID() {
		return getPricingModelId();
	}
	
	public void setPrice(int value) {
		setPrice(new Integer(value));
	}
	
	public void setPrice(Integer value) {
		this.price = value;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCategory(String value) {
		this.category = value;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setDateActive(java.util.Date value) {
		this.dateActive = value;
	}
	
	public java.util.Date getDateActive() {
		return dateActive;
	}
	
	public void setDateUnactive(java.util.Date value) {
		this.dateUnactive = value;
	}
	
	public java.util.Date getDateUnactive() {
		return dateUnactive;
	}
	
	public void setIsDefault(boolean value) {
		setIsDefault(new Boolean(value));
	}
	
	public void setIsDefault(Boolean value) {
		this.isDefault = value;
	}
	
	public Boolean getIsDefault() {
		return isDefault;
	}
	
	public void setIsActive(boolean value) {
		setIsActive(new Boolean(value));
	}
	
	public void setIsActive(Boolean value) {
		this.isActive = value;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setProductGroup(java.util.Set value) {
		this.productGroup = value;
	}
	
	public java.util.Set getProductGroup() {
		return productGroup;
	}
	
	
	public String toString() {
		return String.valueOf(getPricingModelId());
	}
	
}

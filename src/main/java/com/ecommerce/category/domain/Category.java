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

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="category")
public class Category implements Serializable {
	public Category() {
	}
	
	@Column(name="categoryId", nullable=false, length=11)	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@org.hibernate.annotations.GenericGenerator(name="COM_ECOMMERCE_CATEGORY_CATEGORYID_GENERATOR", strategy="identity")	
	private int categoryId;
	
	@Column(name="dateAdded", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date dateAdded;
	
	@Column(name="dateUpdated", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date dateUpdated;
	
	@Column(name="isActivated", nullable=true, length=1)	
	private Boolean isActivated;
	
	@Column(name="URL", nullable=true, length=255)	
	private String URL;
	
	@Column(name="name", nullable=true, length=255)	
	private String name;
	
	@Column(name="description", nullable=true, length=255)	
	private String description;
	
	@Column(name="longDescription", nullable=true)	
	private String longDescription;
	
	@Column(name="parent", nullable=true, length=11)	
	private int parent;
	
	@Column(name="id", nullable=true, length=11)	
	private Integer id;
	
	@Column(name="type", nullable=true, length=11)	
	private Integer type;
	
	@OneToMany(mappedBy="category", targetEntity=ProductCategory.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set productCategory = new java.util.HashSet();
	
	@OneToMany(mappedBy="category", targetEntity=CategoryAttribute.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set categoryAttribute = new java.util.HashSet();
	
	private void setCategoryId(int value) {
		this.categoryId = value;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public int getORMID() {
		return getCategoryId();
	}
	
	public void setDateAdded(java.util.Date value) {
		this.dateAdded = value;
	}
	
	public java.util.Date getDateAdded() {
		return dateAdded;
	}
	
	public void setDateUpdated(java.util.Date value) {
		this.dateUpdated = value;
	}
	
	public java.util.Date getDateUpdated() {
		return dateUpdated;
	}
	
	public void setIsActivated(boolean value) {
		setIsActivated(new Boolean(value));
	}
	
	public void setIsActivated(Boolean value) {
		this.isActivated = value;
	}
	
	public Boolean getIsActivated() {
		return isActivated;
	}
	
	public void setURL(String value) {
		this.URL = value;
	}
	
	public String getURL() {
		return URL;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setLongDescription(String value) {
		this.longDescription = value;
	}
	
	public String getLongDescription() {
		return longDescription;
	}
	
	public void setParent(int value) {
		this.parent = value;
	}
	
	public int getParent() {
		return parent;
	}
	
	public void setId(int value) {
		setId(new Integer(value));
	}
	
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setType(int value) {
		setType(new Integer(value));
	}
	
	public void setType(Integer value) {
		this.type = value;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setProductCategory(java.util.Set value) {
		this.productCategory = value;
	}
	
	public java.util.Set getProductCategory() {
		return productCategory;
	}
	
	
	public void setCategoryAttribute(java.util.Set value) {
		this.categoryAttribute = value;
	}
	
	public java.util.Set getCategoryAttribute() {
		return categoryAttribute;
	}
	
	
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", dateAdded=" + dateAdded + ", dateUpdated=" + dateUpdated
				+ ", isActivated=" + isActivated + ", URL=" + URL + ", name=" + name + ", description=" + description
				+ ", longDescription=" + longDescription + ", parent=" + parent + ", id=" + id + ", type=" + type
				+ ", productCategory=" + productCategory + ", categoryAttribute=" + categoryAttribute + "]";
	}
	
}

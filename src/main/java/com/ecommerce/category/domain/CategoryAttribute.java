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

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="CategoryAttribute")
public class CategoryAttribute implements Serializable {
	public CategoryAttribute() {
	}
	
	@Column(name="attributeId", nullable=false, length=20)	
	@Id	
	@GeneratedValue(generator="COM_ECOMMERCE_CATEGORYATTRIBUTE_ATTRIBUTEID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_ECOMMERCE_CATEGORYATTRIBUTE_ATTRIBUTEID_GENERATOR", strategy="native")	
	private long attributeId;
	
	@ManyToOne(targetEntity=com.ecommerce.category.domain.Category.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="categoryId", referencedColumnName="categoryId", nullable=false) })	
	private com.ecommerce.category.domain.Category category;
	
	@Column(name="name", nullable=true, length=255)	
	private String name;
	
	@Column(name="value", nullable=true, length=255)	
	private String value;
	
	@Column(name="searchable", nullable=true, length=1)	
	private Boolean searchable;
	
	private void setAttributeId(long value) {
		this.attributeId = value;
	}
	
	public long getAttributeId() {
		return attributeId;
	}
	
	public long getORMID() {
		return getAttributeId();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setSearchable(boolean value) {
		setSearchable(new Boolean(value));
	}
	
	public void setSearchable(Boolean value) {
		this.searchable = value;
	}
	
	public Boolean getSearchable() {
		return searchable;
	}
	
	public void setCategory(com.ecommerce.category.domain.Category value) {
		this.category = value;
	}
	
	public com.ecommerce.category.domain.Category getCategory() {
		return category;
	}
	
	public String toString() {
		return String.valueOf(getAttributeId());
	}
	
}

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
@Table(name="color")
public class Color implements Serializable {
	public Color() {
	}
	
	@Column(name="colorId", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="COM_ECOMMERCE_COLOR_COLORID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_ECOMMERCE_COLOR_COLORID_GENERATOR", strategy="identity")	
	private int colorId;
	
	@Column(name="groupId", nullable=true, length=11)	
	private Integer groupId;
	
	@Column(name="name", nullable=true, length=11)	
	private Integer name;
	
	@OneToMany(mappedBy="color", targetEntity=Product.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set product = new java.util.HashSet();
	
	private void setColorId(int value) {
		this.colorId = value;
	}
	
	public int getColorId() {
		return colorId;
	}
	
	public int getORMID() {
		return getColorId();
	}
	
	public void setGroupId(int value) {
		setGroupId(new Integer(value));
	}
	
	public void setGroupId(Integer value) {
		this.groupId = value;
	}
	
	public Integer getGroupId() {
		return groupId;
	}
	
	public void setName(int value) {
		setName(new Integer(value));
	}
	
	public void setName(Integer value) {
		this.name = value;
	}
	
	public Integer getName() {
		return name;
	}
	
	public void setProduct(java.util.Set value) {
		this.product = value;
	}
	
	public java.util.Set getProduct() {
		return product;
	}
	
	
	public String toString() {
		return String.valueOf(getColorId());
	}
	
}

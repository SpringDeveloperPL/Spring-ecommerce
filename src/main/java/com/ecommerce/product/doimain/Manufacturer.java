package com.ecommerce.product.doimain; /**
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

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="manufacturer")
public class Manufacturer implements Serializable {
	public Manufacturer() {
	}
	
	@Column(name="manufacturerId", nullable=false, length=11)	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@org.hibernate.annotations.GenericGenerator(name="MANUFACTURER_MANUFACTURERID_GENERATOR", strategy="identity")
	private long manufacturerId;
	
	@Column(name="groupId", nullable=true, length=11)	
	private Integer groupId;
	
	@Column(name="name", nullable=true, length=255)	
	private String name;
	
	@OneToMany(mappedBy="manufacturer", targetEntity=Product.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set product = new java.util.HashSet();
	
	private void setManufacturerId(long value) {
		this.manufacturerId = value;
	}
	
	public long getManufacturerId() {
		return manufacturerId;
	}
	
	public long getORMID() {
		return getManufacturerId();
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
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setProduct(java.util.Set value) {
		this.product = value;
	}
	
	public java.util.Set getProduct() {
		return product;
	}
	
	
	public String toString() {
		return String.valueOf(getManufacturerId());
	}

	public void setManufacturerIdFromForm(String id) {
		this.manufacturerId=Long.parseLong(id);
	}
	
}

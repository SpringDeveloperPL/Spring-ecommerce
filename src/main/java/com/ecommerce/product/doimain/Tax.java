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

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Tax")
public class Tax implements Serializable {
	public Tax() {
	}
	
	@Column(name="taxId", nullable=false, length=20)	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@org.hibernate.annotations.GenericGenerator(name="COM_ECOMMERCE_TAX_TAXID_GENERATOR", strategy="native")	
	private long taxId;
	
	@Column(name="rate", nullable=true, length=11)	
	private Integer rate;
	
	@Column(name="name", nullable=true, length=255)	
	private String name;
	
	@OneToMany(mappedBy="tax", targetEntity=com.ecommerce.product.doimain.Product.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set product = new java.util.HashSet();
	
	private void setTaxId(long value) {
		this.taxId = value;
	}
	
	public long getTaxId() {
		return taxId;
	}
	
	public long getORMID() {
		return getTaxId();
	}
	
	public void setRate(int value) {
		setRate(new Integer(value));
	}
	
	public void setRate(Integer value) {
		this.rate = value;
	}
	
	public Integer getRate() {
		return rate;
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
		return String.valueOf(getTaxId());
	}
	
	public void setTaxIdFromForm(String id) {
		this.taxId=Long.parseLong(id);
	}

	
}

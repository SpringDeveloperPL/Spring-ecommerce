/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: The State School of Higher Vocational Education in Jaroslaw
 * License Type: Academic
 */
package com.ecommerce.customer.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=true)
@Table(name="CustomerAdress")
public class CustomerAdress implements Serializable {
	public CustomerAdress() {
	}
	
	@Column(name="customerAdressId", nullable=false, length=19)	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@org.hibernate.annotations.GenericGenerator(name="COM_ECOMMERCE_CUSTOMER_DOMAIN_CUSTOMERADRESS_CUSTOMERADRESSID_GENERATOR", strategy="native")	
	private long customerAdressId;
	
	@Column(name="adressName", nullable=true, length=255)	
	private String adressName;
	
	@ManyToOne(targetEntity=com.ecommerce.customer.domain.Adress.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="adressId", referencedColumnName="adressId", nullable=false) })	
	private com.ecommerce.customer.domain.Adress adress;
	
	@ManyToOne(targetEntity=com.ecommerce.customer.domain.Customer.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="customerId", referencedColumnName="customerId", nullable=false) })	
	private com.ecommerce.customer.domain.Customer customer;
	
	private void setCustomerAdressId(long value) {
		this.customerAdressId = value;
	}
	
	public long getCustomerAdressId() {
		return customerAdressId;
	}
	
	public long getORMID() {
		return getCustomerAdressId();
	}
	
	public void setAdressName(String value) {
		this.adressName = value;
	}
	
	public String getAdressName() {
		return adressName;
	}
	
	public void setAdress(com.ecommerce.customer.domain.Adress value) {
		this.adress = value;
	}
	
	public com.ecommerce.customer.domain.Adress getAdress() {
		return adress;
	}
	
	public void setCustomer(com.ecommerce.customer.domain.Customer value) {
		this.customer = value;
	}
	
	public com.ecommerce.customer.domain.Customer getCustomer() {
		return customer;
	}
	
	public String toString() {
		return String.valueOf(getCustomerAdressId());
	}
	
}

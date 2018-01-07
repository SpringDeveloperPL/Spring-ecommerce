package com.ecommerce.customer.domain;

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


import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="CustomerRole")
public class CustomerRole implements Serializable {
	public CustomerRole() {
	}
	
	@Column(name="customerRoleId", nullable=false, length=20)	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@org.hibernate.annotations.GenericGenerator(name="COM_ECOMMERCE_CUSTOMERROLE_CUSTOMERROLEID_GENERATOR", strategy="native")	
	private long customerRoleId;
	
	@ManyToOne(targetEntity=com.ecommerce.customer.domain.Customer.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="customerId", referencedColumnName="customerId", nullable=false) })	
	private com.ecommerce.customer.domain.Customer customer;
	
	@ManyToOne(targetEntity=com.ecommerce.customer.domain.Role.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="roleId", referencedColumnName="roleId", nullable=false) })	
	private com.ecommerce.customer.domain.Role role;
	
	private void setCustomerRoleId(long value) {
		this.customerRoleId = value;
	}
	
	public long getCustomerRoleId() {
		return customerRoleId;
	}
	
	public long getORMID() {
		return getCustomerRoleId();
	}
	
	public void setCustomer(com.ecommerce.customer.domain.Customer value) {
		this.customer = value;
	}
	
	public com.ecommerce.customer.domain.Customer getCustomer() {
		return customer;
	}
	
	public void setRole(com.ecommerce.customer.domain.Role value) {
		this.role = value;
	}
	
	public com.ecommerce.customer.domain.Role getRole() {
		return role;
	}
	
	public String toString() {
		return String.valueOf(getCustomerRoleId());
	}
	
}

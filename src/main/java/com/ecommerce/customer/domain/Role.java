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
@Table(name="ROLE")
public class Role implements Serializable {
	public Role() {
	}
	
	@Column(name="roleId", nullable=false, length=19)	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@org.hibernate.annotations.GenericGenerator(name="COM_ECOMMERCE_CUSTOMER_DOMAIN_ROLE_ROLEID_GENERATOR", strategy="native")	
	private long roleId;
	
	@Column(name="roleName", nullable=true, length=255)	
	private String roleName;
	
	@OneToMany(mappedBy="role", targetEntity=com.ecommerce.customer.domain.CustomerRole.class,fetch=FetchType.EAGER)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set customerRole = new java.util.HashSet();
	
	private void setRoleId(long value) {
		this.roleId = value;
	}
	
	public long getRoleId() {
		return roleId;
	}
	
	public long getORMID() {
		return getRoleId();
	}
	
	public void setRoleName(String value) {
		this.roleName = value;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setCustomerRole(java.util.Set value) {
		this.customerRole = value;
	}
	
	public java.util.Set getCustomerRole() {
		return customerRole;
	}
	
	
	public String toString() {
		return String.valueOf(getRoleId());
	}
	
}

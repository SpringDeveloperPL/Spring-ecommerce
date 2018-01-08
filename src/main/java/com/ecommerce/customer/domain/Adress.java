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
@Table(name="adress")
public class Adress implements Serializable {
	public Adress() {
	}
	
	@Column(name="adressId", nullable=false, length=19)	
	@Id	
	@GeneratedValue(generator="COM_ECOMMERCE_CUSTOMER_DOMAIN_ADRESS_ADRESSID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_ECOMMERCE_CUSTOMER_DOMAIN_ADRESS_ADRESSID_GENERATOR", strategy="native")	
	private long adressId;
	
	@Column(name="city", nullable=true, length=255)	
	private String city;
	
	@Column(name="companyName", nullable=true, precision=19, scale=0)	
	private java.math.BigDecimal companyName;
	
	@Column(name="country", nullable=true, length=255)	
	private String country;
	
	@Column(name="emailAdress", nullable=true, length=255)	
	private String emailAdress;
	
	@Column(name="fax", nullable=true, length=255)	
	private String fax;
	
	@Column(name="firstName", nullable=true, length=255)	
	private String firstName;
	
	@Column(name="isActive", nullable=true)	
	private Boolean isActive;
	
	@Column(name="isBuisness", nullable=true)	
	private Boolean isBuisness;
	
	@Column(name="isDefault", nullable=true)	
	private Boolean isDefault;
	
	@Column(name="lastName", nullable=true, length=255)	
	private String lastName;
	
	@Column(name="postCode", nullable=true, length=255)	
	private String postCode;
	
	@Column(name="primaryPhone", nullable=true, length=255)	
	private String primaryPhone;
	
	@Column(name="secondaryPhone", nullable=true, length=255)	
	private String secondaryPhone;
	
	@OneToMany(mappedBy="adress", targetEntity=com.ecommerce.customer.domain.CustomerAdress.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set customerAdress = new java.util.HashSet();
	
	private void setAdressId(long value) {
		this.adressId = value;
	}
	
	public long getAdressId() {
		return adressId;
	}
	
	public long getORMID() {
		return getAdressId();
	}
	
	public void setCity(String value) {
		this.city = value;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCompanyName(java.math.BigDecimal value) {
		this.companyName = value;
	}
	
	public java.math.BigDecimal getCompanyName() {
		return companyName;
	}
	
	public void setCountry(String value) {
		this.country = value;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setEmailAdress(String value) {
		this.emailAdress = value;
	}
	
	public String getEmailAdress() {
		return emailAdress;
	}
	
	public void setFax(String value) {
		this.fax = value;
	}
	
	public String getFax() {
		return fax;
	}
	
	public void setFirstName(String value) {
		this.firstName = value;
	}
	
	public String getFirstName() {
		return firstName;
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
	
	public void setIsBuisness(boolean value) {
		setIsBuisness(new Boolean(value));
	}
	
	public void setIsBuisness(Boolean value) {
		this.isBuisness = value;
	}
	
	public Boolean getIsBuisness() {
		return isBuisness;
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
	
	public void setLastName(String value) {
		this.lastName = value;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setPostCode(String value) {
		this.postCode = value;
	}
	
	public String getPostCode() {
		return postCode;
	}
	
	public void setPrimaryPhone(String value) {
		this.primaryPhone = value;
	}
	
	public String getPrimaryPhone() {
		return primaryPhone;
	}
	
	public void setSecondaryPhone(String value) {
		this.secondaryPhone = value;
	}
	
	public String getSecondaryPhone() {
		return secondaryPhone;
	}
	
	public void setCustomerAdress(java.util.Set value) {
		this.customerAdress = value;
	}
	
	public java.util.Set getCustomerAdress() {
		return customerAdress;
	}
	
	
	public String toString() {
		return String.valueOf(getAdressId());
	}
	
}

package com.ecommerce.customer.domain; /**
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

import com.ecommerce.auction.domain.AuctionBidd;
import com.ecommerce.auction.domain.AuctionMessage;
import com.ecommerce.auction.domain.AuctionObserver;
import com.ecommerce.product.doimain.Product;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="CUSTOMER")
public class Customer implements Serializable {
	public Customer() {
	}
	
	@Column(name="customerId", nullable=false, length=10)	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@org.hibernate.annotations.GenericGenerator(name="CUSTOMER_CUSTOMERID_GENERATOR", strategy="identity")	
	private int customerId;
	
	@Column(name="userName", nullable=true, length=255)	
	private String userName;
	
	@Column(name="firstName", nullable=true, length=255)	
	private String firstName;
	
	@Column(name="lastName", nullable=true, length=255)	
	private String lastName;
	
	@Column(name="isRegistred", nullable=true, length=4)	
	private Boolean isRegistred;
	
	@Column(name="isDeleted", nullable=true, length=4)	
	private Boolean isDeleted;
	
	@Column(name="dateCreated", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date dateCreated;
	
	@Column(name="dateUpdated", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date dateUpdated;
	
	@Column(name="password", nullable=true, length=255)	
	private String password;
	
	@Column(name="passwordChangeRequest", nullable=true, length=4)	
	private Boolean passwordChangeRequest;
	
	@Column(name="emailAdress", nullable=true, length=255)	
	private String emailAdress;
	
	@Column(name="reciveEmail", nullable=true, length=4)	
	private Boolean reciveEmail;
	
	@OneToMany(mappedBy="customer", targetEntity=CustomerAdress.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set customeradress = new java.util.HashSet();
	
	@OneToMany(mappedBy="customer", targetEntity=CustomerRole.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set customerrole = new java.util.HashSet();
	
	@OneToMany(mappedBy="bidder", targetEntity=AuctionBidd.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set auctionBidd = new java.util.HashSet();
	
	@OneToMany(mappedBy="auctionWinner", targetEntity=Product.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set product = new java.util.HashSet();
	
	@OneToMany(mappedBy="observer", targetEntity=AuctionObserver.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set auctionObserver = new java.util.HashSet();
	
	@OneToMany(mappedBy="customer", targetEntity=AuctionMessage.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set auctionMessage = new java.util.HashSet();
	
	private void setCustomerId(int value) {
		this.customerId = value;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public int getORMID() {
		return getCustomerId();
	}
	
	public void setUserName(String value) {
		this.userName = value;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setFirstName(String value) {
		this.firstName = value;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String value) {
		this.lastName = value;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setIsRegistred(boolean value) {
		setIsRegistred(new Boolean(value));
	}
	
	public void setIsRegistred(Boolean value) {
		this.isRegistred = value;
	}
	
	public Boolean getIsRegistred() {
		return isRegistred;
	}
	
	public void setIsDeleted(boolean value) {
		setIsDeleted(new Boolean(value));
	}
	
	public void setIsDeleted(Boolean value) {
		this.isDeleted = value;
	}
	
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	
	public void setDateCreated(java.util.Date value) {
		this.dateCreated = value;
	}
	
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	
	public void setDateUpdated(java.util.Date value) {
		this.dateUpdated = value;
	}
	
	public java.util.Date getDateUpdated() {
		return dateUpdated;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPasswordChangeRequest(boolean value) {
		setPasswordChangeRequest(new Boolean(value));
	}
	
	public void setPasswordChangeRequest(Boolean value) {
		this.passwordChangeRequest = value;
	}
	
	public Boolean getPasswordChangeRequest() {
		return passwordChangeRequest;
	}
	
	public void setEmailAdress(String value) {
		this.emailAdress = value;
	}
	
	public String getEmailAdress() {
		return emailAdress;
	}
	
	public void setReciveEmail(boolean value) {
		setReciveEmail(new Boolean(value));
	}
	
	public void setReciveEmail(Boolean value) {
		this.reciveEmail = value;
	}
	
	public Boolean getReciveEmail() {
		return reciveEmail;
	}
	
	public void setCustomeradress(java.util.Set value) {
		this.customeradress = value;
	}
	
	public java.util.Set getCustomeradress() {
		return customeradress;
	}
	
	
	public void setCustomerrole(java.util.Set value) {
		this.customerrole = value;
	}
	
	public java.util.Set getCustomerrole() {
		return customerrole;
	}
	
	
	public void setAuctionBidd(java.util.Set value) {
		this.auctionBidd = value;
	}
	
	public java.util.Set getAuctionBidd() {
		return auctionBidd;
	}
	
	
	public void setProduct(java.util.Set value) {
		this.product = value;
	}
	
	public java.util.Set getProduct() {
		return product;
	}
	
	
	public void setAuctionObserver(java.util.Set value) {
		this.auctionObserver = value;
	}
	
	public java.util.Set getAuctionObserver() {
		return auctionObserver;
	}
	
	
	public void setAuctionMessage(java.util.Set value) {
		this.auctionMessage = value;
	}
	
	public java.util.Set getAuctionMessage() {
		return auctionMessage;
	}
	
	
	public String toString() {
		return String.valueOf(getCustomerId());
	}
	
}

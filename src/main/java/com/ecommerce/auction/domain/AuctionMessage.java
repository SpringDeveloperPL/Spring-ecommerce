package com.ecommerce.auction.domain; /**
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
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.product.doimain.Product;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="auctionMessage")
public class AuctionMessage implements Serializable {
	public AuctionMessage() {
	}
	
	@Column(name="auctionMessageId", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="AUCTIONMESSAGE_AUCTIONMESSAGEID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="AUCTIONMESSAGE_AUCTIONMESSAGEID_GENERATOR", strategy="native")	
	private int auctionMessageId;
	
	@ManyToOne(targetEntity=Customer.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="customerId", referencedColumnName="customerId", nullable=false) })	
	private Customer customer;
	
	@ManyToOne(targetEntity=Product.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="productId", referencedColumnName="productId", nullable=false) })	
	private Product product;
	
	@Column(name="systemMessage", nullable=true)	
	private String systemMessage;
	
	@Column(name="`date`", nullable=true)	
	private java.sql.Timestamp date;
	
	private void setAuctionMessageId(int value) {
		this.auctionMessageId = value;
	}
	
	public int getAuctionMessageId() {
		return auctionMessageId;
	}
	
	public int getORMID() {
		return getAuctionMessageId();
	}
	
	public void setSystemMessage(String value) {
		this.systemMessage = value;
	}
	
	public String getSystemMessage() {
		return systemMessage;
	}
	
	public void setDate(java.sql.Timestamp value) {
		this.date = value;
	}
	
	public java.sql.Timestamp getDate() {
		return date;
	}
	
	public void setCustomer(Customer value) {
		this.customer = value;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setProduct(Product value) {
		this.product = value;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public String toString() {
		return String.valueOf(getAuctionMessageId());
	}
	
}

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

import javax.persistence.*;
import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="auctionobserver")
public class AuctionObserver implements Serializable {
	public AuctionObserver() {
	}
	
	@Column(name="auctionObserverId", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="AUCTIONOBSERVER_AUCTIONOBSERVERID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="AUCTIONOBSERVER_AUCTIONOBSERVERID_GENERATOR", strategy="native")	
	private int auctionObserverId;

	@ManyToOne(targetEntity=Product.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
	@JoinColumns({ @JoinColumn(name="auctionItemId", referencedColumnName="productId", nullable=false) })
	private Product auctionItem;

	@ManyToOne(targetEntity=Customer.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="observerId", referencedColumnName="customerId", nullable=false) })	
	private Customer observer;
	
	@Column(name="isObserver", nullable=true, length=1)	
	private Boolean isObserver;
	
	private void setAuctionObserverId(int value) {
		this.auctionObserverId = value;
	}
	
	public int getAuctionObserverId() {
		return auctionObserverId;
	}

	public int getORMID() {
		return getAuctionObserverId();
	}

	public void setIsObserver(boolean value) {
		setIsObserver(new Boolean(value));
	}

	public void setIsObserver(Boolean value) {
		this.isObserver = value;
	}

	public Boolean getIsObserver() {
		return isObserver;
	}

	public void setAuctionItem(Product value) {
		this.auctionItem = value;
	}

	public Product getAuctionItem() {
		return auctionItem;
	}

	public void setObserver(Customer value) {
		this.observer = value;
	}
	
	public Customer getObserver() {
		return observer;
	}
	
	public String toString() {
		return String.valueOf(getAuctionObserverId());
	}
	
}

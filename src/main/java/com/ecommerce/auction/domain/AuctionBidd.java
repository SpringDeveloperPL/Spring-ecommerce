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
@Table(name="auctionBidd")
public class AuctionBidd implements Serializable {
	public AuctionBidd() {
	}
	
	@Column(name="`auctionBiddId int`", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="AUCTIONBIDD_AUCTIONBIDDID_INT_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="AUCTIONBIDD_AUCTIONBIDDID_INT_GENERATOR", strategy="native")	
	private int auctionBiddId_int;
	
	@ManyToOne(targetEntity=Product.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="auctionItemId", referencedColumnName="productId", nullable=false) })	
	private Product auctionItem;
	
	@ManyToOne(targetEntity=Customer.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="bidderId", referencedColumnName="customerId", nullable=false) })	
	private Customer bidder;
	
	@Column(name="biddPrice", nullable=true, precision=19, scale=0)	
	private java.math.BigDecimal biddPrice;
	
	@Column(name="biddDate", nullable=true)	
	private java.sql.Timestamp biddDate;
	
	@Column(name="isAuctionWinnet", nullable=true, length=1)	
	private Boolean isAuctionWinnet;
	
	private void setAuctionBiddId_int(int value) {
		this.auctionBiddId_int = value;
	}
	
	public int getAuctionBiddId_int() {
		return auctionBiddId_int;
	}
	
	public int getORMID() {
		return getAuctionBiddId_int();
	}
	
	public void setBiddPrice(java.math.BigDecimal value) {
		this.biddPrice = value;
	}
	
	public java.math.BigDecimal getBiddPrice() {
		return biddPrice;
	}
	
	public void setBiddDate(java.sql.Timestamp value) {
		this.biddDate = value;
	}
	
	public java.sql.Timestamp getBiddDate() {
		return biddDate;
	}
	
	public void setIsAuctionWinnet(boolean value) {
		setIsAuctionWinnet(new Boolean(value));
	}
	
	public void setIsAuctionWinnet(Boolean value) {
		this.isAuctionWinnet = value;
	}
	
	public Boolean getIsAuctionWinnet() {
		return isAuctionWinnet;
	}
	
	public void setBidder(Customer value) {
		this.bidder = value;
	}
	
	public Customer getBidder() {
		return bidder;
	}
	
	public void setAuctionItem(Product value) {
		this.auctionItem = value;
	}
	
	public Product getAuctionItem() {
		return auctionItem;
	}
	
	public String toString() {
		return String.valueOf(getAuctionBiddId_int());
	}
	
}

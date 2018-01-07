package com.ecommerce.product.doimain;

import java.util.List;

public class ProductForm {
	
	private Product product;
	private List<Integer> chosedProductCategory;
	private String taxID;
	private String manufacturerID;
	private String auctionEndDate;

	public String getManufacturerID() {
		return manufacturerID;
	}
	public void setManufacturerID(String manufacturerID) {
		this.manufacturerID = manufacturerID;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Integer> getChosedProductCategory() {
		return chosedProductCategory;
	}
	public void setChosedProductCategory(List<Integer> chosedProductCategory) {
		this.chosedProductCategory = chosedProductCategory;
	}
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	public String getAuctionEndDate() {
		return auctionEndDate;
	}
	public  String getTaxID() {
		return taxID;
	}

	public void setAuctionEndDate(String auctionEndDate) {
		this.auctionEndDate = auctionEndDate;
	}


}

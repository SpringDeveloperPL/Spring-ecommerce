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
@Table(name="ProductGroup")
public class ProductGroup implements Serializable {
	public ProductGroup() {
	}
	
	@Column(name="groupId", nullable=false, length=20)	
	@Id	
	@GeneratedValue(generator="COM_ECOMMERCE_PRODUCTGROUP_GROUPID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_ECOMMERCE_PRODUCTGROUP_GROUPID_GENERATOR", strategy="native")	
	private long groupId;
	
	@ManyToOne(targetEntity=com.ecommerce.product.doimain.Product.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="productId", referencedColumnName="productId", nullable=false) })	
	private com.ecommerce.product.doimain.Product product;
	
	@Column(name="groupName", nullable=true, length=255)	
	private String groupName;
	
	@ManyToOne(targetEntity=com.ecommerce.product.doimain.PricingModel.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="pricingModelId", referencedColumnName="pricingModelId", nullable=false) })	
	private com.ecommerce.product.doimain.PricingModel pricingModel;
	
	private void setGroupId(long value) {
		this.groupId = value;
	}
	
	public long getGroupId() {
		return groupId;
	}
	
	public long getORMID() {
		return getGroupId();
	}
	
	public void setGroupName(String value) {
		this.groupName = value;
	}
	
	public String getGroupName() {
		return groupName;
	}
	
	public void setProduct(com.ecommerce.product.doimain.Product value) {
		this.product = value;
	}
	
	public com.ecommerce.product.doimain.Product getProduct() {
		return product;
	}
	
	public void setPricingModel(com.ecommerce.product.doimain.PricingModel value) {
		this.pricingModel = value;
	}
	
	public com.ecommerce.product.doimain.PricingModel getPricingModel() {
		return pricingModel;
	}
	
	public String toString() {
		return String.valueOf(getGroupId());
	}
	
}

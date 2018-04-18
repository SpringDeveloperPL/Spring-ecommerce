package com.ecommerce.product.doimain; /**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee:
 * License Type: Evaluation
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */

import com.ecommerce.auction.domain.AuctionBidd;
import com.ecommerce.auction.domain.AuctionMessage;
import com.ecommerce.auction.domain.AuctionObserver;
import com.ecommerce.cart.domain.Payment;
import com.ecommerce.category.domain.ProductCategory;
import com.ecommerce.customer.domain.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "PRODUCT")
public class Product implements Serializable {
    public Product() {
    }

    @Column(name = "productId", nullable = false, length = 11)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @org.hibernate.annotations.GenericGenerator(name = "COM_ECOMMERCE_PRODUCT_PRODUCTID_GENERATOR", strategy = "identity")
    private int productId;
    @JsonIgnore
    @Column(name = "defaultCategoryId", nullable = true, length = 11)
    private Integer defaultCategoryId;
    @JsonIgnore
    @Column(name = "defaultColorId", nullable = true, length = 10)
    private Integer defaultColorId;
    @JsonIgnore
    @Column(name = "on_sale", nullable = true, length = 1)
    private Boolean on_sale;
    @Column(name = "quantity", nullable = true, length = 11)
    private Integer quantity;
    @Column(name = "price", nullable = true, length = 11)
    private Integer price;
    @JsonIgnore
    @Column(name = "wholesalePrice", nullable = true, length = 11)
    private Integer wholesalePrice;
    @JsonIgnore
    @Column(name = "reductionPrice", nullable = true, length = 11)
    private Integer reductionPrice;
    @JsonIgnore
    @Column(name = "weight", nullable = true, length = 11)
    private Integer weight;

    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @JsonIgnore
    @Column(name = "url", nullable = true, length = 255)
    private String url;
    @JsonIgnore
    @Column(name = "activeStartDate", nullable = true)
    private java.sql.Timestamp activeStartDate;
    @JsonIgnore
    @Column(name = "activeEndDate", nullable = true)
    private java.sql.Timestamp activeEndDate;
    @JsonIgnore
    @Column(name = "sku", nullable = true, length = 255)
    private String sku;

    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @JsonIgnore
    @Column(name = "longDescription", nullable = true)
    private String longDescription;
    @JsonIgnore
    @Column(name = "active", nullable = true, length = 1)
    private Boolean active;
    @Column(name = "imageName", nullable = true, length = 255)
    private String imageName;

    @JsonIgnore
    @ManyToOne(targetEntity = Manufacturer.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({@JoinColumn(name = "manufacturerId", referencedColumnName = "manufacturerId")})
    private Manufacturer manufacturer;

    @JsonIgnore
    @ManyToOne(targetEntity = Tax.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({@JoinColumn(name = "taxID", referencedColumnName = "taxId")})
    private Tax tax;

    @JsonIgnore
    @ManyToOne(targetEntity = Color.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({@JoinColumn(name = "colorId", referencedColumnName = "colorId")})
    private Color color;
    @JsonIgnore
    @Column(name = "onAuction", nullable = true, length = 1)
    private Boolean onAuction;
    @JsonIgnore
    @Column(name = "auctionStartDate", nullable = true)
    private java.sql.Timestamp auctionStartDate;
    @JsonIgnore
    @Column(name = "auctionEndDate", nullable = true)
    private java.sql.Timestamp auctionEndDate;

    @Column(name = "bidAmout", nullable = true, precision = 19, scale = 0)
    private java.math.BigDecimal bidAmout;
    @JsonIgnore
    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({@JoinColumn(name = "auctionWinner", referencedColumnName = "customerId")})
    private Customer auctionWinner;
    @JsonIgnore
    @OneToMany(mappedBy = "product", targetEntity = ProductCategory.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set productcategory = new java.util.HashSet();
    @JsonIgnore
    @OneToMany(mappedBy = "product", targetEntity = ProductGroup.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set productgroup = new java.util.HashSet();
    @JsonIgnore
    @OneToMany(mappedBy = "product", targetEntity = ProductAttrubute.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set productattrubute = new java.util.HashSet();
    @JsonIgnore
    @OneToMany(mappedBy = "product", targetEntity = ProductImage.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set productImage = new java.util.HashSet();
    @JsonIgnore
    @OneToMany(mappedBy = "auctionItem", targetEntity = AuctionBidd.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set auctionBidd = new java.util.HashSet();
    @JsonIgnore
    @OneToMany(mappedBy = "auctionItem", targetEntity = AuctionObserver.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set auctionObserver = new java.util.HashSet();
    @JsonIgnore
    @OneToMany(mappedBy = "product", targetEntity = AuctionMessage.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set auctionMessage = new java.util.HashSet();

    @OneToMany(mappedBy = "product", targetEntity = com.ecommerce.cart.domain.Payment.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set payment = new java.util.HashSet();

    private void setProductId(int value) {
        this.productId = value;
    }

    public int getProductId() {
        return productId;
    }

    public int getORMID() {
        return getProductId();
    }

    public void setDefaultCategoryId(int value) {
        setDefaultCategoryId(new Integer(value));
    }

    public void setDefaultCategoryId(Integer value) {
        this.defaultCategoryId = value;
    }

    public Integer getDefaultCategoryId() {
        return defaultCategoryId;
    }

    public void setDefaultColorId(int value) {
        setDefaultColorId(new Integer(value));
    }

    public void setDefaultColorId(Integer value) {
        this.defaultColorId = value;
    }

    public Integer getDefaultColorId() {
        return defaultColorId;
    }

    public void setOn_sale(boolean value) {
        setOn_sale(new Boolean(value));
    }

    public void setOn_sale(Boolean value) {
        this.on_sale = value;
    }

    public Boolean getOn_sale() {
        return on_sale;
    }

    public void setQuantity(int value) {
        setQuantity(new Integer(value));
    }

    public void setQuantity(Integer value) {
        this.quantity = value;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setPrice(int value) {
        setPrice(new Integer(value));
    }

    public void setPrice(Integer value) {
        this.price = value;
    }

    public Integer getPrice() {
        return price;
    }

    public void setWholesalePrice(int value) {
        setWholesalePrice(new Integer(value));
    }

    public void setWholesalePrice(Integer value) {
        this.wholesalePrice = value;
    }

    public Integer getWholesalePrice() {
        return wholesalePrice;
    }

    public void setReductionPrice(int value) {
        setReductionPrice(new Integer(value));
    }

    public void setReductionPrice(Integer value) {
        this.reductionPrice = value;
    }

    public Integer getReductionPrice() {
        return reductionPrice;
    }

    public void setWeight(int value) {
        setWeight(new Integer(value));
    }

    public void setWeight(Integer value) {
        this.weight = value;
    }

    public Set getPayment() {
        return payment;
    }

    public void setPayment(Set payment) {
        this.payment = payment;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return name;
    }

    public void setUrl(String value) {
        this.url = value;
    }

    public String getUrl() {
        return url;
    }

    public void setActiveStartDate(java.sql.Timestamp value) {
        this.activeStartDate = value;
    }

    public java.sql.Timestamp getActiveStartDate() {
        return activeStartDate;
    }

    public void setActiveEndDate(java.sql.Timestamp value) {
        this.activeEndDate = value;
    }

    public java.sql.Timestamp getActiveEndDate() {
        return activeEndDate;
    }

    public void setSku(String value) {
        this.sku = value;
    }

    public String getSku() {
        return sku;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getDescription() {
        return description;
    }

    public void setLongDescription(String value) {
        this.longDescription = value;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setActive(boolean value) {
        setActive(new Boolean(value));
    }

    public void setActive(Boolean value) {
        this.active = value;
    }

    public Boolean getActive() {
        return active;
    }

    public void setImageName(String value) {
        this.imageName = value;
    }

    public String getImageName() {
        return imageName;
    }

    public void setOnAuction(boolean value) {
        setOnAuction(new Boolean(value));
    }

    public void setOnAuction(Boolean value) {
        this.onAuction = value;
    }

    public Boolean getOnAuction() {
        return onAuction;
    }

    public void setAuctionStartDate(java.sql.Timestamp value) {
        this.auctionStartDate = value;
    }

    public java.sql.Timestamp getAuctionStartDate() {
        return auctionStartDate;
    }

    public void setAuctionEndDate(java.sql.Timestamp value) {
        this.auctionEndDate = value;
    }

    public java.sql.Timestamp getAuctionEndDate() {
        return auctionEndDate;
    }

    public void setBidAmout(java.math.BigDecimal value) {
        this.bidAmout = value;
    }

    public java.math.BigDecimal getBidAmout() {
        return bidAmout;
    }

    public void setTax(Tax value) {
        this.tax = value;
    }

    public Tax getTax() {
        return tax;
    }

    public void setManufacturer(Manufacturer value) {
        this.manufacturer = value;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setColor(Color value) {
        this.color = value;
    }

    public Color getColor() {
        return color;
    }

    public void setAuctionWinner(Customer value) {
        this.auctionWinner = value;
    }

    public Customer getAuctionWinner() {
        return auctionWinner;
    }

    public void setProductcategory(java.util.Set value) {
        this.productcategory = value;
    }

    public java.util.Set getProductcategory() {
        return productcategory;
    }


    public void setProductgroup(java.util.Set value) {
        this.productgroup = value;
    }

    public java.util.Set getProductgroup() {
        return productgroup;
    }


    public void setProductattrubute(java.util.Set value) {
        this.productattrubute = value;
    }

    public java.util.Set getProductattrubute() {
        return productattrubute;
    }


    public void setProductImage(java.util.Set value) {
        this.productImage = value;
    }

    public java.util.Set getProductImage() {
        return productImage;
    }


    public void setAuctionBidd(java.util.Set value) {
        this.auctionBidd = value;
    }

    public java.util.Set getAuctionBidd() {
        return auctionBidd;
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
        return String.valueOf(getProductId());
    }

}

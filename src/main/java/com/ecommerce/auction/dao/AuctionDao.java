package com.ecommerce.auction.dao;

import com.ecommerce.auction.domain.AuctionBidd;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.product.doimain.Product;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface AuctionDao {

    /**
     * product Bidd by Customer
     * @param product
     * @param customer
     * @param biddPrice
     * @param biddDate
     */
    public void productBidd(Product product, Customer customer, BigDecimal biddPrice, Timestamp biddDate);

    /**
     * Product Bid by Customer
     * @param auctionBidd
     */
    public void productBidd(AuctionBidd auctionBidd);

}

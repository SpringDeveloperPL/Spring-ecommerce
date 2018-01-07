package com.ecommerce.auction.service;

import com.ecommerce.auction.domain.AuctionBidd;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.product.doimain.Product;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;

public interface AuctionService {
    /**
     * Parse date from Html Form to Timestamp format
     * @param time
     * @return
     */
    public Timestamp parseStringToTimestamp(String time) throws ParseException;

    /**
     * getting Auction Start Date
     * @return Timestammp
     */
    public Timestamp getAuctionStartDate();

    /**
     * getting Auction Count Down Time in Nanos used for java script timer on client side
     * @param endDate
     * @return
     */
    public long getAuctionCountDownNanos(Timestamp endDate);

    /**
     * Product Bidd
     * @param product
     * @param customer
     * @param biddPrice
     * @param biddDate
     */
    public void productBidd(Product product, Customer customer, BigDecimal biddPrice, Timestamp biddDate);

    /**
     * Product Bidd
     */
    public void productBidd(AuctionBidd auctionBidd);

    /**
     * Getting biddDate for customer Bidd
     * @return
     */
    public Timestamp getBiddDate();
}

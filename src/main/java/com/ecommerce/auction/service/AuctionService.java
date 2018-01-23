package com.ecommerce.auction.service;

import com.ecommerce.auction.domain.AuctionBidd;
import com.ecommerce.auction.domain.AuctionObserver;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.product.doimain.Product;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

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

    /**
     * Check if product auction is closed
     * @param product
     * @return
     */
    public boolean auctionClosed(Product product);

    /**
     * Register auction observer for sending information about status of bid auction
     * @param customer
     * @param product
     */
    public void registerAuctionObserver(Customer customer,Product product);

    /**
     * Find Auction Observer
     * @param customer
     * @param product
     * @return
     */
    public AuctionObserver findAuctionObserver(Customer customer,Product product);

    /**
     * Getting List of auction observers
     * @return
     */
    public List<AuctionObserver> findAllAuctionObservers();

    /**
     * Getting List of Auction observers
     * @param product
     * @return
     */
    public List<AuctionObserver> getListProductAuctionObservers(Product product);

    /**
     * Getting count of product auction observer
     * @param product
     * @return
     */
    public int getCountProductAuctionObserver(Product product);

    /**
     * Check if auction observer is registred
     * @param customer
     * @param product
     * @return
     */
    public boolean isRegistredAuctionObserver(Customer customer,Product product);


}

package com.ecommerce.auction.dao;

import com.ecommerce.auction.domain.AuctionBidd;
import com.ecommerce.auction.domain.AuctionMessage;
import com.ecommerce.auction.domain.AuctionObserver;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.product.doimain.Product;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

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

    /**
     * Register auction observer DAO
     * @param auctionObserver
     */
    void registerAuctionObserver(AuctionObserver auctionObserver);

    /**
     * Getting List of All Auction observers
     * @return
     */
    List<AuctionObserver> findAllAuctionObservers();

    /**
     * Save Auction Message
     * @param auctionMessage
     */
    void saveAuctionMessage(AuctionMessage auctionMessage);

    /**
     * Getting All auctions Messages sended to Customer
     * @return
     */
    List<AuctionMessage> getAllAuctionMessages();

    /**
     * Getting all Auctions Bidds
     * @return
     */
    List<AuctionBidd> getAllAuctionBidds();
}

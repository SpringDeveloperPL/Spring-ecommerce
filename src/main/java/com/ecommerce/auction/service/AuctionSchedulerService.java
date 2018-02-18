package com.ecommerce.auction.service;

import com.ecommerce.auction.domain.AuctionBidd;

import java.util.List;

/**
 * Scheduler's task is to select the auction winners, when Auction Time out
 */
public interface AuctionSchedulerService {

    /**
     * Process auctions
     */
    public void  processAuctions();

    /**
     * Getting all actual auctions Bidds
     * @return
     */
    public List<AuctionBidd> getAllActiveAuctionsBidds();
}

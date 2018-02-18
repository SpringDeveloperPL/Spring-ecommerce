package com.ecommerce.auction.service;

import com.ecommerce.auction.domain.AuctionBidd;

import java.util.List;

public interface AuctionSchedulerService {

    /**
     * Process auctions
     */
    public void  processAuctions();

    /**
     * Getting all auctial auctions Bidds
     * @return
     */
    public List<AuctionBidd> getAllActiveAuctionsBidds();
}

package com.ecommerce.auction.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class AuctionBiddHistoryElement {

    private String userName;
    private Timestamp biddDate;
    private BigDecimal prcie;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getBiddDate() {
        return biddDate;
    }

    public void setBiddDate(Timestamp biddDate) {
        this.biddDate = biddDate;
    }

    public BigDecimal getPrcie() {
        return prcie;
    }

    public void setPrcie(BigDecimal prcie) {
        this.prcie = prcie;
    }
}

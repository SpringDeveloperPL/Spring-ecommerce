package com.ecommerce.auction.service;

import com.ecommerce.auction.dao.AuctionDao;
import com.ecommerce.auction.dao.AuctionDaoImpl;
import com.ecommerce.auction.domain.AuctionBidd;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.product.doimain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service("auctionService")
public class AuctionServiceImpl implements  AuctionService {

    @Autowired
    AuctionDao auctionDao;

    @Override
    public Timestamp parseStringToTimestamp(String time) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = simpleDateFormat.parse(time);
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }

    @Override
    public Timestamp getAuctionStartDate() {
        Date currentDate = new Date();
        Timestamp timestamp = new Timestamp(currentDate.getTime());
        return timestamp;
    }

    @Override
    public long getAuctionCountDownNanos(Timestamp endDate) {
        Timestamp serverTime = new Timestamp(new Date().getTime());
        long endDateNanos= endDate.getTime();
        long serverTimeNanos = serverTime.getTime();
        long countDownTime = endDateNanos- serverTimeNanos;
        return countDownTime;
    }

    @Override
    public void productBidd(Product product, Customer customer, BigDecimal biddPrice, Timestamp biddDate) {
        auctionDao.productBidd(product,customer,biddPrice,biddDate);

        AuctionBidd auctionBidd = new AuctionBidd();
    }

    @Override
    public void productBidd(AuctionBidd auctionBidd) {
        auctionDao.productBidd(auctionBidd);
    }

    @Override
    public Timestamp getBiddDate() {
        Date currentDate = new Date();
        Timestamp timestamp = new Timestamp(currentDate.getTime());
        return timestamp;
    }


}

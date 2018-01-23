package com.ecommerce.auction.service;

import com.ecommerce.auction.dao.AuctionDao;
import com.ecommerce.auction.domain.AuctionBidd;
import com.ecommerce.auction.domain.AuctionObserver;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.product.doimain.Product;
import com.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("auctionService")
public class AuctionServiceImpl implements  AuctionService {

    @Autowired
    AuctionDao auctionDao;

    @Autowired
    ProductService productService;

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
    public void productBidd(AuctionBidd auctionBidd)
    {

        //Check if auction is not closed
        if(auctionBidd.getAuctionItem().getOnAuction()) {
            //Registring observer auction if exist do not register
            registerAuctionObserver(auctionBidd.getBidder(),auctionBidd.getAuctionItem());
            int result = auctionBidd.getAuctionItem().getBidAmout().compareTo(auctionBidd.getBiddPrice());
            if(result==-1) {
                auctionDao.productBidd(auctionBidd);
                auctionBidd.getAuctionItem().setBidAmout(auctionBidd.getBiddPrice());
                productService.updateProduct(auctionBidd.getAuctionItem());
            }
        }

    }

    @Override
    public Timestamp getBiddDate() {
        Date currentDate = new Date();
        Timestamp timestamp = new Timestamp(currentDate.getTime());
        return timestamp;
    }

    @Override
    public boolean auctionClosed(Product product) {
        if(product.getOnAuction()==false)
        {
            return true;
        }
        return false;
    }

    @Override
    public void registerAuctionObserver(Customer customer, Product product) {
        if(isRegistredAuctionObserver(customer,product)==false) {
            AuctionObserver auctionObserver = new AuctionObserver();
            auctionObserver.setAuctionItem(product);
            auctionObserver.setIsObserver(true);
            auctionObserver.setObserver(customer);
            auctionDao.registerAuctionObserver(auctionObserver);
        }
    }

    @Override
    public AuctionObserver findAuctionObserver(Customer customer, Product product) {
        List<AuctionObserver> auctionObserversList = auctionDao.findAllAuctionObservers();
        AuctionObserver observer = null;
        for(AuctionObserver ao: auctionObserversList) {
            if(ao.getObserver().getCustomerId()==customer.getCustomerId()
                    && ao.getAuctionItem().getProductId()==product.getProductId()) {
                observer= ao;
            }
        }
        return observer;
    }

    @Override
    public List<AuctionObserver> findAllAuctionObservers() {
        return auctionDao.findAllAuctionObservers();
    }

    @Override
    public List<AuctionObserver> getListProductAuctionObservers(Product product) {

        List<AuctionObserver> auctionObservers = new ArrayList<>();
        List<AuctionObserver> allAuctionObserver =findAllAuctionObservers();

        for (AuctionObserver observer : allAuctionObserver) {
            if(observer.getAuctionItem().equals(product)) {
                auctionObservers.add(observer);
            }
        }
        return auctionObservers;
    }

    @Override
    public int getCountProductAuctionObserver(Product product) {

        return getListProductAuctionObservers(product).size();
    }

    @Override
    public boolean isRegistredAuctionObserver(Customer customer, Product product) {
        AuctionObserver auctionObserver = findAuctionObserver(customer,product);
        if(auctionObserver==null) {
            return false;
        }
        else return true;
    }


}

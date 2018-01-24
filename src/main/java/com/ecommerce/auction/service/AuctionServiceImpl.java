package com.ecommerce.auction.service;

import com.ecommerce.auction.dao.AuctionDao;
import com.ecommerce.auction.domain.AuctionBidd;
import com.ecommerce.auction.domain.AuctionBiddHistoryElement;
import com.ecommerce.auction.domain.AuctionMessage;
import com.ecommerce.auction.domain.AuctionObserver;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.customer.service.CustomerService;
import com.ecommerce.product.doimain.Product;
import com.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.management.resources.agent;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.Collator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("auctionService")
public class AuctionServiceImpl implements  AuctionService {

    @Autowired
    AuctionDao auctionDao;

    @Autowired
    ProductService productService;

    @Autowired
    CustomerService customerService;

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
    public Map<String,String> productBidd(AuctionBidd auctionBidd)
    {
        Map<String,String>  errorList = new HashMap<>();
        //Check if auction is not closed
        if(auctionBidd.getAuctionItem().getOnAuction()) {
            //Registring observer auction if exist do not register
            registerAuctionObserver(auctionBidd.getBidder(),auctionBidd.getAuctionItem());
            int result = auctionBidd.getAuctionItem().getBidAmout().compareTo(auctionBidd.getBiddPrice());
            if(result==-1) {
                auctionDao.productBidd(auctionBidd);
                auctionBidd.getAuctionItem().setBidAmout(auctionBidd.getBiddPrice());
                //seting price = count bidders
                //is literal in name
                auctionBidd.setIsAuctionWinnet(true);
                auctionBidd.getAuctionItem().setPrice(getCountProductAuctionObserver(auctionBidd.getAuctionItem()));
                productService.updateProduct(auctionBidd.getAuctionItem());
                notifyObserverAboutHigherOffer(auctionBidd);
                errorList.put("Success","Your offer Wins");
            }else
                errorList.put("Warning","Your offer is too low");
        }
        return errorList;

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
            if(observer.getAuctionItem().getProductId()==product.getProductId()) {
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

    @Override
    public void notifyObserverAboutHigherOffer(AuctionBidd auctionBidd) {
        List<AuctionObserver> auctionObservers = getListProductAuctionObservers(auctionBidd.getAuctionItem());

        for (AuctionObserver auctionObserver : auctionObservers) {
            if(auctionBidd.getBidder().getCustomerId()!=auctionObserver.getObserver().getCustomerId()) {
                AuctionMessage auctionMessage = new AuctionMessage();
                auctionMessage.setSystemMessage("Your last offer has been outdone ");
                auctionMessage.setCustomer(auctionObserver.getObserver());
                auctionMessage.setProduct(auctionBidd.getAuctionItem());
                auctionMessage.setDate(auctionBidd.getBiddDate());
                sendAuctionMessage(auctionMessage);
            }
            else {
                AuctionMessage messageForWinner = new AuctionMessage();
                messageForWinner.setSystemMessage("Your offer Wins");
                messageForWinner.setCustomer(auctionObserver.getObserver());
                messageForWinner.setProduct(auctionBidd.getAuctionItem());
                messageForWinner.setDate(auctionBidd.getBiddDate());
                sendAuctionMessage(messageForWinner);
            }

        }
    }

    @Override
    public void sendAuctionMessage(AuctionMessage auctionMessage) {
        auctionDao.saveAuctionMessage(auctionMessage);

    }

    @Override
    public List<AuctionMessage> getCustomerAuctionMessageList(Customer customer) {

        List<AuctionMessage> allAuctionMessages = getAllAuctionMessages();
        List<AuctionMessage> customerAuctionMessages = new ArrayList<>();

        for (AuctionMessage auctionMessage : allAuctionMessages) {
            if(customer.getCustomerId()==auctionMessage.getCustomer().getCustomerId())
                customerAuctionMessages.add(auctionMessage);
        }
        return customerAuctionMessages;
    }

    @Override
    public List<AuctionMessage> getAllAuctionMessages() {
        return auctionDao.getAllAuctionMessages();
    }

    @Override
    public Map<Product, AuctionMessage> getAuctionMessageAttachedCustomerProductAuction(Customer customer) {

        Map<Product,AuctionMessage> result = new HashMap<>();

        List<Product> allProductList = productService.findAllProducts();
        List<AuctionMessage> allAuctionMessages = getAllAuctionMessages();

        for (AuctionMessage auctionMessage : allAuctionMessages) {
            if(auctionMessage.getCustomer().getCustomerId()==customer.getCustomerId()) {
                for (Product product : allProductList) {
                    if(auctionMessage.getProduct().getProductId()==product.getProductId()) {
                        result.put(product,auctionMessage);
                    }
                }
            }
        }

        return result;
    }

    @Override
    public List<Product> getBiddedAuctions() {
        List<Product> biddedAuctions = new ArrayList<>();
        List<Product> allAuctions = productService.findAllProducts();
        List<AuctionBidd> allAuctionBidd = getAllAuctionBidds();

        for (AuctionBidd auctionBidd : allAuctionBidd) {
            for (Product auction : allAuctions) {
                if(auctionBidd.getAuctionItem().getProductId()==auction.getProductId()) {
                    biddedAuctions.add(auction);
                }
            }
        }
        return biddedAuctions;
    }

    @Override
    public List<AuctionBidd> getAllAuctionBidds() {
        return auctionDao.getAllAuctionBidds();
    }

    @Override
    public Map<AuctionBidd,Customer> getBiddsHistory(Product product) {

        List<Customer> allCustomers = customerService.findAllCustomers();
        List<AuctionBidd> allAuctionBidds= getAllAuctionBidds();

        Map<AuctionBidd,Customer> result = new HashMap<>();

        for (AuctionBidd auctionBidd : allAuctionBidds) {
            if(auctionBidd.getAuctionItem().getProductId()==product.getProductId()) {

                result.put(auctionBidd,auctionBidd.getBidder());
            }
        }
        return result;
    }




}

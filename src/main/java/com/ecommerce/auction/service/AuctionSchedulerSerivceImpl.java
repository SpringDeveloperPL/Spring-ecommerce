package com.ecommerce.auction.service;

import com.ecommerce.auction.domain.AuctionBidd;
import com.ecommerce.auction.domain.AuctionMessage;
import com.ecommerce.cart.dao.PaymentDao;
import com.ecommerce.cart.domain.Payment;
import com.ecommerce.cart.service.PaymentService;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.product.doimain.Product;
import com.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Component
@EnableScheduling
public class AuctionSchedulerSerivceImpl implements AuctionSchedulerService {

    @Autowired
    AuctionService auctionService;

    @Autowired
    ProductService productService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentDao paymentDao;


    public List<Product> getListOfActiveAuctions() {
        return listOfActiveAuctions;
    }

    public void setListOfActiveAuctions(List<Product> listOfActiveAuctions) {
        this.listOfActiveAuctions = listOfActiveAuctions;
    }

    List<com.ecommerce.product.doimain.Product> listOfActiveAuctions;


    @Scheduled(fixedRate = 1000)
    public void processAuctions() {


        for (Product auction : listOfActiveAuctions) {

            try {

                if (auction.getAuctionEndDate().before(auctionService.getAuctionStartDate()) && auction.getActive() != false) {
                    auction.setActive(false);
                    auction.setOnAuction(false);
                    productService.updateProduct(auction);
//                AuctionMessage auctionMessage = new AuctionMessage();
//                auctionMessage.setProduct(auction);
//                auctionMessage.setCustomer(bidd.getBidder());
                    AuctionBidd windwrBidd = auctionService.findAuctionWinner(auction);

                    //sending notify to observers
                    auctionService.sendMessageToAuctionWinnerAndLoser(windwrBidd.getBidder(), auction);
                    //Creating new Pending Payment
                    paymentService.registerNewPendingPayment(auction, false, auctionService.getAuctionStartDate(), "Pending for Pay", windwrBidd.getBidder());
                    getListOfActiveAuctions().remove(auction);
                    System.out.println("Auction id = " + auction.getProductId() + " Closed");

                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @PostConstruct
    public void  getAllAllAuctionsBidds(){
        setListOfActiveAuctions(auctionService.getActiveAuctionsList());
    }

}

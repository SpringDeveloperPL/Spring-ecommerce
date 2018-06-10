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

    @PostConstruct
    public void  getAllActiveAuctions(){
        setListOfActiveAuctions(auctionService.getActiveAuctionsList());
    }

    @Scheduled(fixedRate = 1000)
    public void processAuctions() {

        getAllActiveAuctions();

        if (listOfActiveAuctions.size()>0) {
            for (Product auction : listOfActiveAuctions) {

                try {

                    if (auction.getAuctionEndDate().before(auctionService.getAuctionStartDate()) && auction.getActive() != false) {
                        auction.setActive(false);
                        auction.setOnAuction(false);
                        productService.updateProduct(auction);
                        AuctionBidd winnerBidd = auctionService.findAuctionWinner(auction);
                        //sending notify to observers
                        auctionService.sendMessageToAuctionWinnerAndLoser(winnerBidd.getBidder(), auction);
                        //Creating new Pending Payment
                        paymentService.registerNewPendingPayment(auction, false, false, null, "Pending for Pay", winnerBidd.getBidder());
                        getListOfActiveAuctions().remove(auction);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

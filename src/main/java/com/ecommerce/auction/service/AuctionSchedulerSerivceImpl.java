package com.ecommerce.auction.service;

import com.ecommerce.auction.domain.AuctionBidd;
import com.ecommerce.auction.domain.AuctionMessage;
import com.ecommerce.auction.service.AuctionService;
import com.ecommerce.product.doimain.Product;
import com.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.List;

@Service
@Component
@EnableScheduling
public class AuctionSchedulerSerivceImpl implements AuctionSchedulerService {

    @Autowired
    AuctionService auctionService;

    @Autowired
    ProductService productService;


    public List<AuctionBidd> getAllActiveAuctionsBidds() {
        return allActiveAuctionsBidds;
    }

    public void setAllActiveAuctionsBidds(List<AuctionBidd> allActiveAuctionsBidds) {
        this.allActiveAuctionsBidds = allActiveAuctionsBidds;
    }

    private List<AuctionBidd> allActiveAuctionsBidds;


    @Scheduled(fixedRate = 1000)
    public void processAuctions() {

        List<AuctionBidd> allBidds = getAllActiveAuctionsBidds();

        for (AuctionBidd bidd : allBidds) {

            if(bidd.getAuctionItem().getAuctionEndDate().before(auctionService.getAuctionStartDate())&&bidd.getAuctionItem().getActive()!=false) {
                bidd.getAuctionItem().setActive(false);
                bidd.getAuctionItem().setOnAuction(false);
                productService.updateProduct(bidd.getAuctionItem());
                AuctionMessage auctionMessage = new AuctionMessage();
                auctionMessage.setProduct(bidd.getAuctionItem());
                auctionMessage.setCustomer(bidd.getBidder());
                auctionService.sendMessageToAuctionWinnerAndLoser(bidd.getBidder(),bidd.getAuctionItem());
                getAllActiveAuctionsBidds().remove(bidd);
                System.out.println("Auction id = "+bidd.getAuctionItem().getProductId()  +" Closed");
                System.out.println("okok");

            }
        }
    }


    @PostConstruct
    public void  getAllAllAuctionsBidds(){
        setAllActiveAuctionsBidds(auctionService.getAllActiveAuctionBidds());
    }
}

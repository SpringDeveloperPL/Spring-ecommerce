package com.ecommerce.auction.dao;

import com.ecommerce.auction.domain.AuctionBidd;
import com.ecommerce.auction.domain.AuctionMessage;
import com.ecommerce.auction.domain.AuctionObserver;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.product.doimain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
public class AuctionDaoImpl implements AuctionDao {

    @Autowired
    SessionFactory sessionFactory;

    public AuctionDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public Session getCurrentSesion() {
        return sessionFactory.getCurrentSession();
    }


    public void productBidd(Product product, Customer customer, BigDecimal biddPrice, Timestamp biddDate) {

    }

    @Override
    public void productBidd(AuctionBidd auctionBidd) {
        Session session = getCurrentSesion();
        session.save(auctionBidd);
    }

    @Override
    public void registerAuctionObserver(AuctionObserver auctionObserver) {
        Session session = getCurrentSesion();
        session.save(auctionObserver);
    }

    @Override
    public List<AuctionObserver> findAllAuctionObservers() {
        Session session = getCurrentSesion();
        return session.createCriteria(AuctionObserver.class).list();
    }

    @Override
    public void saveAuctionMessage(AuctionMessage auctionMessage) {
        Session session = getCurrentSesion();
        session.save(auctionMessage);
    }


    @Override
    public List<AuctionMessage> getAllAuctionMessages() {
        Session session = getCurrentSesion();
        return session.createCriteria(AuctionMessage.class).list();
    }

    @Override
    public List<AuctionBidd> getAllAuctionBidds() {
        Session session =getCurrentSesion();
        return session.createCriteria(AuctionBidd.class).list();
    }


}

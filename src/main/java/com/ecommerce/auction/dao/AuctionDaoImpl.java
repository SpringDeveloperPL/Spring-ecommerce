package com.ecommerce.auction.dao;

import com.ecommerce.auction.domain.AuctionBidd;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.product.doimain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Repository
@Transactional
public class AuctionDaoImpl implements AuctionDao {

    @Autowired
    SessionFactory sessionFactory;

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


}

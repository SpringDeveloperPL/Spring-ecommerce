package com.ecommerce.cart.dao;

import com.ecommerce.cart.domain.Cart;
import com.ecommerce.cart.domain.CartDetail;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CartDaoImp implements CartDao {

    @Autowired
    SessionFactory sessionFactory;

    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveCart(Cart cat) {
        Session session= getCurrentSession();
        session.save(cat);
    }

    @Override
    public void updateCartDetails(CartDetail cartDetail) {
        Session session = getCurrentSession();
        session.saveOrUpdate(cartDetail);
    }

    @Override
    public List<CartDetail> getAllCartDetails() {
        Session session=  getCurrentSession();
        return session.createCriteria(CartDetail.class).list();
    }

    @Override
    public void updateCart(Cart cart) {
        Session session = getCurrentSession();
        session.saveOrUpdate(cart);
    }

    @Override
    public void removeItem(int cartItemID) {
        Session session = getCurrentSession();
        Query query = session.createQuery("delete CartDetail where cartDetailID = :ID");
        query.setParameter("ID", cartItemID);
        query.executeUpdate();
    }
}

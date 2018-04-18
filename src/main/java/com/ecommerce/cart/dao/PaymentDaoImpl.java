package com.ecommerce.cart.dao;

import com.ecommerce.cart.domain.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PaymentDaoImpl implements PaymentDao {

    @Autowired
    SessionFactory sessionFactory;

    public Session getCurrentSesion(){
       return sessionFactory.getCurrentSession();
    }

    public void savePayment(Payment payment) {
        Session session = getCurrentSesion();
        session.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        Session session = getCurrentSesion();
        return session.createCriteria(Payment.class).list();

    }
}

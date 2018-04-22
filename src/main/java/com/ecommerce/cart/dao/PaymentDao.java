package com.ecommerce.cart.dao;

import com.ecommerce.cart.domain.Payment;

import java.util.List;

public interface PaymentDao {

    /**
     * Saving New Payment
     * @param payment
     */
    public void savePayment(Payment payment);

    /**
     * Getting All Payments from System
     * @return
     */
    List<Payment> getAllPayments();

    /**
     * Getting Payment by ID DAO
     * @param paymentID
     * @return
     */
    Payment getPaymentByID(int paymentID);

    /**
     * Updating payment
     * @param payment
     */
    void updatePayment(Payment payment);
}

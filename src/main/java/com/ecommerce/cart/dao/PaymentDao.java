package com.ecommerce.cart.dao;

import com.ecommerce.cart.domain.Payment;

public interface PaymentDao {

    /**
     * Saving New Payment
     * @param payment
     */
    public void savePayment(Payment payment);
}

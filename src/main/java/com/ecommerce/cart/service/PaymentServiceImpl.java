package com.ecommerce.cart.service;

import com.ecommerce.cart.dao.PaymentDao;
import com.ecommerce.cart.domain.Payment;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.product.doimain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    public void registerNewPendingPayment(Payment payment) {
        //TO DO
    }

    @Override
    public void registerNewPendingPayment(Product product, boolean isPaid, Timestamp paidDate, String message, Customer customer) {

        Payment payment = new Payment();
        payment.setProduct(product);
        payment.setPaid(isPaid);
        payment.setPaidDate(paidDate);
        payment.setMessage(message);
        payment.setCustomer(customer);
        paymentDao.savePayment(payment);
    }

}
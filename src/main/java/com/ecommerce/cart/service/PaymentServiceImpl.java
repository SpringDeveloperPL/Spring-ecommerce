package com.ecommerce.cart.service;

import com.ecommerce.cart.dao.PaymentDao;
import com.ecommerce.cart.domain.Payment;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.product.doimain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    public void registerNewPendingPayment(Payment payment) {
        //TO DO
    }

    @Override
    public void registerNewPendingPayment(Product product, boolean isPaid,boolean onCart, Timestamp paidDate, String message, Customer customer) {

        Payment payment = new Payment();
        payment.setProduct(product);
        payment.setPaid(isPaid);
        payment.setInCard(false);
        payment.setPaidDate(paidDate);
        payment.setMessage(message);
        payment.setCustomer(customer);
        paymentDao.savePayment(payment);

    }

    @Override
    public List<Payment> getCustomerPayments(Customer customer) {
        List<Payment> allPaymentList = getAllPayments();
        List<Payment> customerPayments = new ArrayList<>();

        for (Payment payment : allPaymentList) {
            if(payment.getCustomer().getCustomerId()==customer.getCustomerId()) {
                customerPayments.add(payment);
            }
        }
        return customerPayments;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentDao.getAllPayments();
    }

    @Override
    public List<Payment> getCustomerPendingPayments(Customer customer) {
        List<Payment> allPaymentList = getAllPayments();
        List<Payment> customerPendingPayments = new ArrayList<>();

        for (Payment payment : allPaymentList) {
            if(payment.getCustomer().getCustomerId()==customer.getCustomerId()&&payment.isPaid()==false) {
                customerPendingPayments.add(payment);
            }
        }
        return customerPendingPayments;
    }

    @Override
    public List<Payment> getcustomerSuccesfulPayments(Customer customer) {
        List<Payment> allPaymentList = getAllPayments();
        List<Payment> customerSuccesfulPayments = new ArrayList<>();

        for (Payment payment : allPaymentList) {
            if(payment.getCustomer().getCustomerId()==customer.getCustomerId()&&payment.isPaid()==true) {
                customerSuccesfulPayments.add(payment);
            }
        }
        return customerSuccesfulPayments;
    }

    @Override
    public Payment getPaymentByID(int paymentID) {

        return paymentDao.getPaymentByID(paymentID);
    }

    @Override
    public void updatePayment(Payment payment) {
        paymentDao.updatePayment(payment);
    }

}
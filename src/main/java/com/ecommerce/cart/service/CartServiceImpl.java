package com.ecommerce.cart.service;

import com.ecommerce.cart.dao.CartDao;
import com.ecommerce.cart.domain.Cart;
import com.ecommerce.cart.domain.CartDetail;
import com.ecommerce.cart.domain.Payment;
import com.ecommerce.customer.dao.CustomerDao;
import com.ecommerce.customer.domain.Customer;
import com.ecommerce.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    PaymentService paymentService;

    @Override
    public void createCustomerCard(Customer customer) {
        Cart cart = new Cart();
        cart.setCustomer(customer);
        customer.setCart(cart);
        customerDao.updateCustomer(customer);
        cartDao.saveCart(cart);
    }

    @Override
    public Cart getCustomerCart()
    {
      return customerService.getLoggedCustomer().getCart();
    }

    @Override
    public void addCartItem(int paymentID) {
        Customer customer = customerService.getLoggedCustomer();
        Payment payment = paymentService.getPaymentByID(paymentID);
        payment.setInCard(true);
        Cart cart = customer.getCart();
        cart.setEmpty(false);
        CartDetail cartDetail = new CartDetail();
        cartDetail.setCart(cart);
        cartDetail.setPayment(payment);
        paymentService.updatePayment(payment);
        updateCartDetails(cartDetail);
        updaceGrandTotal();
    }

    @Override
    public void removeCartItem(int cartItemID) {
        Payment payment = getCartDetailById(cartItemID).getPayment();
        payment.setInCard(false);
        cartDao.removeItem(cartItemID);
        paymentService.updatePayment(payment);
        updaceGrandTotal();
    }

    public int getCartItemIDByPaymentID(int paymentID) {
        List<CartDetail> cartDetails = getAllCartDetails();
        int cartID = 0;
        for (CartDetail cartDetail : cartDetails) {
            if(cartDetail.getPayment().getPaymentID()==paymentID){
                cartID = cartDetail.getCartDetailID();
            }
        }
        return cartID;
    }

    public void updateCartDetails(CartDetail cartDetail) {
        cartDao.updateCartDetails(cartDetail);
    }

    @Override
    public List<CartDetail> getCustomerCartItems() {

        List<CartDetail> customerCartDetails = new ArrayList<>();
        List<CartDetail> alLCartDetails = getAllCartDetails();

        Cart cart = getCustomerCart();
        for (CartDetail cartDetail : alLCartDetails) {
            if(cartDetail.getCart().getCartID()==cart.getCartID()){
                customerCartDetails.add(cartDetail);
            }
        }
        return customerCartDetails;
    }

    @Override
    public List<CartDetail> getAllCartDetails() {
        return cartDao.getAllCartDetails();
    }

    @Override
    public void updaceGrandTotal() {
        List<CartDetail> cartDetailList = getCustomerCartItems();
        Cart cart = getCustomerCart();
        BigDecimal grandTotal = new BigDecimal(0);
        for (CartDetail cartDetail : cartDetailList) {
            grandTotal = grandTotal.add(cartDetail.getPayment().getProduct().getBidAmout());
        }
        cart.setTotalPrice(grandTotal);
        updateCart(cart);
    }

    @Override
    public CartDetail getCartDetailById(int cartDetailID) {
        List<CartDetail> allCartDetails = getAllCartDetails();
        CartDetail result = new CartDetail();
        for (CartDetail cartDetail : allCartDetails) {
                if(cartDetail.getCartDetailID()==cartDetailID){
                    result = cartDetail;
                }
        }
        return result;
    }

    private void updateCart(Cart cart) {
        cartDao.updateCart(cart);
    }
}
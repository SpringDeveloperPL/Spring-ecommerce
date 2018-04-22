package com.ecommerce.cart.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;


@Proxy(lazy = false)
@Table(name = "CART_DETAIL")
@Entity
public class CartDetail {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Id
    private Integer cartDetailID;

    @ManyToOne(targetEntity=Payment.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="paymentID", referencedColumnName="paymentID", nullable=false) })
    private Payment payment;

    @ManyToOne(targetEntity=Cart.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="cartID", referencedColumnName="cartID", nullable=false) })
    private Cart cart;

    public Integer getCartDetailID() {
        return cartDetailID;
    }

    public void setCartDetailID(Integer cartDetailID) {
        this.cartDetailID = cartDetailID;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}

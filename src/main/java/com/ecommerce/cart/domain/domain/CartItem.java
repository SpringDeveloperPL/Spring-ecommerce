package com.ecommerce.cart.domain.domain;

import com.ecommerce.product.doimain.Product;

import java.math.BigDecimal;

public class CartItem {

    private Product product;
    private int quentity;
    private BigDecimal totalPrice;


    public CartItem(Product product) {
        this.product = product;
        this.quentity = 1;
        this.totalPrice = product.getBidAmout();
    }

    public Product getProduct() {

        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.updateTotalPrice();

    }

    public int getQuentity() {
        return quentity;
    }

    public void setQuentity(int quentity) {
        this.quentity = quentity;
        this.updateTotalPrice();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;

        if (quentity != cartItem.quentity) return false;
        if (product != null ? !product.equals(cartItem.product) : cartItem.product != null) return false;
        return totalPrice != null ? totalPrice.equals(cartItem.totalPrice) : cartItem.totalPrice == null;
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + quentity;
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        return result;
    }

    public void updateTotalPrice() {
        totalPrice = this.product.getBidAmout().multiply(new BigDecimal(this.quentity));
    }
}

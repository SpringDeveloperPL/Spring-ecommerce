package com.ecommerce.cart.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Integer cartID;
    private Map<Integer,CartItem> cartItems;
    private BigDecimal grandTotal;

    public Cart() {
        cartItems =new HashMap<Integer,CartItem>();
        grandTotal=new BigDecimal(0);

    }

    public Cart(Integer cartID) {
        this();
        this.cartID=cartID;
    }


    public Integer getCartID() {

        return cartID;
    }

    public void setCartID(Integer cartID) {
        this.cartID = cartID;
    }

    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Integer, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (cartID != null ? !cartID.equals(cart.cartID) : cart.cartID != null) return false;
        if (cartItems != null ? !cartItems.equals(cart.cartItems) : cart.cartItems != null) return false;
        return grandTotal != null ? grandTotal.equals(cart.grandTotal) : cart.grandTotal == null;
    }

    @Override
    public int hashCode() {
        int result = cartID != null ? cartID.hashCode() : 0;
        result = 31 * result + (cartItems != null ? cartItems.hashCode() : 0);
        result = 31 * result + (grandTotal != null ? grandTotal.hashCode() : 0);
        return result;
    }

    public void addCartItem(CartItem item) {
        Integer productID = item.getPayment().getProduct().getProductId();

        if(cartItems.containsKey(productID)) {
            CartItem existingCartItem = cartItems.get(productID);
            existingCartItem.setQuentity(existingCartItem.getQuentity()+item.getQuentity());
            cartItems.put(productID,existingCartItem);
        }else {
            cartItems.put(productID,item);
        }

        updateGrandTotal();
    }

    public void removeCartItem(CartItem item) {
        Integer productID = item.getPayment().getProduct().getProductId();
        cartItems.remove(productID);
        updateGrandTotal();
    }

    public void updateGrandTotal() {
        grandTotal = new BigDecimal(0);
        for (CartItem cartItem : cartItems.values()) {
            grandTotal = grandTotal.add(cartItem.getTotalPrice());
        }
    }

}

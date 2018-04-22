package com.ecommerce.cart.dao;

import com.ecommerce.cart.domain.Cart;
import com.ecommerce.cart.domain.CartDetail;

import java.util.List;

public interface CartDao {

    /**
     * Save Customer Cart
     * @param cat
     */
    public void saveCart(Cart cat);

    /**
     * Update Cart Details
     * @param cartDetail
     */
    void updateCartDetails(CartDetail cartDetail);

    /**
     * Getting All Cart Details
     * @return
     */
    List<CartDetail> getAllCartDetails();

    /**
     * Updating Cart
     * @param cart
     */
    void updateCart(Cart cart);

    /**
     * Removin cart item by ID
     * @param cartItemID
     */
    void removeItem(int cartItemID);
}

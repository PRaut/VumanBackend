package com.Dao;

import java.util.List;

import com.model.Cart;

public interface CartDao {
	void insert(Cart cart);
	
	void updateCart(Cart cart);
	
	void deleteCart(int cartId);
	
	Cart getCartById(int cartId, String userEmail);
	
	List<Cart> findCartById(int user_id);
	Cart getCartByProductId(int productId);
}

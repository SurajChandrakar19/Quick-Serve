package com.serve.dao;

import java.util.List;

import com.serve.models.CartItem;
import com.serve.models.MenuModel;

public interface CartDAO {
	boolean addFoodOnCart(int userId, int restaurantId, MenuModel menu, int quantity, boolean isCustomized, String customizationDetails, boolean isSpicy);
	boolean removeFoddOnCart(int cartItemId);
	List<CartItem> fetchMyCart(int userId);
	CartItem fetchMyCart(int userId, int restaurantId, int menuId);
	boolean updateCart(int quantity, int cart_item_id);
	boolean updateCart(CartItem cartItem);
}

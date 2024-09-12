package com.serve.dao;

import com.serve.models.MenuModel;

public interface CartDAO {
	boolean addFoodOnCart(int userId, int restaurantId, MenuModel menu, int quantity, boolean isCustomized, String customizationDetails, boolean isSpicy);
	boolean removeFoddOnCart(int menuId);
}

package com.serve.dao;

import java.util.List;

import com.serve.models.MenuModel;

public interface MenuDAO {
	List<MenuModel> fetchAllMenu(int restaurantId);
}

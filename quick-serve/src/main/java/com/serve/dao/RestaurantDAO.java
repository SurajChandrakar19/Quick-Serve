package com.serve.dao;

import java.util.List;

import com.serve.models.RestaurantModel;

public interface RestaurantDAO {
	List<RestaurantModel> fetchAllRastaurants();
}

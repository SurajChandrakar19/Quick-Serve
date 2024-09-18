package com.serve.dao;

import java.util.List;

import com.serve.models.CartItem;

public interface OrderHistoryDAO {
	List<CartItem> fetchData(int userId);
	
}

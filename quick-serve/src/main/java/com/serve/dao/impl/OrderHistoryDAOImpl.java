package com.serve.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.serve.connection.MyConnection;
import com.serve.dao.OrderHistoryDAO;
import com.serve.models.CartItem;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {

	private Connection con;
	private PreparedStatement pstm;
	private ResultSet result;
	private CartItem item;
	
	public OrderHistoryDAOImpl() {
		con = MyConnection.getConnection();
	}
	
	@Override
	public List<CartItem> fetchData(int userId) {
		List<CartItem> itemsList = new ArrayList<>();
		String query = "SELECT * FROM cart_item WHERE user_id = ? AND pay_method IS NULL;";
		pstm = MyConnection.getPrepareStatement(query, con);
		try {
			pstm.setInt(1, userId);
			result = pstm.executeQuery();
			while(result.next()) {
				 item = getCartItems();
				itemsList.add(item);
			}
			
			return itemsList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyConnection.closeConnection(con, pstm);
		}
		
		return null;
	}
	
	private CartItem getCartItems() throws SQLException {
		CartItem items = new CartItem();
		items.setCartItemId(result.getInt("cart_item_id"));
		items.setUserId(result.getInt("user_id"));
		items.setRestaurantId(result.getInt("restaurant_id"));
		items.setMenuItemId(result.getInt("menu_item_id"));
		items.setItemName(result.getString("item_name"));
		items.setPrice(result.getBigDecimal("price"));
		items.setQuantity(result.getInt("quantity"));
		items.setTotalPrice(result.getBigDecimal("total_price"));
		items.setCustomized(result.getBoolean("is_customized"));
		items.setCustomizationDetails(result.getString("customization_details"));
		items.setSpicy(result.getBoolean("is_spicy"));
		items.setVeg(result.getBoolean("is_veg"));
		items.setOrderDate(result.getTimestamp("order_date"));
		items.setAvailable(result.getBoolean("is_available"));
		items.setStatus(result.getString("status"));
		return items;
	}

}

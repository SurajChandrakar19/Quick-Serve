package com.serve.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.serve.connection.MyConnection;
import com.serve.dao.CartDAO;
import com.serve.models.MenuModel;

public class CartDAOImpl implements CartDAO {
	
	private Connection con;
	private PreparedStatement pstm;
	private int status;

	public CartDAOImpl() {
		con = MyConnection.getConnection();
	}

	@Override
	public boolean addFoodOnCart(int userId, int restaurantId, MenuModel menu, int quantity, boolean isCustomized, String customizationDetails, boolean isSpicy) {
//		MenuModel menu = null;
		String query = "INSERT INTO cart_item (user_id, restaurant_id, menu_item_id, item_name, price, quantity, total_price, is_customized, customization_details, is_spicy, is_veg, order_date, is_available, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?, ?);";
		pstm = MyConnection.getPrepareStatement(query, con);
		try {
			pstm.setInt(1, userId);                           // Set user_id
	        pstm.setInt(2, restaurantId);                     // Set restaurant_id
	        pstm.setInt(3, menu.getItemId());                 // Set menu_item_id
	        pstm.setString(4, menu.getItemName());            // Set item_name
	        pstm.setDouble(5, menu.getPrice());               // Set price
	        pstm.setInt(6, quantity);                         // Set quantity
	        pstm.setDouble(7, menu.getPrice() * quantity);    // Set total_price (price * quantity)
	        pstm.setBoolean(8, isCustomized);                 // Set is_customized
	        pstm.setString(9, customizationDetails);          // Set customization_details
	        pstm.setBoolean(10, isSpicy);                     // Set is_spicy
	        pstm.setBoolean(11, menu.isSpicy());                       // Set is_veg
	        pstm.setBoolean(12, menu.isAvailable());                 // Set is_available
	        pstm.setString(13, "preparing");
	        status = pstm.executeUpdate();
	        if(status == 1) {
	        	System.out.println("add to cart succesfully");
	        	return true;
	        }else {
	        	System.out.println("add to cart not");
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeFoddOnCart(int menuId) {
		// TODO Auto-generated method stub
		return false;
	}

}

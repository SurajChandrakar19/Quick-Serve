package com.serve.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.serve.connection.MyConnection;
import com.serve.dao.CartDAO;
import com.serve.models.CartItem;
import com.serve.models.MenuModel;

public class CartDAOImpl implements CartDAO {
	
	private Connection con;
	private PreparedStatement pstm;
	private int status;
	private ResultSet result;
	private CartItem item;

	public CartDAOImpl() {
		con = MyConnection.getConnection();
	}

	@Override
	public boolean addFoodOnCart(int userId, int restaurantId, MenuModel menu, int quantity, boolean isCustomized, String customizationDetails, boolean isSpicy) {
//		MenuModel menu = null;
		String query = "INSERT INTO cart_item (user_id, restaurant_id, menu_item_id, item_name, price, quantity, total_price, is_customized, customization_details, is_spicy, is_veg, order_date, is_available, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?, ?);";
		try {
			item = fetchMyCart(userId, restaurantId, menu.getItemId());
			if(item != null) {
				inItemQ(1,item.getCartItemId());
				return true;
			}
			pstm = MyConnection.getPrepareStatement(query, con);
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
	        pstm.setString(13, "in_cart");
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

	@Override
	public List<CartItem> fetchMyCart(int userId) {
		List<CartItem> itemsList = new ArrayList<>();
		String query = "SELECT * FROM cart_item WHERE user_id = ?";
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
		}
		
		return null;
	}

	@Override
	public CartItem fetchMyCart(int userId, int restaurantId, int menuId) {
		String query = "SELECT * FROM cart_item WHERE user_id = ? AND restaurant_id = ? AND menu_item_id = ?";
		pstm = MyConnection.getPrepareStatement(query, con);
		try {
			pstm.setInt(1, userId);
			pstm.setInt(2, restaurantId);
			pstm.setInt(3, menuId);
			result = pstm.executeQuery();
			if(result.next()) {
				item = getCartItems();
				return item;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	@Override
	public boolean updateCart(int quantity, int cart_item_id) {
		String query = "UPDATE cart_item c JOIN menu_item m ON  c.menu_item_id = m.item_id SET c.total_price = m.price * ?, c.quantity = ? WHERE c.cart_item_id = ?;";

		pstm = MyConnection.getPrepareStatement(query, con);
		try {
			pstm.setInt(1, quantity);
			pstm.setInt(2, quantity);
			pstm.setInt(3, cart_item_id);
			status = pstm.executeUpdate();
			if(status == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
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

	private boolean inItemQ(int quantity, int cartItemId) {
		String query = "UPDATE cart_item SET quantity = quantity+1, price = price * quantity+1 WHERE cart_item_id = ?;";
		pstm = MyConnection.getPrepareStatement(query, con);
		try {
			pstm.setInt(1, cartItemId);
			status = pstm.executeUpdate();
			if(status == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}

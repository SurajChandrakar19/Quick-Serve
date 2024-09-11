package com.serve.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.serve.connection.MyConnection;
import com.serve.dao.MenuDAO;
import com.serve.models.MenuModel;

public class MenuDAOImpl implements MenuDAO {

	private Connection con;
	private PreparedStatement pstm;
	private ResultSet result;

	@Override
	public List<MenuModel> fetchAllMenu(int restaurantId) {
		List<MenuModel> listMenu = new ArrayList<MenuModel>();
		String query = "SELECT * FROM menu_item WHERE restaurant_id = ?";
		con = MyConnection.getConnection();
		pstm = MyConnection.getPrepareStatement(query, con);
		try {
			MenuModel menu = new MenuModel();
			pstm.setInt(1, restaurantId);
			result = pstm.executeQuery();
			while(result.next()) {
				menu.setItemId(result.getInt("item_id"));
				menu.setRestaurantId(result.getInt("restaurant_id"));
				menu.setItemName(result.getString("item_name"));
				menu.setDescription(result.getString("description"));
				menu.setCuisineType(result.getString("cuisine_type"));
				menu.setPrice(result.getDouble("price"));
				menu.setIngredients(result.getString("ingredients"));
				menu.setVeg(result.getBoolean("is_veg"));
				menu.setSpicy(result.getBoolean("is_spicy"));
				menu.setPreparationTime(result.getString("preparation_time"));
				menu.setCalories(result.getInt("calories"));
				menu.setRating(result.getDouble("rating"));
				menu.setReviewCount(result.getInt("review_count"));
				menu.setAvailable(result.getBoolean("is_available"));
				menu.setAvailabilityTimes(result.getString("availability_times"));
				menu.setDiscount(result.getDouble("discount"));
				menu.setFeatured(result.getBoolean("is_featured"));
				menu.setMenuImageUrl(result.getString("menu_image_url"));
				listMenu.add(menu);
			}
			return listMenu;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return null;
	}

}

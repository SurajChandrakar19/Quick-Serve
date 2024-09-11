package com.serve.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.serve.connection.MyConnection;
import com.serve.dao.RestaurantDAO;
import com.serve.models.RestaurantModel;

public class RestaurantsDAOImpl implements RestaurantDAO {

	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	@Override
	public List<RestaurantModel> fetchAllRastaurants() {
		List<RestaurantModel> restaurants = new ArrayList<RestaurantModel>();
		String query = "SELECT * FROM restaurant";
		
		try {
			con = MyConnection.getConnection();
			pstm = con.prepareStatement(query);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
                RestaurantModel restaurant = new RestaurantModel();
                restaurant.setId(rs.getInt("id"));
                restaurant.setName(rs.getString("name"));
                restaurant.setDescription(rs.getString("description"));
                restaurant.setCuisineType(rs.getString("cuisine_type"));
                restaurant.setAddress(rs.getString("address"));
                restaurant.setCity(rs.getString("city"));
                restaurant.setState(rs.getString("state"));
                restaurant.setPostalCode(rs.getString("postal_code"));
                restaurant.setPhoneNumber(rs.getString("phone_number"));
                restaurant.setEmail(rs.getString("email"));
                restaurant.setWebsite(rs.getString("website"));
                restaurant.setOpeningHours(rs.getString("opening_hours"));
                restaurant.setDeliveryTime(rs.getString("delivery_time"));
                restaurant.setDeliveryAreas(rs.getString("delivery_areas"));
                restaurant.setReviewCount(rs.getInt("review_count"));
                restaurant.setLogoUrl(rs.getString("logo_url"));
                restaurant.setMenuImageUrl(rs.getString("menu_image_url"));
                restaurant.setRestaurantPhotoUrl(rs.getString("restaurant_photo_url"));
                restaurant.setIsOpen(rs.getBoolean("is_open"));
                restaurant.setIsBusy(rs.getBoolean("is_busy"));
                restaurant.setOwnerName(rs.getString("owner_name"));
                restaurant.setOwnerContact(rs.getString("owner_contact"));
                restaurant.setRegistrationDate(rs.getTimestamp("registration_date"));

                restaurants.add(restaurant);
            }
        return restaurants;
		}catch(SQLException e) {
			e.getStackTrace();
		} finally {
			MyConnection.closeConnection(con, pstm);
		}
		return null;
	}

	

}

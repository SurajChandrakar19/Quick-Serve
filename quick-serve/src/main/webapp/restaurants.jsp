<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.serve.models.RestaurantModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Restaurant List</title>
    <link rel="stylesheet" href="./css/common-style.css">
    <link rel="stylesheet" href="./css/restaurants.css">
</head>
<body>
    <div class="header">
        <h1>Restaurant List</h1>
    </div>
    <div class="restaurant-list-container">
        <% 
            List<RestaurantModel> restaurants = (List<RestaurantModel>) session.getAttribute("allRestaurants");
            if (restaurants != null && !restaurants.isEmpty()) {
                for (RestaurantModel restaurant : restaurants) {
        %>
        <a href="restaurants-menus.jsp" style="text-decoration:none;">
	        <div class="restaurant-card">
	            <div class="restaurant-header">
	                <img src="<%= restaurant.getLogoUrl() %>" alt="<%= restaurant.getName() %> logo" class="restaurant-logo">
	                <h2><%= restaurant.getName() %></h2>
	            </div>
	            <div class="restaurant-details">
	                <p><strong>Cuisine:</strong> <%= restaurant.getCuisineType() %></p>
	                <p><strong>Address:</strong> <%= restaurant.getAddress() %></p>
	                <p><strong>Opening Hours:</strong> <%= restaurant.getOpeningHours() %></p>
	                <p><strong>Delivery Time:</strong> <%= restaurant.getDeliveryTime() %></p>
	                <p><strong>Delivery Areas:</strong> <%= restaurant.getDeliveryAreas() %></p>
	                <p><strong>Review Count:</strong> <%= restaurant.getReviewCount() %></p>
	            </div>
	            <div class="restaurant-images">
	                <img src="<%= restaurant.getRestaurantPhotoUrl() %>" alt="<%= restaurant.getName() %> photo" class="restaurant-photo">
	            </div>
	        </div>
        </a>
        <% 
                }
            } else {
        %>
        <p>No restaurants available.</p>
        <% 
            }
        %>
    </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.serve.models.MenuModel" %>
<%@page import="com.serve.dao.impl.MenuDAOImpl" %>
<%@page import="java.util.List" %>
<%@page import="com.serve.dao.impl.RestaurantsDAOImpl" %>
<%@page import="com.serve.models.RestaurantModel" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Restaurant Details</title>
<link rel="stylesheet" href="./css/common-style.css">
<link rel="stylesheet" href="./css/restaurants-menus.css">

<style type="text/css">
	.menu-item img.menu-image {
	    width: 200px; /* Set a fixed width */
	    height: 150px; /* Set a fixed height */
	    object-fit: cover; /* Ensures the image covers the area without distortion */
	    border-radius: 10px; /* Rounds the corners of the image */
	    margin-bottom: 10px; /* Space between the image and the text */
	    overflow: hidden; /* Hides overflow if the image is larger */
	}
</style>
</head>
<body>

<%
    RestaurantModel resModel = new RestaurantsDAOImpl().fetchRastaurant(Integer.parseInt(request.getParameter("id")));
%>

<div class="header">
    <h1><%= resModel.getName() %></h1>
</div>
<div class="restaurant-info">
    <h1>Restaurant Details</h1>
    <p>Location: <%= resModel.getAddress() %>, City: <%= resModel.getCity() %></p>
    <p>Rating: <%= resModel.getReviewCount() %></p>
</div>

<div class="menu-items">
    <%
        List<MenuModel> menus = new MenuDAOImpl().fetchAllMenu(Integer.parseInt(request.getParameter("id")));
        if (menus != null && !menus.isEmpty()) {
            for (MenuModel menu : menus) {
    %>
    
    <div class="menu-item">
        <img src="<%= menu.getMenuImageUrl() %>" alt="<%= menu.getItemName() %>" class="menu-image">
        <h2><%= menu.getItemName() %></h2>
        <p><%= menu.getPrice() %>$</p>
        <a href="addToCart?iId=<%=menu.getItemId() %>&rId=<%=request.getParameter("id") %>" class="btn">Add to Cart</a>
    </div>
    <%  
            }
        } else {
    %>
        <p>No items found</p>
    <% } %>
</div>
</body>
</html>

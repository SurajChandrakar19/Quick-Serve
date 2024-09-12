<%@page import="org.apache.jasper.tagplugins.jstl.core.Param"%>
<%@page import="com.serve.dao.impl.RestaurantsDAOImpl"%>
<%@page import="com.serve.models.RestaurantModel"%>
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
    <link rel = "stylesheet" href = "./css/common-style.css">
    <link rel = "stylesheet" href = "./css/restaurants-menus.css">
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
	            <h2><%= menu.getItemName()%></h2>
	            <p><%= menu.getPrice() %>$</p>
	            <a href="addToCart?iId=<%=menu.getItemId() %>&rId=<%=request.getParameter("id") %>" class="btn">Add to Cart</a>
		    </div>
	    <% 	}
	      } else {
	    %>
		<p>not any item found</p>
		<%} %>
    </div>
</body>
</html>
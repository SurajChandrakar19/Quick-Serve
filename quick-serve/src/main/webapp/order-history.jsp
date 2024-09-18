<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.serve.dao.impl.CartDAOImpl"%>
<%@page import="com.serve.models.CartItem" %>
<%@page import = "java.util.List"%>
<%@page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order History</title>
    <link rel = "stylesheet" href = "./css/common-style.css">
    <link rel = "stylesheet" href = "./css/order-history.css">
</head>
<body>
    <div class="header">
        <h1>Order History</h1>
    </div>
    <div class="order-history-container">
        <h1>Your Past Orders</h1>
        <% 
	        CartDAOImpl cart = new CartDAOImpl();
	    	List<CartItem> carts = cart.fetchMyCart(1,"HISTORY");
	    	int totalItem = 0;
	    	for(CartItem menu : carts ){
		%>
        <div class="order-item">
        	 <form action="orderDetails.jsp" method="get">
                <input type="hidden" name="cartItemId" value="<%= menu.getCartItemId() %>">
                <p><strong>Order ID:</strong> <%= menu.getCartItemId() %></p>
                <p><strong>Date:</strong> <%= menu.getOrderDate() %></p>
                <p><strong>Total:</strong> <%= menu.getTotalPrice() %></p>
                <input type="submit" value="View Details" class="btn">
            </form>
        </div>
        <%} %>
    </div>
</body>
</html>
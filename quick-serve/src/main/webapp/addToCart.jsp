<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.serve.dao.impl.CartDAOImpl"%>
<%@page import="com.serve.models.CartItem" %>
<%@page import="com.serve.models.UserModel" %>
<%@page import = "java.util.List"%>
<%@page import="java.util.Iterator" %>
<%@page import="java.math.BigDecimal" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add to Cart</title>
    <link rel="stylesheet" type="text/css" href="./css/addToCart.css">
</head>
<body>

    <!-- Enhanced Header Section -->
     <!-- Enhanced Header Section -->
    <header>
        <div class="header-container">
            <div class="logo">
                <a href="home.jsp">My<span>Food</span>Delivery</a>
            </div>
            <nav class="nav-links">
                <a href="home.jsp">Home</a>
                <a href="menu.jsp">Menu</a>
                <a href="cart.jsp">Cart</a>
                <a href="profile.jsp">Profile</a>
                <a href="logout.jsp" class="logout-btn">Logout</a>
            </nav>
        </div>
    </header>
        <!-- Cart Section -->
	<div class="cart-container" style="margin: 0 auto; width: 80dvw;">
	    <h2>Your Cart</h2>
		<% 
		CartDAOImpl cart = new CartDAOImpl();
		UserModel user = (UserModel)session.getAttribute("user");
		List<CartItem> carts = cart.fetchMyCart(user.getId(),null);
		BigDecimal total = BigDecimal.ZERO;
		int totalItem = 0;
		for(CartItem menu : carts ){
			totalItem++;
			total = total.add(menu.getTotalPrice());
		%>
	    <!-- Single Cart Item -->
	    <div class="cart-item" style="">
	        <img src="<%= menu.getMenuImageUrl() %>" alt="Item Image" class="cart-item-image">
	        <div class="cart-item-details">
	            <h3 class="cart-item-name"> <%= menu.getItemName() %></h3>
	            
	            <!-- Cart Item Row: Price, Quantity, Total Price, and Update Button -->
	            <div class="cart-item-row">
	                <p class="cart-item-price">Price: <%=menu.getPrice() %>₹ </p>
	
	                <form action="updateCart" method="post" class="cart-item-form">
	                    <label for="quantity">Qty:</label>
	                    <input type="number" id="quantity" name="quantity" value=<%=menu.getQuantity() %> min="0" class="quantity-input">
	                    
	                    <p class="cart-item-total-price">Total: <%= menu.getTotalPrice() %>₹</p>
	                    <input type="hidden" name="cart_item_id" value=<%= menu.getCartItemId() %>>
	
	                	<button type="submit" class="btn-update-cart">Update</button>
	                </form>
	            </div>
	        </div>
	    </div>
		<%} %>
		 <!-- Overall Cart Summary -->
		<div class="cart-summary">
		    <h3>Cart Summary</h3>
		    <p>Total Items: <span id="total-items"> <%= totalItem %></span></p>
		    <p>Grand Total: ₹<span id="grand-total"> <%= total%></span></p>
			<% session.setAttribute("cartItems", carts); %>
		    <form action="placeOrder" method="post">
		        <button type="submit" class="btn-place-order">Place Order</button>
		    </form>
		</div>
	</div>

</body>
</html>
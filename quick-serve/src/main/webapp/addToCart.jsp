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
<div class="cart-container">
    <h2>Your Cart</h2>
	<% 
	CartDAOImpl cart = new CartDAOImpl();
	List<CartItem> carts = cart.fetchMyCart(1);
	for(CartItem menu : carts ){
	%>
	
    <!-- Single Cart Item -->
    <div class="cart-item">
        <img src=" menu.getMenuImageUrl() %>" alt="Item Image" class="cart-item-image">
        <div class="cart-item-details">
            <h3 class="cart-item-name"> <%= menu.getItemName() %></h3>
            
            <!-- Cart Item Row: Price, Quantity, Total Price, and Update Button -->
            <div class="cart-item-row">
                <p class="cart-item-price">Price: <%=menu.getPrice() %>₹ </p>

                <form action="updateCart" method="post" class="cart-item-form">
                    <label for="quantity">Qty:</label>
                    <input type="number" id="quantity" name="quantity" value=<%=menu.getQuantity() %> min="1" class="quantity-input">
                    
                    <p class="cart-item-total-price">Total: <%= menu.getPrice() %>₹</p>
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
    <p>Total Items: <span id="total-items">1</span></p>
    <p>Grand Total: ₹<span id="grand-total">  menu.getPrice() %></span></p>

    <form action="placeOrder" method="post">
        <button type="submit" class="btn-place-order">Place Order</button>
    </form>
</div>




</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Food Delivery - Home</title>
   	<link rel="stylesheet" href="./css/common-style.css">
   	<link rel="stylesheet" href="./css/index.css">
</head>
<body>
    <header>
        <h1>Welcome to TastyTrax Food Delivery</h1>
    </header>
    
    <nav>
        <a href="index.jsp">Home</a>
        <a href="restaurants">Restaurants</a>
        <a href="restaurants-menus.jsp">Menu Items</a>
        <a href="order-history.jsp">Order History</a>
        <a href="update-profile.jsp">Profile</a>
        <a href="pay.jsp">Payment</a>
        <a href="help.jsp">Help</a>
        <a href="register.jsp">Logout</a>
        <a href="login.jsp">Login</a>
    </nav>

    <section class="hero">
        <h1>Delicious Food Delivered to Your Doorstep</h1>
        <p>Browse through the best restaurants and menus, and order your favorite food.</p>
        <a href="restaurants.jsp" class="cta-btn">Explore Restaurants</a>
    </section>

    <section class="content">
        <div class="content-item">
            <h2>Top Restaurants</h2>
            <p>Explore the top-rated restaurants near you.</p>
            <a href="restaurants.jsp">View Restaurants</a>
        </div>
        <div class="content-item">
            <h2>Menu Items</h2>
            <p>Discover delicious meals and order now.</p>
            <a href="menus.jsp">Browse Menus</a>
        </div>
        <div class="content-item">
            <h2>Order History</h2>
            <p>Check your past orders and reorder easily.</p>
            <a href="orderHistory.jsp">View Orders</a>
        </div>
        <div class="content-item">
            <h2>Your Profile</h2>
            <p>Update your details and manage your account.</p>
            <a href="updateUser.jsp">Update Profile</a>
        </div>
    </section>

    <footer>
        <p>&copy; 2024 TastyTrax Food Delivery. All rights reserved.</p>
    </footer>
</body>
</html>
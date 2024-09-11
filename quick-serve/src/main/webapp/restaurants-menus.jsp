<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Restaurant Details</title>
    <link rel = "stylesheet" href = "./css/common-style.css">
    <link rel = "stylesheet" href = "./css/restaurants-menus.css">
</head>
<body>
    <div class="header">
        <h1>Restaurant Name</h1>
    </div>
    <div class="restaurant-info">
        <h1>Restaurant Details</h1>
        <p>Location: XYZ, City</p>
        <p>Rating: ★★★★☆</p>
    </div>
    <div class="menu-items">
        <div class="menu-item">
            <h2>Dish 1</h2>
            <p>$12.99</p>
            <a href="addToCart.jsp" class="btn">Add to Cart</a>
        </div>
        <div class="menu-item">
            <h2>Dish 2</h2>
            <p>$9.99</p>
            <a href="addToCart.jsp" class="btn">Add to Cart</a>
        </div>
        <div class="menu-item">
            <h2>Dish 3</h2>
            <p>$15.99</p>
            <a href="addToCart.jsp" class="btn">Add to Cart</a>
        </div>
    </div>
</body>
</html>
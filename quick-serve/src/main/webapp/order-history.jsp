<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <div class="order-item">
            <p><strong>Order ID:</strong> #12345</p>
            <p><strong>Date:</strong> Aug 15, 2023</p>
            <p><strong>Total:</strong> $50.99</p>
            <a href="orderDetails.jsp" class="btn">View Details</a>
        </div>
        <div class="order-item">
            <p><strong>Order ID:</strong> #12346</p>
            <p><strong>Date:</strong> Aug 20, 2023</p>
            <p><strong>Total:</strong> $32.99</p>
            <a href="orderDetails.jsp" class="btn">View Details</a>
        </div>
    </div>
</body>
</html>
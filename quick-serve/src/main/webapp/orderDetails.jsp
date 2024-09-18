<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.serve.dao.impl.CartDAOImpl" %>
<%@ page import="com.serve.models.CartItem" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Order Details</title>
    <link rel="stylesheet" href="./css/common-style.css">
    <style>
        .order-details-container {
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .order-item-detail {
            display: flex;
            flex-direction: column;
            gap: 15px;
            border: 1px solid #ddd;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #fff;
            width: 100%;
            max-width: 600px;
        }
        .order-item-detail p {
            margin: 0;
            display: flex;
            justify-content: space-between;
        }
        .order-item-detail strong {
            flex: 1;
        }
        .order-item-detail span {
            flex: 2;
            text-align: right;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Order Details</h1>
    </div>
    <div class="order-details-container">
        <% 
            String orderIdStr = request.getParameter("cartItemId");
            if (orderIdStr != null) {
                int cartItemId = Integer.parseInt(orderIdStr);
                
                CartDAOImpl cartDAO = new CartDAOImpl();
                CartItem cartItem = cartDAO.fetchCartItemById(cartItemId);
                
                if (cartItem != null) {
        %>
        <div class="order-item-detail">
            <p><strong>Order ID:</strong><span><%= cartItem.getCartItemId() %></span></p>
            <p><strong>Date:</strong><span><%= cartItem.getOrderDate() %></span></p>
            <p><strong>Total:</strong><span><%= cartItem.getTotalPrice() %></span></p>
            <p><strong>Payment Method:</strong><span><%= cartItem.getPayMethod() %></span></p>
            <p><strong>Item Name:</strong><span><%= cartItem.getItemName() %></span></p>
            <p><strong>Price:</strong><span><%= cartItem.getPrice() %></span></p>
            <p><strong>Quantity:</strong><span><%= cartItem.getQuantity() %></span></p>
            <p><strong>Customizations:</strong><span><%= cartItem.getCustomizationDetails() %></span></p>
            <p><strong>Is Spicy:</strong><span><%= cartItem.isSpicy() ? "Yes" : "No" %></span></p>
            <p><strong>Is Vegetarian:</strong><span><%= cartItem.isVeg() ? "Yes" : "No" %></span></p>
            <p><strong>Status:</strong><span><%= cartItem.getStatus() %></span></p>
        </div>
        <% 
                } else {
        %>
        <p>Order not found.</p>
        <% 
                }
            } else {
        %>
        <p>No order ID provided.</p>
        <% 
            }
        %>
    </div>
</body>
</html>

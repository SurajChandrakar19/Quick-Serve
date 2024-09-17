<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Payment Method</title>
    <link rel = "stylesheet" href = "./css/common-style.css">
    <link rel = "stylesheet" href = "./css/pay.css">
</head>
<body>
    <div class="header">
        <h1>Select Payment Method</h1>
    </div>
    <div class="payment-container">
        <h1>Choose a Payment Option</h1>
        <form action="paySuccess" method="post">
            <div class="payment-option">
                <input type="radio" id="credit-card" name="payment" value="card" checked>
                <label for="credit-card">Credit Card</label>
            </div>
            <div class="payment-option">
                <input type="radio" id="paypal" name="payment" value="upi">
                <label for="paypal">PayPal</label>
            </div>
            <div class="payment-option">
                <input type="radio" id="cash" name="payment" value="cash">
                <label for="cash">Cash on Delivery</label>
            </div>
            <button type="submit" class="btn">Proceed to Payment</button>
        </form>
    </div>
</body>
</html>
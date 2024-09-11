<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Register - Food Delivery</title>
	<link rel = "stylesheet" href = "./css/common-style.css">
	<link rel = "stylesheet" href = "./css/register.css">
	</head>
	<body>
	    <div class="register-container">
	        <h1>Register</h1>
	        <form action="cRegister" method="post">
	            <div class="input-group">
	                <label for="name">Full Name</label>
	                <input type="text" id="name" name="name" required>
	            </div>
	            <div class="input-group">
	                <label for="phonenumber">Mo. Number</label>
	                <input type="number" id="phonenumber" name="phonenumber" required maxlength="10">
	            </div>
	            <div class="input-group">
	                <label for="email">Email</label>
	                <input type="email" id="email" name="email" required>
	            </div>
	            <div class="input-group">
	                <label for="password">Password</label>
	                <input type="password" id="password" name="password" required>
	            </div>
	            <button type="submit" class="btn">Register</button>
	        </form>
	    </div>
	</body>
</html>
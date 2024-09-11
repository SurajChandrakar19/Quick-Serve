<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login - Food Delivery</title>
    <link rel = "stylesheet" href = "./css/common-style.css">
    <link rel = "stylesheet" href = "./css/login.css">
    
</head>
<body>
    <div class="login-container">
        <h1>Login</h1>
        <form action="cLogin" method="post">
            <div class="input-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit" class="btn">Login</button>
            <a href="register.jsp">Register</a>
        </form>
    </div>
</body>
</html>
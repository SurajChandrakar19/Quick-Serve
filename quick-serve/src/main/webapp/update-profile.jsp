<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.serve.models.UserModel" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Update User Details</title>
	    <link rel = "stylesheet" href = "./css/common-style.css">
	    <link rel = "stylesheet" href = "./css/update-profile.css">
	</head>
<body>
	<% 
		UserModel user = (UserModel)session.getAttribute("loginUser");
		if(user == null){
			response.sendRedirect("login.jsp");
		}else{
	%>
    <div class="header">
        <h1>Update User Details</h1>
    </div>
    <div class="update-container">
        <h1>Edit Your Information</h1>
        <form action="profile" method="post">
            <div class="input-group">
                <label for="name">Full Name</label>
                <input type="text" id="name" name="name" placeholder="<%=user.getfName()%>" required>
            </div>
            <div class="input-group">
                <label for="email">Email Address</label>
                <input type="email" id="email" name="email" placeholder="<%=user.getEmail() %>" required>
            </div>
            <div class="input-group">
                <label for="phone">Phone Number</label>
                <input type="text" id="phone" name="phone" placeholder="<%=user.getPhonenumber() %>" required>
            </div>
            <div class="input-group">
                <label for="cPassword">Confirm Password</label>
                <input type="text" id="password" name="password" required>
            </div>
            <button type="submit" class="btn">Update Details</button>
        </form>
    </div>
    <%} %>
</body>
</html>
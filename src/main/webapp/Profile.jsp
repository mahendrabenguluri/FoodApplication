<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.food.model.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Swiggy Profile</title>
    <link rel="stylesheet"  href="RestaurantMenuItems.css">
	<style type="text/css">
	
	.profile-container h1{
	margin-top: 0;
    font-size: 30px;
    font-weight: bold;
    color: #8a2608; /* Swiggy orange */
    text-align: center; /* Center the heading */
	}

	
	.detail-item input[type="password"]{
	width: calc(100% - 160px);
    padding: 12px;
    font-weight: 700;
    border: 1px solid rgba(0, 0, 0, 0.5); /* Semi-transparent border */
    background-color: transparent; /* Transparent background */
    color: #050000; /* Text color */
    border-radius: 5px;
    box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.5);
    } 
.btn-save-changes{
    display: block;
    width:130px;
    margin: 20px auto;
    padding: 12px 0px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}
	</style>

</head>
<body>
    <div class="profile-container" id="signup-container">
    <%
                User loggedInUser=(User) session.getAttribute("loggedInUser");
                if(loggedInUser !=null){
                
                %>
        <h1>Profile</h1>
        <form action="signup" method="post">
            <div class="detail-item">
                <label for="name">Name:</label>
                <input type="text" id="name" value="<%=loggedInUser.getUsername() %>" name="username">
            </div>
            <div class="detail-item">
                <label for="phone">Phone Number:</label>
                <input type="text" id="phone" value="+91 9876543210">
            </div>
            <div class="detail-item">
                <label for="name">Password:</label>
                <input type="password" id="password" value="<%=loggedInUser.getPassword() %>" name="password">
                
            </div>
            <div class="detail-item">
                <label for="address">Address:</label>
                <input type="text" id="address" value="<%=loggedInUser.getAddress() %>" name="address">
            </div>
            <div class="detail-item">
                <label for="email">Email:</label>
                <input type="text" id="email" value="<%=loggedInUser.getEmail() %>" name="email">
            </div>
			<div class="detail-item">
			    <label for="role">Role:</label>
			    
			    <select id="role" name="role" style="color:black;">
			        <option value="customer" <%= "customer".equals(loggedInUser.getRole()) ? "selected" : "" %>>Customer</option>
			        <option value="restaurantAdmin" <%= "restaurantAdmin".equals(loggedInUser.getRole()) ? "selected" : "" %>>RestaurantAdmin</option>
			    </select>
			</div>

        <button class="btn-save-changes">Save Changes</button>
        </form><%if(loggedInUser.getRole().equalsIgnoreCase("customer")) {%>
    <a href="Home" style="text-decoration: none;color: rgb(219, 219, 219);"><button class="btn-return-home">Return to Home</button></a>
    <%} else{%>
    <a href="restaurantAdmin" style="text-decoration: none;color: rgb(219, 219, 219); "><button class="btn-return-home" style="width:150px;">Return to Restaurant</button></a>
    
        <%} %>
        <%} else{ %>
        <form action="signup"  method="post">

        <h1>Sign Up</h1>
        
            <div class="detail-item">
                <label for="name">Name:</label>
                <input type="text" id="name" placeholder="Enter your name" name="username">
            </div>
            <div class="detail-item">
                <label for="phone">Phone Number:</label>
                <input type="text" id="phone" placeholder="Enter your phone number" name="Phone Number">
            </div>
            <div class="detail-item">
                <label for="email">Email:</label>
                <input type="text" id="email" placeholder="Enter your email" name="email">
            </div>
            <div class="detail-item">
                <label for="name">Password:</label>
                <input type="password" id="password" placeholder="Enter your password" name="password">
            </div>
            <div class="detail-item">
                <label for="address">Address:</label>
                <input type="text" id="address" placeholder="Enter your address" name="address">
            </div>
            
            <div class="detail-item">
                <label for="role">Role:</label>
                <select id="role" name="role">
                    <option value="customer">Customer</option>
                    <option value="restaurantAdmin">RestaurantAdmin</option>
                </select>
            </div>
  
       		<button type="submit" class="btn-save-changes">Sign Up</button>
        	
    </form>
	<a href="Login.jsp" style="text-decoration: none;color: rgb(219, 219, 219);"><button class="btn-return-home">LogIn</button></a>
    </div>
    
        <%} %>
        
    
</body>
</html>
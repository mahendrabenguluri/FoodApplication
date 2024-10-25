<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet" href="RestaurantMenuItems.css">
<style type="text/css">
	
	.profile-container h1{
	margin-top: 0;
    font-size: 30px;
    font-weight: bold;
    color: #8a2608; /* Swiggy orange */
    text-align: center; /* Center the heading */
	}
body, html {
  height: 100%;
  margin: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  
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
.btn-return-home{
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

<div class="profile-container" id="login-container">
  <!-- <span class="close-button" onclick="closeForm()">&times;</span> -->
  
  
  <form action="login" method="post">
  <h1>Login</h1>
    <div class="detail-item">
      <label for="username">Email:</label>
      <input type="text" id="email" name="email" placeholder="Enter your email">
    </div>
    <div class="detail-item">
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" placeholder="Enter your password">
    </div>
    <button type="submit" class="btn-return-home">LogIn</button>
  </form>
    <a href="Profile.jsp" style="text-decoration: none;color: rgb(219, 219, 219);"><button  class="btn-save-changes" >Sign Up</button></a>
</div>

</body>
</html>
    
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.food.model.Restaurant,com.food.DAOimpl.RestaurantDAOImp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resturant Details</title>
    <link rel="stylesheet" href="RestaurantMenuItems.css">
    
</head>
<body>
    <div class="profile-container" id="add-restaurant-container">
    <%
    String restaurantId = request.getParameter("restaurantId");
    RestaurantDAOImp rdi=new RestaurantDAOImp();%>
    <%! Restaurant restaurant;%>
    <%
    try{
    restaurant=rdi.getRestaurant(Integer.parseInt(restaurantId));
    }
    catch(Exception e){
    	restaurantId=null;
    }
    if(restaurantId!=null && restaurant!=null){ %>

		<h2>Modifying Restaurant Details</h2>
        <form action="RestaurantSave" method="post">
        <input type="hidden" id="restaurantId" name="restaurantId" value="<%= restaurant.getRestaurant_Id() %>">

            <div class="detail-item">
            
                <label for="name">Restaurant Name:</label>
                <input type="text" id="restaurantName" name="restaurantName" value="<%= restaurant.getName() %>" required>
            </div>
            <div class="detail-item">
                <label for="cuisineType">Cuisine Type:</label>
                <input type="text" id="cuisineType" name="cuisineType" value="<%= restaurant.getCuisineType() %>">
            </div>
            <div class="detail-item">
                <label for="deliveryTime">Delivery Time (minutes):</label>
                <input type="number" id="deliveryTime" name="deliveryTime" value="<%= restaurant.getDeliveryTime() %>" required>
            </div>
            <div class="detail-item">
                <label for="address">Address:</label>
                <input type="text" id="restaurantAddress" name="restaurantAddress" value="<%= restaurant.getAddress() %>" required>
            </div>
            <div class="detail-item">
                <label for="rating">Rating (e.g., 4.5):</label>
                <input type="number" step="0.1" id="rating" name="rating" min="0" max="5" value="<%= restaurant.getRating() %>">
            </div>
            <div class="detail-item">
                <label for="isActive">Is Active:</label>
                <select id="isActive" name="isActive" style="color:black;" >
                    <option value="true">Yes</option>
                    <option value="false">No</option>
                </select>
            </div>
            <div class="detail-item">
                <label for="imagePath">Image Path (URL):</label>
                <input type="text" id="imagePath" name="imagePath" value="<%= restaurant.getImagePath() %>">
            </div>
            <div class="button-container">
                <button type="submit" class="btn-save-changes">Save Restaurant</button>
                <a href="restaurantAdmin" style="text-decoration: none;color: rgb(219, 219, 219);">
                    <button type="button" class="btn-return-home">Return Restaurant</button>
                </a>
            </div>
        </form>
<%} else{ %>
        <h2>Add New Restaurant</h2>
        <form action="RestaurantSave" method="post">
        
            <div class="detail-item">
                <label for="name">Restaurant Name:</label>
                <input type="text" id="restaurantName" name="restaurantName" placeholder="Enter restaurant name" required>
            </div>
            <div class="detail-item">
                <label for="cuisineType">Cuisine Type:</label>
                <input type="text" id="cuisineType" name="cuisineType" placeholder="Enter cuisine type">
            </div>
            <div class="detail-item">
                <label for="deliveryTime">Delivery Time (minutes):</label>
                <input type="number" id="deliveryTime" name="deliveryTime" placeholder="Enter delivery time" required>
            </div>
            <div class="detail-item">
                <label for="address">Address:</label>
                <input type="text" id="restaurantAddress" name="restaurantAddress" placeholder="Enter the Address" required>
            </div>
            <div class="detail-item">
                <label for="rating">Rating (e.g., 4.5):</label>
                <input type="number" step="0.1" id="rating" name="rating" min="0" max="5" placeholder="Enter rating">
            </div>
            <div class="detail-item">
                <label for="isActive">Is Active:</label>
                <select id="isActive" name="isActive">
                    <option value="true">Yes</option>
                    <option value="false">No</option>
                </select>
            </div>
            <div class="detail-item">
                <label for="imagePath">Image Path (URL):</label>
                <input type="text" id="imagePath" name="imagePath" placeholder="Enter image URL">
            </div>
            <div class="button-container">
                <button type="submit" class="btn-save-changes">Save Restaurant</button>
                <a href="restaurantAdmin" style="text-decoration: none;color: rgb(219, 219, 219);">
                    <button type="button" class="btn-return-home">Return Restaurant</button>
                </a>
            </div>
        </form>
        <%} %>
    </div>
</body>
</html>

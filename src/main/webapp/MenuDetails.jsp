<%@page import="java.util.List"%>
<%@page import="com.food.DAOimpl.MenuDAOImp"%>
<%@page import="com.food.model.Menu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurants Menu Items</title>
    <!-- <link rel="stylesheet" href="styles.css"> -->
     <style> 

/* Restaurant Container Styles */   
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

/* Restaurant Container Styles */
.restaurant-container {
    max-width: 600px; /* Increase container width for layout */
    margin: 20px auto;
    padding: 20px;
    border-radius: 10px;
    border: 1px solid #ddd;
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
}
.restaurant-container h1 {
    display: flex;
    align-items: center;
    justify-content: center;
}

.restaurant-item {
    display: flex;
    align-items: center;
    margin-bottom: 20px;
    border-bottom: 1px solid #ddd;
    padding-bottom: 15px;
}

.restaurant-image {
    margin-top: 8px;
    max-width: 200px;
    max-height: 210px;
    border-radius: 10px;
    overflow: hidden;
    margin-right: 20px; /* Space between image and details */
    
}

.restaurant-image img {
    width: 200px;
    height: 200px;
    border-radius: 10px;
    object-fit: cover;
}

.restaurant-details {
    flex: 1; /* Allow details to take up remaining space */
    display: flex;
    flex-direction: column;
}

.restaurant-details h3 {
    font-size: 20px;
    font-weight: bold;
    margin: 0px;
    margin-bottom: 10px;
    color: #8a2608; /* Swiggy orange color for restaurant names */
}

.restaurant-details p {
    font-size: 16px;
    margin-top: 0%;
    margin-bottom: 5px;
    font-weight: 500;
}

/* Restaurant Buttons */
.restaurant-buttons{
display:flex;
gap:20px;
}
.restaurant-details a{

	text-decoration: none;
	display: block;
	align-items: center;
    justify-items: center;
    width: 20px;
}
.restaurant-details a.modify-btn {
    padding: 6px 10px;
    width: 120px;
    background-color: green;
    color: white;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    text-align: center;
    align-items: center;
    
    font-weight: 500;
}
.restaurant-details a.modify-btn:hover {
    background-color: darkgreen;
}

.remove-btn{
padding: 10px 10px;
border: none;
border-radius: 8px;
font-weight: 600;
 background-color: #d9534f;
            color: white;
}
 .remove-btn:hover {
            background-color: #c9302c;
        }

/* Center the "Add New Restaurant" button */
.restaurant-buttons1 {
    display: flex;
    justify-content: center;
    gap: 20px; /* Space between buttons */
    margin-top: 20px;
}

.add-btn1 {
    padding: 10px 20px;
    background-color: #007bff; /* Blue color */
    color: white;
    border-radius: 5px;
    text-decoration: none;
    font-weight: 550;
    transition: background-color 0.3s ease;
}

.modify-btn1 {
    padding: 10px 20px;
    background-color: #28a745; /* Green color */
    color: white;
    border-radius: 5px;
    text-decoration: none;
    font-weight: 550;
    transition: background-color 0.3s ease;
}


.add-btn1:hover {
    background-color: #0056b3; /* Darker blue for hover */
}

.modify-btn1:hover {
    background-color: #218838; /* Darker green for hover */
}



    </style>
</head>
<body>
    <div class="restaurant-container">
        <h1>Menu Items</h1>
        <%
    List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
    if(menuList!=null && !menuList.isEmpty()){ 
   for( Menu menu : menuList){%>
    
        <div class="restaurant-item">
            <div class="restaurant-image">
                <img src="<%= menu.getImagePath() %>" alt="Image of <%= menu.getItemname() %>">
            </div>
            <div class="restaurant-details">
                <h3><%= menu.getItemname() %></h3>
                <p><strong>Description :</strong> <%= menu.getDescription() %></p>
                <p><strong>Price :</strong> <%=menu.getPrice() %> </p>
                <!-- <p><strong>Add</strong> 1234 Elm Street, City, Country</p> -->
                <p><strong>Rating:</strong> <%=menu.getRating() %></p>
                <p><strong>Status:</strong> <%=menu.getisAvailable()? "Active" : "Inactive" %></p>
            <div class="restaurant-buttons">
                <a href="MenuItemDetails.jsp?menuId=<%= menu.getMenu_id() %>&restaurantId=<%= menu.getRestaurant_id() %>" class="modify-btn">Modify Details</a>
                    <!-- <button class="modify-btn">Modify Menu Details</button> -->
                    <!-- <button class="add-menu-btn">Add Menu Items</button> -->
                    <form action="RestaurantMenuDelete" method="post">
                        <input type="hidden" name="menuId" value="<%= menu.getMenu_id() %>">
                        <input type="hidden" name="from" value="menu">
                        <button type="submit" class="remove-btn">Remove</button>
                    </form>
</div>
            </div>
        </div>
<%}}else{ %>
<p>no menu items</p>
<%} %>
        
        <div class="restaurant-buttons1">
		        <a href="MenuItemDetails.jsp?restaurantId=<%= session.getAttribute("restaurantId") %>" class="add-btn1"  style="text-decoration: none;">Add More Items</a>
		        <a href="restaurantAdmin" class="modify-btn1" style="text-decoration: none;">Return Restaurant</a>
        
        </div>
    </div>
    
</body>
</html>

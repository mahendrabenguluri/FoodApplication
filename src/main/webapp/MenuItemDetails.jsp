<%@page import="com.food.DAOimpl.MenuDAOImp"%>
<%@page import="com.food.model.Menu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Details</title>
    <link rel="stylesheet" href="RestaurantMenuItems.css">
    
</head>
<body>
    <div class="profile-container" id="add-restaurant-container">
     <%
    String menuId = request.getParameter("menuId");
  /*   String restaurantId = request.getParameter("restaurantId");
    session.setAttribute("restaurantId",restaurantId); */

    MenuDAOImp rdi=new MenuDAOImp();%>
    <%! Menu menu;%>
    <%
    try{
    menu=rdi.getMenu(Integer.parseInt(menuId));
    }
    catch(Exception e){
    	menuId=null;
    }
    if(menuId!=null && menu!=null){ %>
            <h2>Modify Menu Item</h2>
        <form action="menuItemSave" method="post">
                <input type="hidden" id="menuId" name="menuId" value="<%= menu.getMenu_id() %>">
                
            <div class="detail-item">
                <label for="name">Item Name:</label>
                <input type="text" id="menuName" name="menuName" value="<%=menu.getItemname() %>" required>
            </div>
            
            
            <div class="detail-item">
                <label for="description">Description:</label>
                <input type="text" id="description" name="description" value="<%=menu.getDescription() %>" required>
            </div>
            <div class="detail-item">
                <label for="rating">Rating (e.g., 4.5):</label>
                <input type="number" step="0.1" id="rating" name="rating" min="0" max="5" value="<%=menu.getRating() %>">
            </div>
            <div class="detail-item">
                <label for="name">Price :</label>
                <input type="text" id="price" name="price" value="<%=menu.getPrice() %>" required>
            </div>
            <div class="detail-item">
                <label for="isActive">Is Active:</label>
                
                <select id="isActive" name="isActive" style="color:black;">
                    <option value="true">Yes</option>
                    <option value="false">No</option>
                </select>
            </div>
            <div class="detail-item">
                <label for="imagePath">Image Path (URL):</label>
                <input type="text" id="imagePath" name="imagePath" Value="<%=menu.getImagePath() %>" required>
            </div>
            <div class="button-container">
                <button type="submit" class="btn-save-changes">Save Items</button>
                
                <a href="MenuItems?restaurantId=<%= menu.getRestaurant_id() %>" style="text-decoration: none;color: rgb(219, 219, 219);">
                	
                    <button type="button" class="btn-return-home">Menu List</button>
                </a>
                
            </div>
            
        </form>
        
    <%}else{ %>
        <h2>Add New Menu Items</h2>
        <form action="menuItemSave" method="post">
        	
            <div class="detail-item">
                <label for="name">Item Name:</label>
                <input type="text" id="menuName" name="menuName" placeholder="Enter item name" required>
            </div>
            
            
            <div class="detail-item">
                <label for="description">Description:</label>
                <input type="text" id="description" name="description" placeholder="Enter the Description" required>
            </div>
            <div class="detail-item">
                <label for="rating">Rating (e.g., 4.5):</label>
                <input type="number" step="0.1" id="rating" name="rating" min="0" max="5" placeholder="Enter rating">
            </div>
            <div class="detail-item">
                <label for="isActive">Is Active:</label>
                <select id="isActive" name="isActive" required>
                    <option value="true">Yes</option>
                    <option value="false">No</option>
                </select>
            </div>
            <div class="detail-item">
                <label for="name">Price :</label>
                <input type="text" id="price" name="price" placeholder="Enter the price" required>
            </div>
            <div class="detail-item">
                <label for="imagePath">Image Path (URL):</label>
                <input type="text" id="imagePath" name="imagePath" placeholder="Enter image URL" required>
            </div>
            <div class="button-container">
                <button type="submit" class="btn-save-changes">Add Items</button>
                <%-- p><%= menu.getRestaurant_id() %></p> --%>
                <a href="MenuItems?restaurantId=<%= session.getAttribute("restaurantId") %>" style="text-decoration: none;color: rgb(219, 219, 219);">
                	
                    <button type="button" class="btn-return-home">Menu List</button>
                </a>
            </div>
        </form>
        <%} %>
    </div>
</body>
</html>

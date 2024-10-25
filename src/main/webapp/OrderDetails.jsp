<%@page import="java.util.Base64"%>
<%@page import="java.sql.Blob"%>
<%@page import="com.food.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.food.Launch.CartFetcher" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 70%;
            max-width: 650px;

            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #007BFF;
        }

        .return-home {
            display: flex;
            justify-content: flex-center;
            margin-bottom: 20px;
        }

        .return-home button {
            background-color: #007BFF;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        .return-home button:hover {
            background-color: #0056b3;
        }

        .orders {
            display: flex;
            flex-direction: column;
        }

        .order {
        	display: flex;
		    flex-direction: column;
		    margin: 10px auto; /* Add some margin for spacing */
		    border-radius: 10px; /* Slightly smaller radius for a refined look */
		    border: 1px solid #ddd;
		    padding: 10px; /* Add padding inside the cart items container */
		    max-width: 1300px; /* Set a max width for responsiveness */
		    background-color: #fff; /* Make the background white for better contrast */
		    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Add subtle shadow for better appearance */
            
        }

        .order h2 {
            text-align: center;
            color: #333;
        }

	.cart-item {
	    display: flex;
	    align-items: center; /* Align items vertically */
	
	    gap: 10px;
	    padding: 15px;
	    border-bottom: 2px solid #eee;
	    padding: 10px 0;
	    margin-bottom: 10px; /* Space between cart items */
	    
	    overflow: hidden; /* Ensures content doesn't overflow */
	    
	}


        .item-image img {
            width: 150px; /* Ensure image fits the container */
            height: 150px;
            border-radius: 4px;
        }

        .item-details {
            display: flex;
            flex-direction: column;
        }

        .item-details p {
            margin: 5px 0;
        }

        .total-amount {
            font-size: 1.2em;
            font-weight: bold;
            color: #333;
            margin-top: 10px;
            text-align: center;
        }


    </style>
</head>
<body>
    <div class="container">
        <div class="return-home">
            <button onclick="location.href='Home'">Return Home</button>
        </div>
        <h1>Order Details</h1>
        <div class="orders">
            <%
                User user=(User)session.getAttribute("loggedInUser"); 
            if(user!=null){
                int userId=user.getUserid();
                CartFetcher fetcher = new CartFetcher();
                List<Map<String, Object>> orders = fetcher.fetchOrdersByUserId(userId);
                
                for (Map<String, Object> order : orders) {
                    int orderId = (int) order.get("orderId");
                    double totalAmount = (double) order.get("totalAmount");
                    List<Map<String, Object>> cartItems = (List<Map<String, Object>>) order.get("cartItems");
            %>
            <div class="order">
                <h2>Order ID: <%= orderId %></h2>
                <div class="cart-items">
                    <%
                        for (Map<String, Object> item : cartItems) {
                        	Blob imageBlob = (Blob)item.get("imageName");
                            byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
                            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                            String imageUrl = "data:image/jpeg;base64," + base64Image;
                    %>
                    <div class="cart-item">
                        <div class="item-image">
                            <img src="<%= imageUrl %>" alt="<%= item.get("name") %>">
                        </div>
                        <div class="item-details">
                            <p><strong>Cart Item ID:</strong> <%= item.get("cartItemId") %></p>
                            <p><strong>Product ID:</strong> <%= item.get("productId") %></p>
                            <p><strong>Quantity:</strong> <%= item.get("quantity") %></p>
                            <p><strong>Added Date:</strong> <%= item.get("addedDate") %></p>
                            <p><strong>Name:</strong> <%= item.get("name") %></p>
                        </div>
                    </div>
                    
                    <%
                        }
                    %>
                </div>
                <p class="total-amount"><strong>Total Amount:</strong> <%= totalAmount %></p>
            </div>
            <%
                }}else{
                	response.sendRedirect("Login.jsp");
                }
                            %>
        </div>
    </div>
</body>
</html>

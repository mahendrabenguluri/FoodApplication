<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.food.model.Order"%>
 <%@page import=" java.util.List,  com.food.DAO.RestaurantDAO, com.food.model.Restaurant, com.food.model.User"%>
<html>
<head>
<title>Order Confirmation</title>
<link rel="stylesheet"  href="RestaurantMenuItems.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<style>
body, html {
  height: 100%;
  margin: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  
}
	.profile-container h1{
	margin-top: 0;
    font-size: 30px;
    font-weight: bold;
    color: #8a2608; /* Swiggy orange */
    text-align: center; /* Center the heading */
	}
.order-details{
	margin-bottom: 15px;
	font-weight: 600;
     color: light-black;
     
}

.ordre {
    display: flex;               /* Enable flexbox */
    flex-direction: column;      /* Stack items vertically */
    align-items: center;         /* Center items horizontally */
    justify-content: center;      /* Center items vertically */
    text-align: center;          /* Center text within each item */
    /* height: 100vh; */               /* Optional: Full height of the viewport */
    /* background-color: #2c2c2c; */  /* Optional: Background color for contrast */
    
}
.order-details strong {
    font-weight: 700;            /* Bold text */
    color: black;              /* Strong text color */
}
</style>
</head>
<body >
	<div class="profile-container" >
	<form action="orderConfirmation"  method="get">
                <%
        Order order = (Order) session.getAttribute("order");
        if (order != null) {
        %>   
       
            <!-- <div class="tick-icon" ><i class="fas fa-check" style="margin:12px;"></i></div> -->
            <h1>Thanks for your Order!</h1>
            <div class="ordre">
            <div class="order-details" ><strong >Order No : </strong> <%=order.getOrder_id() %></div>
       
            <div class="order-details" ><strong >Date : </strong> <%= order.getOrder_date() %></div>
            <div class="order-details" ><strong >Billing Address : </strong><%=order.getAddress() %></div>
            <div class="order-details" ><strong >Payment Method : </strong> <%=order.getPayment_method() %></div>
            <div class="order-details" ><strong >Total Amount : </strong><span><%=order.getTotal_amount()%></span></div>
             </div>
        
        <%
        } else {
        %>
        <p>Order details are not available at the moment.</p>
        <%
        }
        %>
 		
   </form>
   <a href="Home" style="text-decoration: none;color: rgb(219, 219, 219);"><button  class="btn-return-home" >Return to Home</button></a>
<!--           <a href="Home.jsp" class="btn-return-home">Return to Home</a> -->
	</div>
    
</body>
</html>

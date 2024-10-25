<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<div class="profile-container">
<h1 >Checkout</h1>
    <form class="checkout-form" action="orderConfirmation" method="post" >
    	<div class="detail-item">
        <label for="address">Delivery Address :</label>
        <input id="address" name="address" type="text" required class="checkout-input" placeholder="Enter your address"><br><br>
        </div>
        <div class="detail-item">
        <label for="paymentMethod">Payment Method :</label>
        <select id="paymentMethod" name="paymentMethod" class="checkout-input">
            <option value="Credit Card">Credit Card</option>
            <option value="Debit Card">Debit Card</option>
            <option value="UPI">UPI</option>
            <option Value="COD">COD</option>
        </select>
		</div>
        <button type="submit" class="btn-save-changes">Place Order</button>
    </form>
    <button class="btn-return-home" onclick="window.location.href='cart.jsp'">Return to Cart</button>

    </div>
</body>
</html>
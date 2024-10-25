<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.food.model.Cart, com.food.model.CartItem, com.food.model.User, java.util.Base64, java.io.*, java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
    <link rel="stylesheet" href="Style.scss">
    <link rel="stylesheet"  href="Home.scss">
</head>
<body class="homebody">
    <header class="navbar">
                
 
            <div class="search-bar">
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="#686b78">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-4.35-4.35M3.5 11a7.5 7.5 0 1115 0 7.5 7.5 0 01-15 0z" />
                </svg>
                <input type="text" placeholder="Search for restaurants or dishes">
            </div>
            <!-- <div class="nav-item">
                <svg class="_1GTCc" viewBox="0 0 32 32" height="19" width="19" fill="#686b78"><path d="M14.2 2.864l-1.899 1.38c-0.612 0.447-1.35 0.687-2.11 0.687h-2.352c-0.386 0-0.727 0.248-0.845 0.613l-0.728 2.238c-0.235 0.721-0.691 1.348-1.302 1.79l-1.905 1.385c-0.311 0.226-0.442 0.626-0.323 0.991l0.728 2.241c0.232 0.719 0.232 1.492-0.001 2.211l-0.727 2.237c-0.119 0.366 0.011 0.767 0.323 0.994l1.906 1.384c0.61 0.445 1.064 1.070 1.3 1.79l0.728 2.24c0.118 0.365 0.459 0.613 0.844 0.613h2.352c0.759 0 1.497 0.24 2.107 0.685l1.9 1.381c0.313 0.227 0.736 0.227 1.048 0.001l1.9-1.38c0.613-0.447 1.349-0.687 2.11-0.687h2.352c0.384 0 0.726-0.248 0.845-0.615l0.727-2.235c0.233-0.719 0.688-1.346 1.302-1.794l1.904-1.383c0.311-0.226 0.442-0.627 0.323-0.993l-0.728-2.239c-0.232-0.718-0.232-1.49 0.001-2.213l0.727-2.238c0.119-0.364-0.012-0.765-0.324-0.992l-1.901-1.383c-0.614-0.445-1.070-1.074-1.302-1.793l-0.727-2.236c-0.119-0.366-0.461-0.614-0.845-0.614h-2.352c-0.76 0-1.497-0.239-2.107-0.685l-1.903-1.382c-0.313-0.227-0.736-0.226-1.047-0.001zM16.829 0.683l1.907 1.385c0.151 0.11 0.331 0.168 0.521 0.168h2.352c1.551 0 2.927 1 3.408 2.475l0.728 2.241c0.057 0.177 0.169 0.332 0.321 0.442l1.902 1.383c1.258 0.912 1.784 2.531 1.304 4.006l-0.726 2.234c-0.058 0.182-0.058 0.375-0.001 0.552l0.727 2.237c0.48 1.477-0.046 3.096-1.303 4.007l-1.9 1.38c-0.153 0.112-0.266 0.268-0.324 0.447l-0.727 2.237c-0.48 1.477-1.856 2.477-3.408 2.477h-2.352c-0.19 0-0.37 0.058-0.523 0.17l-1.904 1.383c-1.256 0.911-2.956 0.911-4.213-0.001l-1.903-1.384c-0.15-0.11-0.332-0.168-0.521-0.168h-2.352c-1.554 0-2.931-1.001-3.408-2.477l-0.726-2.234c-0.059-0.18-0.173-0.338-0.324-0.448l-1.902-1.381c-1.258-0.912-1.784-2.53-1.304-4.008l0.727-2.235c0.058-0.179 0.058-0.373 0.001-0.551l-0.727-2.236c-0.481-1.476 0.046-3.095 1.302-4.006l1.905-1.385c0.151-0.11 0.264-0.265 0.323-0.444l0.727-2.235c0.478-1.476 1.855-2.477 3.408-2.477h2.352c0.189 0 0.371-0.059 0.523-0.17l1.902-1.383c1.256-0.911 2.956-0.911 4.212 0zM18.967 23.002c-1.907 0-3.453-1.546-3.453-3.453s1.546-3.453 3.453-3.453c1.907 0 3.453 1.546 3.453 3.453s-1.546 3.453-3.453 3.453zM18.967 20.307c0.419 0 0.758-0.339 0.758-0.758s-0.339-0.758-0.758-0.758c-0.419 0-0.758 0.339-0.758 0.758s0.339 0.758 0.758 0.758zM10.545 14.549c-1.907 0-3.453-1.546-3.453-3.453s1.546-3.453 3.453-3.453c1.907 0 3.453 1.546 3.453 3.453s-1.546 3.453-3.453 3.453zM10.545 11.855c0.419 0 0.758-0.339 0.758-0.758s-0.339-0.758-0.758-0.758c-0.419 0-0.758 0.339-0.758 0.758s0.339 0.758 0.758 0.758zM17.78 7.882l2.331 1.352-7.591 13.090-2.331-1.352 7.591-13.090z"></path></svg>
                <span>Offers</span>
            </div> -->
            <div class="nav-item">
                <svg class="_1GTCc" viewBox="6 -1 12 25" height="19" width="19" fill="#686b78"><path d="M21.966903,13.2244898 C22.0156989,12.8231523 22.0408163,12.4145094 22.0408163,12 C22.0408163,11.8357822 22.036874,11.6724851 22.029079,11.5101984 L17.8574333,11.5102041 C17.8707569,11.6717062 17.877551,11.8350597 17.877551,12 C17.877551,12.4199029 17.8335181,12.8295214 17.749818,13.2244898 L21.966903,13.2244898 Z M21.5255943,15.1836735 L16.9414724,15.1836735 C15.8950289,16.8045422 14.0728218,17.877551 12,17.877551 C9.92717823,17.877551 8.1049711,16.8045422 7.05852762,15.1836735 L2.47440565,15.1836735 C3.80564362,19.168549 7.56739481,22.0408163 12,22.0408163 C16.4326052,22.0408163 20.1943564,19.168549 21.5255943,15.1836735 Z M21.7400381,9.55102041 C20.6468384,5.18931674 16.7006382,1.95918367 12,1.95918367 C7.2993618,1.95918367 3.3531616,5.18931674 2.25996187,9.55102041 L6.6553883,9.55102041 C7.58404845,7.5276442 9.62792376,6.12244898 12,6.12244898 C14.3720762,6.12244898 16.4159515,7.5276442 17.3446117,9.55102041 L21.7400381,9.55102041 Z M2.03309705,13.2244898 L6.25018203,13.2244898 C6.16648186,12.8295214 6.12244898,12.4199029 6.12244898,12 C6.12244898,11.8350597 6.1292431,11.6717062 6.14256675,11.5102041 L1.97092075,11.5102041 C1.96312595,11.6724851 1.95918367,11.8357822 1.95918367,12 C1.95918367,12.4145094 1.98430112,12.8231523 2.03309705,13.2244898 Z M12,24 C5.372583,24 0,18.627417 0,12 C0,5.372583 5.372583,0 12,0 C18.627417,0 24,5.372583 24,12 C24,18.627417 18.627417,24 12,24 Z M12,15.9183673 C14.1640545,15.9183673 15.9183673,14.1640545 15.9183673,12 C15.9183673,9.83594547 14.1640545,8.08163265 12,8.08163265 C9.83594547,8.08163265 8.08163265,9.83594547 8.08163265,12 C8.08163265,14.1640545 9.83594547,15.9183673 12,15.9183673 Z"></path></svg>
                <!-- <span>Restaurant</span> -->
                <span onclick="window.location.href='menu';" style="cursor: pointer;">Menu</span>
            </div>
            <div class="nav-item">
                <svg class="_1GTCc" viewBox="6 0 12 24" height="19" width="18" fill="#686b78"><path d="M11.9923172,11.2463768 C8.81761115,11.2463768 6.24400341,8.72878961 6.24400341,5.62318841 C6.24400341,2.5175872 8.81761115,0 11.9923172,0 C15.1670232,0 17.740631,2.5175872 17.740631,5.62318841 C17.740631,8.72878961 15.1670232,11.2463768 11.9923172,11.2463768 Z M11.9923172,9.27536232 C14.0542397,9.27536232 15.7257581,7.64022836 15.7257581,5.62318841 C15.7257581,3.60614845 14.0542397,1.97101449 11.9923172,1.97101449 C9.93039471,1.97101449 8.25887628,3.60614845 8.25887628,5.62318841 C8.25887628,7.64022836 9.93039471,9.27536232 11.9923172,9.27536232 Z M24,24 L0,24 L1.21786143,19.7101449 L2.38352552,15.6939891 C2.85911209,14.0398226 4.59284263,12.7536232 6.3530098,12.7536232 L17.6316246,12.7536232 C19.3874139,12.7536232 21.1256928,14.0404157 21.6011089,15.6939891 L22.9903494,20.5259906 C23.0204168,20.63057 23.0450458,20.7352884 23.0641579,20.8398867 L24,24 Z M21.1127477,21.3339312 L21.0851024,21.2122487 C21.0772161,21.1630075 21.0658093,21.1120821 21.0507301,21.0596341 L19.6614896,16.2276325 C19.4305871,15.4245164 18.4851476,14.7246377 17.6316246,14.7246377 L6.3530098,14.7246377 C5.4959645,14.7246377 4.55444948,15.4231177 4.32314478,16.2276325 L2.75521062,21.6811594 L2.65068631,22.0289855 L21.3185825,22.0289855 L21.1127477,21.3339312 Z"></path></svg>
                <%
                User loggedInUser=(User) session.getAttribute("loggedInUser");
                if(loggedInUser !=null){
                
                %>
                <span id="signInIcon">wellcome,<%=loggedInUser.getUsername() %>!</span>
                 <div id="signInDropdown">
                    <p id="profile">Profile</p>
                    <p id="Order Details">Orders</p>
                    <!-- <p>Swiggy One</p>
                    <p>Favourites</p> -->
                    <!-- <p >Logout</p> -->
                    <p id="logout">Log out</p>
                    
                </div>
               <%
                }else{
               %>
                 <span id="login">Sign up</span>
                 
                 <%
                }
                 %>

            </div>
            
            <div class="nav-item">
                 <?xml version="1.0" encoding="utf-8"?><svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 122.9 107.5" style="enable-background:new 0 0 122.9 107.5" xml:space="preserve"><g><path d="M3.9,7.9C1.8,7.9,0,6.1,0,3.9C0,1.8,1.8,0,3.9,0h10.2c0.1,0,0.3,0,0.4,0c3.6,0.1,6.8,0.8,9.5,2.5c3,1.9,5.2,4.8,6.4,9.1 c0,0.1,0,0.2,0.1,0.3l1,4H119c2.2,0,3.9,1.8,3.9,3.9c0,0.4-0.1,0.8-0.2,1.2l-10.2,41.1c-0.4,1.8-2,3-3.8,3v0H44.7 c1.4,5.2,2.8,8,4.7,9.3c2.3,1.5,6.3,1.6,13,1.5h0.1v0h45.2c2.2,0,3.9,1.8,3.9,3.9c0,2.2-1.8,3.9-3.9,3.9H62.5v0 c-8.3,0.1-13.4-0.1-17.5-2.8c-4.2-2.8-6.4-7.6-8.6-16.3l0,0L23,13.9c0-0.1,0-0.1-0.1-0.2c-0.6-2.2-1.6-3.7-3-4.5 c-1.4-0.9-3.3-1.3-5.5-1.3c-0.1,0-0.2,0-0.3,0H3.9L3.9,7.9z M96,88.3c5.3,0,9.6,4.3,9.6,9.6c0,5.3-4.3,9.6-9.6,9.6 c-5.3,0-9.6-4.3-9.6-9.6C86.4,92.6,90.7,88.3,96,88.3L96,88.3z M53.9,88.3c5.3,0,9.6,4.3,9.6,9.6c0,5.3-4.3,9.6-9.6,9.6 c-5.3,0-9.6-4.3-9.6-9.6C44.3,92.6,48.6,88.3,53.9,88.3L53.9,88.3z M33.7,23.7l8.9,33.5h63.1l8.3-33.5H33.7L33.7,23.7z"/></g></svg>
                <!-- <span id="hi">Cart</span> -->
                <!-- <span onclick="window.location.href='cart.jsp';" style="cursor: pointer;">Cart</span>
                 --><span onclick="window.location.href='cart.jsp';" style="cursor: pointer;">
    Cart (<span id="cart-count"><%= session.getAttribute("cartCount") != null ? session.getAttribute("cartCount") : 0 %></span>)
</span>
                
            </div>


        </header>
    <div class="cart-items">
    <h1 >Your Shopping Cart</h1>
    <%
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null && !cart.getItems().isEmpty()) {
            for (CartItem item : cart.getItems()) {
                /* Blob imageBlob = item.getImagePath();
                byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());

                // Encode the image bytes to Base64
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                String imageUrl = "data:image/jpeg;base64," + base64Image; */
    %>
        <div class="cart-item">
            <div class="item-image">
                <img src="<%=item.getImagePath() %>" alt="Item Image">
            </div>
            <div class="item-details">
                <h3><%= item.getName() %></h3>
                <h4>&#x20B9; <%= item.getPrice() %></h4>
                <form action="CartServlet" method="post" class="cart-form">
				   <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
				   
				   <input type="hidden" name="action" class="action-input" value="">
				   <label>Quantity: 
				       <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1" class="quantity-input" onchange="setAction(this.form, 'update')">
				   </label>
				  <%--  <button><a href="menu?restaurantId="<%= item.getResturantId() %> style="text-decoration: none; color:black;">add items</a></button> --%>
				   <%-- <a href="menu?restaurantId=<%= item.getResturantId() %>" style="text-decoration: none;"><button type="button" class="update-btn" >add items</button></a>
				    --%>
				    <a href="#" onclick="submitForm('<%= item.getResturantId() %>')" style="text-decoration: none;">
    <button type="button" class="update-btn">Add Items</button>
</a>

<script>
function submitForm(restaurantId) {
    var form = document.createElement("form");
    form.setAttribute("method", "POST");
    form.setAttribute("action", "menu");

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "restaurantId");
    hiddenField.setAttribute("value", restaurantId);

    form.appendChild(hiddenField);
    document.body.appendChild(form);
    form.submit();
}
</script>
				    
				   <button type="button" class="remove-btn" onclick="setAction(this.form, 'remove')">Remove</button>
				</form>
            </div>
        </div>
    <%
            }
    %>
        <div class="cart-total">
        
            <h3>Total Amount : </h3><span>&#x20B9; <%= cart.getTotalAmount() %></span>
        </div>
    <%
        } else {
    %>
        <p>Your cart is empty.</p>
    <%
        }
    %>

    <a href="menu" class="add-more-items-btn"  style="text-decoration: none;">Add More Items</a>
    

    <%
        if (session.getAttribute("cart") != null && !cart.getItems().isEmpty()) {
        
    %>
    
<form action="checkout" method="post">
    <% session.setAttribute("totalAmount",cart.getTotalAmount()); %>

    
    <input type="submit" value="Proceed to Checkout" class="btn proceed-to-checkout-btn">
</form>

    <%
        }
        else {
            response.sendRedirect("menu");
        }
    %>
    
    </div>
    
    <script>
    function setAction(button, action) {
        var form = button.closest('.cart-form');
        form.querySelector('.action-input').value = action;
        form.submit();
    }
</script>
        <script>
        
        
       
        	
            /* function showLoginDropdown() {
                document.getElementById("signInDropdown").style.display = "block";
            } */
         // Sign up
            document.getElementById("signInIcon").addEventListener("click", function(event) {
            event.stopPropagation();
            const dropdown = document.getElementById("signInDropdown");
            // Toggle the display property
            if (dropdown.style.display === "block") {
                dropdown.style.display = "none";
            } else {
                dropdown.style.display = "block";
            }
        });
        document.addEventListener("click", function(event) {
            const dropdown = document.getElementById("signInDropdown");
            // Close dropdown if click is outside of dropdown or the sign-in icon
            if (!event.target.closest("#signInDropdown") && !event.target.closest("#signInIcon")) {
                dropdown.style.display = "none";
            }
        });
		
        
	
        document.getElementById("profile").addEventListener("click", function() {
            /* alert("Redirecting to Login.jsp"); */ // Use alert for testing
            window.location.href = "Profile.jsp"; // Ensure this path is correct
        });
        document.getElementById("Order Details").addEventListener("click", function() {
            /* alert("Redirecting to Login.jsp"); */ // Use alert for testing
            window.location.href = "OrderDetails.jsp"; // Ensure this path is correct
        });
        
        document.getElementById("logout").addEventListener("click", function() {
            window.location.href = "logout"; // Replace 'LogoutServlet' with your actual servlet URL mapping
        }); 
        
       
        
        
        
	


        </script>

</body>
</html>


















<%-- <% 
    /* String from = (String) session.getAttribute("from"); */
    String restaurantId = (String) session.getAttribute("restaurantId");
%> --%>

<%-- <a href="menu<%= from != null && from.equals("menuitems") ? "?restaurantId=" + restaurantId : "" %>" class="add-more-items-btn">Add More Items</a>
 --%>

    <!-- <a href="menu?restaurantId=" null" class="add-more-items-btn">Add More Items</a> -->



    
        <!-- Add More Items Button -->
        <%-- <a href="menu?restaurantId=<%=session.getAttribute("resturantId") %>" style="text-decoration: none;"><button  class="btn add-more-items-btn">Add More Items</button></a>
 --%>
<%--  <a href="menu<%= from != null && from.equals("menuitems") ? "?restaurantId=" + restaurantId : "" %>" class="add-more-items-btn">Add More Items</a> --%>
        <!-- Proceed to Checkout Button -->

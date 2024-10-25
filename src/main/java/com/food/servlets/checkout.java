package com.food.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.OrderDAO;
import com.food.DAOimpl.OrderDAoImp;

import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.Order;
import com.food.model.Restaurant;
import com.food.model.User;

@WebServlet("/checkout")
public class checkout extends HttpServlet {

	private OrderDAO orderDAO;

	@Override
	public void init() {
		orderDAO =new OrderDAoImp();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		User user = (User) session.getAttribute("loggedInUser");

		if (cart != null && user != null && !cart.getItems().isEmpty() || user!=null) {

			//session.removeAttribute("cart");
			//session.setAttribute("order", order);
			System.out.println("Checkout");
			response.sendRedirect("Checkout.jsp");
		} else {
			response.sendRedirect("cart.jsp"); // Redirect to cart if it's empty or user is not logged in
		}
	}
}




// Extract checkout form data
//String paymentMethod = request.getParameter("paymentMethod");
//String address = request.getParameter("address");
/* String paymentMethod = req.getParameter("paymentMethod"); */

// Process the data
//System.out.println("Address: " + address);
//System.out.println("Payment Method: " + paymentMethod);

// Create and populate the order object
//Order order = new Order();
//order.setUser_id(user.getUserid());
//System.out.println(Integer.parseInt((String)session.getAttribute("resturantId")));
//order.setRestaurant_id((int)session.getAttribute("resturantId"));

////Date date=(Date) session.getAttribute("date");
////order.setOrder_date(date);
//System.out.println(date+" check out");
//session.setAttribute("date",date );


 //order.setPayment_method(paymentMethod);
// order.setAddress(address);
 //order.setStatus("Delivered");
 

// Add cart items to the order and calculate the total amount
//double totalAmount = 0;
//for (CartItem item : cart.getItems().values()) {
//	// Assuming Order has a method to handle the logic of adding items
////    order.addOrderItem(item);  (this was throwing error)
//	totalAmount += item.getPrice();
//}
//order.setTotal_amount(totalAmount);





// Save the order to the database
//orderDAO.addOrder(order, session, user.getUserid(), session);

// Clear the cart and redirect to the order confirmation page
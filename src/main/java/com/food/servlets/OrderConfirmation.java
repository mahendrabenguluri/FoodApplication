package com.food.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAOimpl.CartItemDAOImp;
import com.food.DAOimpl.MenuDAOImp;
import com.food.DAOimpl.OrderDAoImp;
import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.Order;
import com.food.model.User;

@WebServlet("/orderConfirmation")
public class OrderConfirmation extends HttpServlet {
	
	OrderDAoImp odi;
	CartItemDAOImp cid;
	@Override
	public void init() throws ServletException {
		odi=new OrderDAoImp();
		cid=new CartItemDAOImp();
	}

    @SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
		/*
		 * String address = req.getParameter("address"); String paymentMethod =
		 * req.getParameter("paymentMethod");
		 * 
		 * // Process the data System.out.println("Address: " + address);
		 * System.out.println("Payment Method: " + paymentMethod);
		 */
    	String address = request.getParameter("address");
        String paymentMethod = request.getParameter("paymentMethod");

        // Process the data
        System.out.println("Address: " + address);
        System.out.println("Payment Method: " + paymentMethod);
        HttpSession session = request.getSession(true);
       
              
       
       
       Order order=new Order();
//       HttpSession	session=request.getSession(true);
       User user=(User) session.getAttribute("loggedInUser");
       order.setAddress(address);
       order.setPayment_method(paymentMethod);
       order.setStatus("pending");
       System.out.println(session.getAttribute("totalAmount"));
       order.setTotal_amount((Double) session.getAttribute("totalAmount"));
       order.setUser_id(user.getUserid());
       
       int orderId=odi.addOrder(order);
//       order.setOrder_id(orderId);
       if(orderId!=0) {
    	   Cart cart=(Cart) session.getAttribute("cart");
    	   try {
    		   List<CartItem> cartItem=cart.getItems();
    		   System.out.println("cartItems");
    		   CartItemDAOImp cid=new CartItemDAOImp();
    		   for(CartItem ci:cartItem) {
    			   System.out.println(ci);
    			   ci.setOrder_id(orderId);
    			   cid.addCartItem(ci);
    		   }
    		  
    	   }
    	   catch(Exception e) {
//    		   System.out.println("cart is error");
    		   e.printStackTrace();
    	   }
    	   
       }
       
       session.removeAttribute("totalAmout");
       
       
       

        
        if (order != null) {
        	order=odi.getOrder(orderId);
            session.setAttribute("order", order);
            System.out.println(order);
            session.removeAttribute("cartCount");
            session.removeAttribute("cart");
            RequestDispatcher dispatcher = request.getRequestDispatcher("OrderConfirmation.jsp");
            
            dispatcher.forward(request, response);
        } else {
            // Redirect to the home page or an error page if no order is found in the session
        	System.out.println("hello world");
        	
        	session.invalidate();

            response.sendRedirect("Home"); // or a custom error page
        }
    }
}


//Date date=(Date) session.getAttribute("date");
// System.out.println(date+" order confirmation");
// System.out.println(date);
 
 //int orderId=odi.getOrderId(date);
 //System.out.println(orderId+" "+address+" "+paymentMethod);
 //System.out.println();
 
 //odi.updateAddressPaymentMethod(orderId, address, paymentMethod);
//Order order= odi.getOrder(orderId);
 
// Date date1=(Date) session.getAttribute("date1");
// 
// System.out.println(date1+ " order cart");
 //cid.updateOrderId(orderId, date1);
 
//  Order order = (Order) session.getAttribute("order");
//  System.out.println(request.getAttribute("paymentMethod"));
//  order.setPayment_method(paymentMethod);
//  order.setAddress(address);

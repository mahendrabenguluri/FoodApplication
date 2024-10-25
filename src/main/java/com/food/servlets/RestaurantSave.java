package com.food.servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAOimpl.RestaurantDAOImp;
import com.food.model.Restaurant;
import com.food.model.User;

/**
 * Servlet implementation class RestaurantSave
 */
@WebServlet("/RestaurantSave")
public class RestaurantSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RestaurantDAOImp rdi;
	Restaurant restaurant;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantSave() {
        super();
        rdi=new RestaurantDAOImp();
        restaurant=new Restaurant();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String restaurantId=request.getParameter("restaurantId");
		System.out.println(restaurantId);
		String restaurantName=request.getParameter("restaurantName");
		String cuisineType=request.getParameter("cuisineType");
		String deliveryTime=request.getParameter("deliveryTime");
		String restaurantAddress=request.getParameter("restaurantAddress");
		String rating=request.getParameter("rating");
		String isActive=request.getParameter("isActive");
		
		Boolean bool = true;
		
		if(isActive.equalsIgnoreCase("false")) {
			bool=false;
		}
		String imagePath=request.getParameter("imagePath");
		
		HttpSession	session=request.getSession(true);
		
		User user=(User) session.getAttribute("loggedInUser");
		
		if(restaurantId==null && user!=null ) {
			System.out.println("user is available");
			restaurant.setImagePath(imagePath);
			restaurant.setName(restaurantName);
			restaurant.setCuisineType(cuisineType);
			restaurant.setDeliveryTime(Integer.parseInt(deliveryTime));
			restaurant.setRating(Double.parseDouble(rating));
			restaurant.setActive(bool);
			restaurant.setAddress(restaurantAddress);
			restaurant.setAdminId((int)user.getUserid());
			rdi.addRestaurant(restaurant);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("Restaurant");
//	        dispatcher.forward(request, response);
			response.sendRedirect("restaurantAdmin");

			
		
		}
		else {
			try {
				System.out.println(Integer.parseInt(restaurantId)+" me");
				restaurant.setRestaurant_Id((int)Integer.parseInt(restaurantId));
				restaurant.setImagePath(imagePath);
				restaurant.setName(restaurantName);
				restaurant.setCuisineType(cuisineType);
				restaurant.setDeliveryTime(Integer.parseInt(deliveryTime));
				restaurant.setRating(Double.parseDouble(rating));
				restaurant.setActive(bool);
				restaurant.setAddress(restaurantAddress);
				rdi.updateRestaurant(restaurant);
				request.setAttribute("restaurantId", (int)Integer.parseInt(restaurantId));
				RequestDispatcher dispatcher = request.getRequestDispatcher("RestaurantDetails.jsp");
		        dispatcher.forward(request, response);
//				response.sendRedirect("RestaurantSave");

			}
			catch(Exception e) {
				System.out.println("error in your data");
				e.printStackTrace();
			}
			
		}
		
	}

}

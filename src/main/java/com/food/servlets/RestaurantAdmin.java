package com.food.servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class RestaurantAdmin
 */
@WebServlet("/restaurantAdmin")
public class RestaurantAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantAdmin() {
        super();
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
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession	session=request.getSession(true);
		
        User user=(User) session.getAttribute("loggedInUser");
        if(user!=null) {
        	RestaurantDAOImp rdi=new RestaurantDAOImp();
            List<Restaurant> restaurant=rdi.getAllRestaurantAdmin(user.getUserid());
            request.setAttribute("restaurantsByAdmin", restaurant);
            System.out.println(user);
            System.out.println(restaurant);
           
            RequestDispatcher dispatcher = request.getRequestDispatcher("RestaurantAdmin.jsp");
            dispatcher.forward(request, response);
        }
        else {
        	 response.sendRedirect("Login.jsp");
        }
	}

}

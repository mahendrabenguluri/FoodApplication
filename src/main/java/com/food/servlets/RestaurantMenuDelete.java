package com.food.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAOimpl.MenuDAOImp;
import com.food.DAOimpl.RestaurantDAOImp;
import com.food.model.Menu;

/**
 * Servlet implementation class RestaurantMenuDelete
 */
@WebServlet("/RestaurantMenuDelete")
public class RestaurantMenuDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantMenuDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String from=request.getParameter("from");
		if(from.equalsIgnoreCase("menu")) {
			try {
				int menuId=Integer.parseInt(request.getParameter("menuId"));
				
				MenuDAOImp mdi=new MenuDAOImp();
				Menu menu=mdi.getMenu(menuId);
				int restaurantId=menu.getRestaurant_id();
				mdi.deleteMenu(menuId);
				
				request.setAttribute("restaurantId",Integer.toString(restaurantId) );
	            System.out.println(restaurantId);
	           
	            RequestDispatcher dispatcher = request.getRequestDispatcher("MenuItems");
	            dispatcher.forward(request, response);

//				response.sendRedirect("MenuItems");
			}
			catch(Exception e) {
				response.sendRedirect("MenuItems");
			}
		}
		else {
			try {
				int restaurantId=Integer.parseInt(request.getParameter("restaurantId"));
				RestaurantDAOImp rdi=new RestaurantDAOImp();
				rdi.deleteRestaurant(restaurantId);
				response.sendRedirect("restaurantAdmin");
			}
			catch(Exception e) {
				response.sendRedirect("restaurantAdmin");
			}
		}
	}
}

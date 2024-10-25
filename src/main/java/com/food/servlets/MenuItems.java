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

import com.food.DAOimpl.MenuDAOImp;
import com.food.model.Menu;

/**
 * Servlet implementation class MenuItems
 */
@WebServlet("/MenuItems")
public class MenuItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MenuDAOImp mdi;
	List<Menu> menu;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuItems() {
        super();
        mdi=new MenuDAOImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String restaurant=request.getParameter("restaurant");
		
		HttpSession session=request.getSession();
		if(restaurant!=null) {
		if(  restaurant.equalsIgnoreCase("restaurant") ) {
		try {
			
			String restaurantId=request.getParameter("restaurantId");
			session.setAttribute("restaurantId", restaurantId);
			int restaurantId1=Integer.parseInt(restaurantId);
			menu=mdi.getAllMenuRestaurant(restaurantId1);
			request.setAttribute("menuList", menu);
			request.setAttribute("restaurantId", restaurantId1);
            System.out.println(menu);
           
            RequestDispatcher dispatcher = request.getRequestDispatcher("MenuDetails.jsp");
            dispatcher.forward(request, response);
		}
		catch(Exception e) {
			
			System.out.println("error in restaurant");
			e.printStackTrace();
		}
		}
		}
		else {
			
			String restaurantId1= (String) session.getAttribute("restaurantId");
			int restaurantId=Integer.parseInt(restaurantId1);
			menu=mdi.getAllMenuRestaurant(restaurantId);
			request.setAttribute("menuList", menu);
			request.setAttribute("restaurantId", restaurantId);
            System.out.println(menu);
           
            RequestDispatcher dispatcher = request.getRequestDispatcher("MenuDetails.jsp");
            dispatcher.forward(request, response);
		}
	}
}

package com.food.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAOimpl.MenuDAOImp;
import com.food.model.Menu;
import com.food.model.User;

/**
 * Servlet implementation class MenuItemSave
 */
@WebServlet("/menuItemSave")
public class MenuItemSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Menu menu;
    MenuDAOImp mdi;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuItemSave() {
        super();
        menu=new Menu();
        mdi=new MenuDAOImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

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
		String menuId=request.getParameter("menuId");
		System.out.println(menuId);
		String menuName=request.getParameter("menuName");
		String description=request.getParameter("description");
		String rating=request.getParameter("rating");
		String isActive=request.getParameter("isActive");
		String price=request.getParameter("price");
		Boolean bool = true;
		
		if(isActive==null || isActive.equalsIgnoreCase("false")) {
			bool=false;
		}
		String imagePath=request.getParameter("imagePath");
		System.out.println(imagePath);
		HttpSession	session=request.getSession();
		Integer restaurantId=Integer.parseInt((String) session.getAttribute("restaurantId"));
		System.out.println(restaurantId+" hi ");
		
		if(menuId==null && restaurantId!=null ) {
			System.out.println("restaurant is available");
			menu.setImagePath(imagePath);
			menu.setDescription(description);
			menu.setItemname(menuName);
			menu.setRating(Double.parseDouble(rating));
			menu.setisAvailable(bool);


			menu.setRestaurant_id(restaurantId);
			/* menu.setMenu_id(Integer.parseInt(menuId)); */
			System.out.println(menu);
			mdi.addMenu(menu);
			
			
			
			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("Restaurant");
//	        dispatcher.forward(request, response);
			response.sendRedirect("MenuItems");

			
		
		}
		else {
			try {
				System.out.println(restaurantId+" me");
				menu.setImagePath(imagePath);
				menu.setDescription(description);
				menu.setItemname(menuName);
				menu.setRating(Double.parseDouble(rating));
				menu.setisAvailable(bool);
//				menu.setRestaurant_id(Integer.parseInt(restaurantId));
				menu.setPrice(Double.parseDouble(price));
				menu.setMenu_id(Integer.parseInt(menuId));
				
				mdi.updateMenu(menu);				
				request.setAttribute("MenuId", (int)Integer.parseInt(menuId));
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("MenuItemDetails.jsp");
		        dispatcher.forward(request, response);
				
				
//				request.setAttribute("restaurantId", (int)Integer.parseInt(restaurantId));
//				RequestDispatcher dispatcher = request.getRequestDispatcher("MenuItemDetails.jsp");
//		        dispatcher.forward(request, response);
//				response.sendRedirect("RestaurantSave");

			}
			catch(Exception e) {
				System.out.println("error in your data");
				e.printStackTrace();
			}
			
		}
	}

}

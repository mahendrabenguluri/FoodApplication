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
import com.food.DAOimpl.RestaurantDAOImp;
import com.food.model.Menu;
import com.food.model.Restaurant;

@WebServlet("/menu")
public class menu extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private MenuDAOImp menuDAOImp;
    private RestaurantDAOImp restaurantDAOImp;

    @Override
    public void init() throws ServletException {
        menuDAOImp = new MenuDAOImp();
        restaurantDAOImp = new RestaurantDAOImp();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String restaurantId = request.getParameter("restaurantId");
//        String from = request.getParameter("from");
        HttpSession session = request.getSession();

        try {

        if (restaurantId != null && !restaurantId.trim().isEmpty()) {
            // User clicked on a specific restaurant
        	int restaurantIdInt =0;
        	
            restaurantIdInt = Integer.parseInt(restaurantId.trim());
            Restaurant restaurant = restaurantDAOImp.getRestaurant(restaurantIdInt);
            List<Menu> menuList = menuDAOImp.getAllMenuRestaurant(restaurantIdInt);

            session.setAttribute("restaurantId", restaurantId); // Store restaurant ID in session
//            session.setAttribute("from", "menuitems"); // Indicate that the user came from a specific restaurant

            request.setAttribute("menuList", menuList);
            request.setAttribute("restaurant", restaurant);
        }else {
        	System.out.println("hello");
    		List<Menu> menuList = menuDAOImp.getAllMenu();
            request.setAttribute("menuList", menuList);

            }

        
        }catch(Exception e) {
    		System.out.println("hello");
    		List<Menu> menuList = menuDAOImp.getAllMenu();
            request.setAttribute("menuList", menuList);

    	}

        RequestDispatcher dispatcher = request.getRequestDispatcher("Menu.jsp");
        dispatcher.forward(request, response);
    }
}




//
//else {
//    // Default to showing all menu items if no specific restaurant is in context
//    List<Menu> menuList = menuDAOImp.getAllMenu();
//    request.setAttribute("menuList", menuList);
//}


//if (restaurantId != null && !restaurantId.trim().isEmpty()) {
//// Store the restaurantId in the session for later use
//session.setAttribute("restaurantId", restaurantId);
//session.setAttribute("from", "menuitems");
//// Load restaurant-specific menu items
//} else if ("menuitems".equals(session.getAttribute("from"))) {
//// User is returning to restaurant-specific menu items
//restaurantId = (String) session.getAttribute("restaurantId");
//// Load the menu items based on restaurantId
//}


//Restaurant restaurant = restaurantDAOImp.getRestaurant(restaurantIdInt);
//List<Menu> menuList = menuDAOImp.getAllMenuRestaurant(restaurantIdInt);
//
//session.setAttribute("restaurantId", restaurantId); // Store restaurant ID in session
//session.setAttribute("from", "menuitems"); // Indicate that the user came from a specific restaurant
//
//request.setAttribute("menuList", menuList);
//request.setAttribute("restaurant", restaurant);
//} else if ("menuitems".equals(session.getAttribute("from"))) {
//// User came from a specific restaurant
//String sessionRestaurantId = (String) session.getAttribute("restaurantId");
//if (sessionRestaurantId != null) {
//  int restaurantIdInt = Integer.parseInt(sessionRestaurantId);
//  Restaurant restaurant = restaurantDAOImp.getRestaurant(restaurantIdInt);
//  List<Menu> menuList = menuDAOImp.getAllMenuRestaurant(restaurantIdInt);
//
//  request.setAttribute("menuList", menuList);
//  request.setAttribute("restaurant", restaurant);
//}

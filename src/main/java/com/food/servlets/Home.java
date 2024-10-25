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

import com.food.DAO.MenuDAO;
import com.food.DAO.RestaurantDAO;
import com.food.DAOimpl.MenuDAOImp;
import com.food.DAOimpl.RestaurantDAOImp;
import com.food.model.Menu;
import com.food.model.Restaurant;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private RestaurantDAO restaurantDAO;
    private MenuDAO menuDAO;
    
    @Override
    public void init() throws ServletException {
        restaurantDAO = new RestaurantDAOImp();
        menuDAO = new MenuDAOImp();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Fetch all restaurants
        List<Restaurant> restaurantList = restaurantDAO.getAllRestaurant();
        
        // Fetch all menu items
        List<Menu> menuList = menuDAO.getAllMenu();
        
        // Set attributes to request
        req.setAttribute("restaurantList", restaurantList);
        req.setAttribute("menuList", menuList);
        
//        System.out.println(session.getAttribute("date")+"date" );
        // Forward the request to Home.jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
        dispatcher.forward(req, resp);
    }
}

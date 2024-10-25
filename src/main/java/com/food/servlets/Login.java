package com.food.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.UserDAO;
import com.food.DAOimpl.UserDAOImp;
import com.food.model.User;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	UserDAO userDAO;
	  
    @Override
    public void init() throws ServletException {
    	userDAO=new UserDAOImp();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
		User user=	userDAO.getUser(email,password);
		
		if(user!=null ){
			
		HttpSession	session=request.getSession(true);
		session.setAttribute("loggedInUser", user);
		if(user.getRole().equalsIgnoreCase("customer")) {
			response.sendRedirect("Home");
		}
		else {
			System.out.println("Restaurant");
			response.sendRedirect("restaurantAdmin");
		}
//		System.out.println(user.getUserid());
	
		
		}
		else {
		request.setAttribute("ErroeMessage", "Invalid username password");
	    request.getRequestDispatcher("Login.jsp").forward(request, response);
		
	}
}	
	}


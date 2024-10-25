package com.food.servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.UserDAO;
import com.food.DAOimpl.CartItemDAOImp;
import com.food.DAOimpl.CartItemDAOImp;
import com.food.DAOimpl.UserDAOImp;
import com.food.model.User;

@WebServlet("/logout")
public class Logout extends HttpServlet{
private static final long serialVersionUID = 1L;
	

	UserDAO userDAO;
	User user;
	  
    @Override
    public void init() throws ServletException {
    	userDAO=new UserDAOImp();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession	session=request.getSession(true);
		try {
			user=(User) session.getAttribute("loggedInUser");
			int id=user.getUserid();
			
			userDAO.update(id);
		}
		catch(Exception e) {
			System.out.println("user is null");
		}
		
		
		
		
		//System.out.println("hello");
		user=null;
		/*
		 * session.removeAttribute("cartCount"); session.setAttribute("loggedInUser",
		 * user); response.sendRedirect("Home.jsp");
		 */
		try {
		Set<Integer> set=(Set<Integer>) session.getAttribute("set");
		for(Integer i:set) {
			CartItemDAOImp cdi=new CartItemDAOImp();
			cdi.deleteCartItemById(i);
		}
		}catch(Exception e) {
			System.out.println("cart is empty");
		}
    	session.invalidate();

        response.sendRedirect("Home");
	
	}

}

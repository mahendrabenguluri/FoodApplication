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
 * Servlet implementation class Register
 */
@WebServlet("/signup")
public class Signup extends HttpServlet {
	
	UserDAO userDAO;
	
	  
    @Override
    public void init() throws ServletException {
    	userDAO=new UserDAOImp();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		userDAO=new UserDAOImp();
		HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
		String username,email,password,address,role;
		
		username=request.getParameter("username");
		email=request.getParameter("email");
		password=request.getParameter("password");	
		
		address=request.getParameter("address");
		role=request.getParameter("role");
		System.out.println(role);

		 if (loggedInUser == null) {
			int x = userDAO.addUser(new User(0,username, email, address, role, password));
			
			if(x != 0) {
				response.sendRedirect("Login.jsp");
			}
			else {
				/* response.sendRedirect("failure.jsp"); */
				System.out.println("error 1");
				response.sendRedirect("Profile.jsp");
			}
		}
		else if(loggedInUser != null){
			User user=new User(loggedInUser.getUserid(),username, email, address, role, password);
			int x=userDAO.updateUser(user);
			if(x != 0) {
				session.setAttribute("loggedInUser", user);
				response.sendRedirect("Profile.jsp");
			}
			
		}
		
		
		
	}

}

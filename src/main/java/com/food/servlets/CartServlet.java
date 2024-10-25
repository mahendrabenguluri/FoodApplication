package com.food.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.MenuDAO;
import com.food.DAOimpl.MenuDAOImp;
import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.Menu;
import com.food.model.User;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CartServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        // Check if cart exists in session, if not, create a new one
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");
        if ("add".equals(action)) {
            addItemToCart(request, cart, session);
        } else if ("update".equals(action)) {
            updateItem(request, cart);
        } else if ("remove".equals(action)) {
            removeItem(request, cart);
        }

        // Save the updated cart back in the session
        session.setAttribute("cart", cart);
		session.setAttribute("cart1", cart.getItems());
        session.setAttribute("cartCount",cart.getItems().size());
        System.out.println(cart.getItems());
        response.sendRedirect("cart.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    private void addItemToCart(HttpServletRequest request, Cart cart, HttpSession session) throws IOException {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        MenuDAO menuDAO = new MenuDAOImp();
        Menu menuItem = menuDAO.getMenu(itemId);

        User user = (User) session.getAttribute("loggedInUser");
        if (menuItem != null && user != null) {
            CartItem item = new CartItem(user.getUserid(),
                menuItem.getMenu_id(),
                menuItem.getRestaurant_id(),
                menuItem.getItemname(),
                quantity,
                menuItem.getPrice(),
                menuItem.getImagePath());

            cart.addItem(item);  // Add the item to the cart
        } else {
//            response.sendRedirect("Login.jsp");  // Redirect if the user is not logged in or item is not found
        }
    }

    private void updateItem(HttpServletRequest request, Cart cart) {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Update the item's quantity in the cart
        cart.updateItem(itemId, quantity);
    }

    private void removeItem(HttpServletRequest request, Cart cart) {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        cart.removeItem(itemId);  // Remove the item from the cart
    }
}

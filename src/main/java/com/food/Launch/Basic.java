package com.food.Launch;

import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.food.DAOimpl.CartItemDAOImp;
import com.food.DAOimpl.MenuDAOImp;
import com.food.DAOimpl.OrderDAoImp;
import com.food.DAOimpl.RestaurantDAOImp;
import com.food.model.CartItem;
import com.food.model.Restaurant;


public class Basic {

	public static void main(String[] args) throws Exception {
		/*
		 * String jdbcUrl = "jdbc:mysql://localhost:3306/online_food_delivery"; String
		 * username = "root"; String password = "mahi";
		 * 
		 * String sql = "update menu set imagepath=? where menu_id=?";
		 * 
		 * Connection con = DriverManager.getConnection(jdbcUrl, username, password);
		 * PreparedStatement statement = con.prepareStatement(sql); FileInputStream fis
		 * = new
		 * FileInputStream("C:\\Users\\WINDOWS\\Downloads\\kosambari-recipe-1-1.jpg");
		 * 
		 * statement.setBlob(1, fis); statement.setInt(2, 4); int rowsAffected =
		 * statement.executeUpdate(); System.out.println("Rows affected: " +
		 * rowsAffected);
		 */
//		MenuDAOImp mdi=new MenuDAOImp();
//		System.out.println(mdi.getAllMenuRestaurant(1));
//		OrderDAoImp odi=new OrderDAoImp();
//		
//		System.out.println(odi.getOrder(3));
//	    System.out.println(odi.getOrderId());
//	    String str="Fri Aug 16 14:57:12 IST 2024";
//	    System.out.println(str.length());
//		odi.updateAddressPaymentMethod(3, "bangalore", "upi");
		
		CartItem ci=new CartItem(2,2,2, "hello", 1, 2.0,"C:\\Users\\WINDOWS\\Downloads\\kosambari-recipe-1-1.jpg");
		CartItemDAOImp cid=new  CartItemDAOImp();
		System.out.println(cid.addCartItem(ci));
//		RestaurantDAOImp rdi=new RestaurantDAOImp();
//        List<Restaurant> restaurant=rdi.getAllRestaurantAdmin(18);
//        System.out.println(restaurant);
		
	}

}


package com.food.DAOimpl;

import java.io.*;
import java.util.Base64;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialBlob;


import com.food.DAO.RestaurantDAO;
import com.food.model.Restaurant;
import com.food.model.User;

public class RestaurantDAOImp implements RestaurantDAO{
	String url="jdbc:mysql://localhost:3306/online_food_delivery";
	String username="root";
	String password="mahi";
	
	String insert="INSERT INTO restaurant(`name`,`cuisinetype`,`deliverytime`,`Address`,`rating`,`isActive`,`imagepath`,`AdminUserID`) VALUES(?,?,?,?,?,?,?,?)";
	String select="SELECT * FROM `restaurant` WHERE `restaurant_id`=?";
	String update="UPDATE `restaurant` SET `name`=?, `cuisinetype`=? ,`deliverytime`=?,`Address`=?,`rating`=?,`isActive`=? ,`imagePath`=? WHERE `restaurant_id`=?";
	String selectAll="SELECT * FROM `restaurant`";
	String delete="DELETE FROM `restaurant` WHERE restaurant_id=?";
	String restaurantAdmin="SELECT * FROM `restaurant` WHERE `AdminUserID`=?";

	Connection connection=null;
	PreparedStatement statement=null;
	ResultSet res=null;
	Restaurant restaurant=null;
	
	
	public RestaurantDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
			
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}

 
	


	@Override
	public void addRestaurant(Restaurant Restaurant) {
		PreparedStatement statement=null;
		try {
			
			statement=connection.prepareStatement(insert);
			statement.setString(1, Restaurant.getName());
			statement.setString(2, Restaurant.getCuisineType());
			statement.setInt(3,  Restaurant.getDeliveryTime());
			statement.setString(4, Restaurant.getAddress());
			//statement.setInt(5, Restaurant.getAdminUserId());	
			statement.setDouble(5, Restaurant.getRating());		
			statement.setBoolean(6, Restaurant.isActive());
//			statement.setString(7, Restaurant.getImagePath());
//			FileInputStream fis = new FileInputStream(new File(imagePath));
			FileInputStream fis= new FileInputStream(Restaurant.getImagePath());
			statement.setBlob(7, fis);
			statement.setInt(8, Restaurant.getAdminId());
			System.out.println(statement.executeUpdate());
			
//			Blob imageBlob = rs.getBlob("image_data");
//            byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
//
//            // Encode the image bytes to Base64
//            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
//            String imageUrl = "data:image/jpeg;base64," + base64Image; // Change the MIME type if needed
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
	}

	@Override
	public Restaurant getRestaurant(int Restaurant_Id) {
		
		try {
			statement=connection.prepareStatement(select);
			statement.setInt(1, Restaurant_Id);;
			 res=statement.executeQuery();
			
			  if(res.next()) {
				  restaurant= extractUserFromResultSet(res);
			}
		}
		
			catch (Exception ex) 
			{
				
				ex.printStackTrace();
			}
			return restaurant;

	}
	private Restaurant extractUserFromResultSet(ResultSet res) throws SQLException{
		Restaurant restaurant=new Restaurant();
		restaurant.setRestaurant_Id(res.getInt("restaurant_id"));
		restaurant.setName(res.getString("name"));
		restaurant.setCuisineType(res.getString("cuisinetype"));
		restaurant.setDeliveryTime(res.getInt("deliverytime"));
		restaurant.setAddress(res.getString("Address"));
		restaurant.setRating(res.getDouble("rating"));
		restaurant.setActive(res.getBoolean("isActive"));
		
		Blob imageBlob = res.getBlob("imagepath");
      byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
//
//      // Encode the image bytes to Base64
      String base64Image = Base64.getEncoder().encodeToString(imageBytes);
      String imageUrl = "data:image/jpeg;base64," + base64Image; // Change the MIME type if needed
      restaurant.setImagePath(imageUrl);
		return restaurant;
	
	}


	@Override
	public void updateRestaurant(Restaurant Restaurant) {
	
			try {
						
					    statement = connection.prepareStatement(update);
						
						statement.setString(1, Restaurant.getName());
						statement.setString(2,  Restaurant.getCuisineType());
						statement.setInt(3, Restaurant.getDeliveryTime());
						statement.setString(4, Restaurant.getAddress());	
						statement.setDouble(5, Restaurant.getRating());	
						statement.setBoolean(6, Restaurant.isActive());	
//						FileInputStream fis= new FileInputStream();
						
						
						
						String[] parts =(Restaurant.getImagePath()).split(",");
				        String imageString = parts.length > 1 ? parts[1] : parts[0];

				        // Decode the Base64 string to get the byte array
				        byte[] imageBytes = Base64.getDecoder().decode(imageString);

				        // Create a Blob from the byte array
				        Blob imageBlob = new SerialBlob(imageBytes);
				        statement.setBlob(7, imageBlob);
				        
						statement.setInt(8, Restaurant.getRestaurant_Id());
						
						System.out.println(statement.executeUpdate());
						statement.executeUpdate();

					} 
					catch (Exception e) 
					{
						
						e.printStackTrace();
					}
					
	}

	@Override
	public void deleteRestaurant(int Restaurant) {
		try {
			statement = connection.prepareStatement(delete);
			statement.setInt(1,Restaurant);
			System.out.println("row affected: " + statement.executeUpdate());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		List<Restaurant> al = new ArrayList<Restaurant>();
		
		
		 try {
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(selectAll);
			
			while(res.next()) {
				
				Restaurant r=extractUserFromResultSet(res);
				
				al.add(r);			 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
	@Override
	public List<Restaurant> getAllRestaurantAdmin(int adminId) {
		List<Restaurant> al = new ArrayList<Restaurant>();
		
		try {
			statement=connection.prepareStatement(restaurantAdmin);
			statement.setInt(1, adminId);
			 res=statement.executeQuery();
			 while(res.next()) {
					
					Restaurant r=extractUserFromResultSet(res);
					
					al.add(r);			 
			 }  
		}
		
		catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		 
		return al;
	}


}
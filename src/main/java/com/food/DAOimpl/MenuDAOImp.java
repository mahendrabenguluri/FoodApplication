package com.food.DAOimpl;

import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import com.food.DAO.MenuDAO;
import com.food.model.Menu;
import com.food.model.Restaurant;

public class MenuDAOImp implements MenuDAO{
	String url="jdbc:mysql://localhost:3306/online_food_delivery";
	String username="root";
	String password="mahi";
	
	String insert="INSERT INTO `menu`(`itemname`,`description`,`price`,`isAvailable`,`imagepath`,`Restaurant_ID`,`rating`) VALUES(?,?,?,?,?,?,?)";
	String select="SELECT * FROM `menu` WHERE `menu_id`=?";
	String update="UPDATE `menu` SET `itemname`=?, `description`=? ,`price`=?,`isAvailable`=? ,`imagepath`=?,`rating`=? WHERE `menu_id`=?";
	String selectAll="SELECT * FROM `menu`";
	String delete="DELETE FROM `menu` WHERE `menu_id`=?";
    String menudetails="SELECT * FROM `menu` WHERE `restaurant_id`=?";
//    String menu="select * from menu where `rest` "
    
    
	Connection connection=null;
	PreparedStatement statement=null;
	ResultSet res=null;
	Menu menu=null;
	
	
	public MenuDAOImp() {
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
	public void addMenu(Menu Menu) {
		PreparedStatement statement=null;
		try {
			
			statement=connection.prepareStatement(insert);
			statement.setString(1, Menu.getItemname());
			statement.setString(2, Menu.getDescription());
			statement.setDouble(3,  Menu.getPrice());
			statement.setBoolean(4, Menu.getisAvailable());

			FileInputStream fis= new FileInputStream(Menu.getImagePath());
			statement.setBlob(5, fis);
			statement.setInt(6, Menu.getRestaurant_id());
			statement.setDouble(7, Menu.getRating());
			System.out.println(statement.executeUpdate());
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Menu getMenu(int Menu_id) {

		try {
			statement=connection.prepareStatement(select);
			statement.setInt(1, Menu_id);;
			 res=statement.executeQuery();
			
			  if(res.next()) {
				  menu= extractUserFromResultSet(res);
			}
		}
		
			catch (Exception ex) 
			{
				
				ex.printStackTrace();
			}
			return menu;

	}
	private Menu extractUserFromResultSet(ResultSet res) throws SQLException{
		Menu menu=new Menu();
		menu.setMenu_id(res.getInt("menu_id"));
		menu.setRestaurant_id(res.getInt("restaurant_id"));
		menu.setItemname(res.getString("itemname"));
		menu.setDescription(res.getString("description"));
		menu.setPrice(res.getInt("price"));
		menu.setRating(res.getDouble("rating"));
		menu.setisAvailable(res.getBoolean("isAvailable"));
		Blob imageBlob = res.getBlob("imagepath");
	      byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
	//
//	      // Encode the image bytes to Base64
	      String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	      String imageUrl = "data:image/jpeg;base64," + base64Image; // Change the MIME type if needed
	      menu.setImagePath(imageUrl);
//		menu.setImagePath(res.getBlob("imagepath"));
		
		return menu;
	
		
	}


	@Override
	public void updateMenu(Menu Menu) {

		try {
					
				    statement = connection.prepareStatement(update);
					
					statement.setString(1, Menu.getItemname());
					statement.setString(2,  Menu.getDescription());
					statement.setDouble(3, Menu.getPrice());
					statement.setBoolean(4, Menu.getisAvailable());	
					
					
////					System.out.println(menu.getImagePath());
//					String[] parts =(menu.getImagePath()).split(",");
//			        String imageString = parts.length > 1 ? parts[1] : parts[0];
//
//			        // Decode the Base64 string to get the byte array
//			        byte[] imageBytes = Base64.getDecoder().decode(imageString);
//
//			        // Create a Blob from the byte array
//			        Blob imageBlob = new SerialBlob(imageBytes);
//			        statement.setBlob(5, imageBlob);
			        
			        
					System.out.println();
					
					String[] parts =(Menu.getImagePath()).split(",");
			        String imageString = parts.length > 1 ? parts[1] : parts[0];

			        // Decode the Base64 string to get the byte array
			        byte[] imageBytes = Base64.getDecoder().decode(imageString);

			        // Create a Blob from the byte array
			        Blob imageBlob = new SerialBlob(imageBytes);
			        statement.setBlob(5, imageBlob);
			        
			        statement.setDouble(6,Menu.getRating());
			        statement.setInt(7, Menu.getMenu_id());
					System.out.println(statement.executeUpdate());
					statement.executeUpdate();

				} 
				catch (Exception e) 
				{
					
					e.printStackTrace();
				}
	}

	@Override
	public void deleteMenu(int Menu) {
		try {
			statement = connection.prepareStatement(delete);
			statement.setInt(1,Menu);
			System.out.println("row affected: " + statement.executeUpdate());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Menu> getAllMenu() {
		List<Menu> al = new ArrayList<Menu>();
		
		 try {
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(selectAll);
				
			while(res.next()) {
				Menu menu=extractUserFromResultSet(res);		
				al.add(menu);			 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
	
	@Override
	public List<Menu> getAllMenuRestaurant(int restaurant_id){
		List<Menu> al = new ArrayList<Menu>();
		
		 try {
			 statement = connection.prepareStatement(menudetails);
			 statement.setInt(1, restaurant_id);
			ResultSet res = statement.executeQuery();
				
			while(res.next()) {
				Menu menu=extractUserFromResultSet(res);		
				al.add(menu);			 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
		
	}
	

}

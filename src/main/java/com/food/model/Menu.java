package com.food.model;

import java.sql.Blob;

public class Menu {
	private int menu_id;
	private int restaurant_id;
	private String itemname;
	private String description;
	private double price;
	private boolean isAvailable;
	private String ImagePath;
	private Double rating;
	
	
	public Menu() {
		super();
	}



	public Menu(int menu_id,String itemname, String description, double price,
			boolean isAvailable,String ImagePath) {
		super();
		this.menu_id=menu_id;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.ImagePath = ImagePath;
	}



	public int getMenu_id() {
		return menu_id;
	}



	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}



	public int getRestaurant_id() {
		return restaurant_id;
	}



	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}



	public String getItemname() {
		return itemname;
	}



	public void setItemname(String itemname) {
		this.itemname = itemname;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public boolean getisAvailable() {
		return isAvailable;
	}



	public void setisAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public String getImagePath() {
		return ImagePath;
	}
	
	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}


	public boolean isAvailable() {
		return isAvailable;
	}



	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}



	public Double getRating() {
		return rating;
	}



	public void setRating(Double rating) {
		this.rating = rating;
	}



	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", restaurant_id=" + restaurant_id + ", itemname=" + itemname
				+ ", description=" + description + ", price=" + price + ", isAvailable=" + isAvailable + "]";
	}
	
	

}

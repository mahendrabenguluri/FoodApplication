package com.food.model;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;

public class CartItem {
	private int user_id;
	private int itemId;
    private int resturantId;
    private int order_id;
    private String name;
    private int quantity;
    private double price;
    private String imagePath;
    private Timestamp order_date;
    public CartItem() {
    	
    }

    public CartItem(int user_id,int itemId, int resturantId, String name, int quantity, double price,String imagePath) {
//    public CartItem(int itemId, String name, int quantity, double price) {
    	
    	this.user_id=user_id;
        this.itemId = itemId;
        this.resturantId = resturantId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.imagePath=imagePath;
        
    }

    public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public Timestamp getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	// Getters and setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

	public int getResturantId() {
		return resturantId;
	}

	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}
	public String getImagePath() {
		return imagePath;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

	@Override
	public String toString() {
		return "CartItem [user_id=" + user_id + ", itemId=" + itemId + ", resturantId=" + resturantId + ", order_id="
				+ order_id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", imagePath="
				+ imagePath + ", order_date=" + order_date + "]";
	}

	

	
	
    
    
    
}
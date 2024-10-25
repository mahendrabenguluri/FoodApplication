package com.food.model;

import java.sql.Timestamp;
import java.util.Date;

public class Order {
	private int order_id;
	private int user_id;
//	private int restaurant_id;
	private Timestamp order_date;
	private double total_amount;
	private String status;
	private String payment_method;
	private String address;
	
	public Order() {
		super();
	}


	public Order( int order_id, double total_amount, String status,
			String payment_method,String address) {
		super();
		this.order_id=order_id;
		
		this.total_amount = total_amount;
		this.status = status;
		this.payment_method = payment_method;
		this.address=address;
	}


	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
//
//
//	public int getRestaurant_id() {
//		return restaurant_id;
//	}
//
//
//	public void setRestaurant_id(int restaurant_id) {
//		this.restaurant_id = restaurant_id;
//	}


	public Timestamp getOrder_date() {
		return order_date;
	}


	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}


	public double getTotal_amount() {
		return total_amount;
	}


	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPayment_method() {
		return payment_method;
	}


	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user_id=" + user_id + ", order_date=" + order_date + ", total_amount=" + total_amount + ", status=" + status
				+ ", payment_method=" + payment_method + ", address=" + address + "]";
	}


	
	
}

package com.food.DAO;

import java.util.List;

import com.food.model.Restaurant;


public interface RestaurantDAO {
	
	
	void addRestaurant(Restaurant Restaurant);
	Restaurant getRestaurant(int Restaurant);
	void updateRestaurant(Restaurant Restaurant);
	void deleteRestaurant(int Restaurant);
	List<Restaurant> getAllRestaurant();
	List<Restaurant> getAllRestaurantAdmin(int adminId);

}

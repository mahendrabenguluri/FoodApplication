package com.food.DAO;

import java.util.List;

import com.food.model.Menu;


public interface MenuDAO {
	
	void addMenu(Menu Menu);
	Menu getMenu(int Menu_id);
	void updateMenu(Menu Menu);
	void deleteMenu(int Menu);
	List<Menu> getAllMenu();
	List<Menu> getAllMenuRestaurant(int restaurant_id);

}

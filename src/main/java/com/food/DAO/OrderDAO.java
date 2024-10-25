package com.food.DAO;


import java.util.List;


import com.food.model.Order;

public interface OrderDAO {
	
	 int addOrder(Order Order) ;
	Order getOrder(int Order_id);
	void updateOrder(Order Order);
	void deleteOrder(int Order);
	List<Order> getAllOrder();
//	int getOrderId(java.util.Date date);


}

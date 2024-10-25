package com.food.Launch;

import java.sql.*;
import java.util.*;

public class CartFetcher {

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/online_food_delivery";
            String user = "root";
            String password = "mahi";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver not found", e);
        }
    }

    public List<Map<String, Object>> fetchOrdersByUserId(int userId) {
        List<Map<String, Object>> orders = new ArrayList<>();

        String orderQuery = "SELECT order_id, total_amount FROM orders WHERE user_id = ? ORDER BY order_id DESC";
        try (Connection conn = getConnection();
             PreparedStatement orderStmt = conn.prepareStatement(orderQuery)) {

            orderStmt.setInt(1, userId);
            try (ResultSet orderRs = orderStmt.executeQuery()) {
                while (orderRs.next()) {
                    int orderId = orderRs.getInt("order_id");
                    double totalAmount = orderRs.getDouble("total_amount");

                    Map<String, Object> orderData = new HashMap<>();
                    orderData.put("orderId", orderId);
                    orderData.put("totalAmount", totalAmount);
                    orderData.put("cartItems", fetchCartItems(orderId));

                    orders.add(orderData);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    private List<Map<String, Object>> fetchCartItems(int orderId) {
        List<Map<String, Object>> cartItems = new ArrayList<>();

        String cartQuery = "SELECT * FROM cart_item WHERE order_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement cartStmt = conn.prepareStatement(cartQuery)) {

            cartStmt.setInt(1, orderId);
            try (ResultSet cartRs = cartStmt.executeQuery()) {
                while (cartRs.next()) {
                    Map<String, Object> itemData = new HashMap<>();
                    itemData.put("cartItemId", cartRs.getInt("cart_id"));
                    itemData.put("productId", cartRs.getInt("item_id"));
                    itemData.put("quantity", cartRs.getInt("quantity"));
                    itemData.put("addedDate", cartRs.getTimestamp("created_at"));
                    itemData.put("name", cartRs.getString("name"));
                    itemData.put("imageName", cartRs.getBlob("image_path")); // Placeholder, replace with actual image name

                    cartItems.add(itemData);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartItems;
    }
}

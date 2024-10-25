package com.food.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.food.DAOimpl.MenuDAOImp;

public class Cart {
    // The cart items, stored as a map of item IDs to CartItem objects
    private Map<Integer, CartItem> items;

    // Constructor initializes the cart with an empty HashMap
    public Cart() {
        this.items = new HashMap<>();
    }

    // Add an item to the cart (update quantity if it already exists)
    public void addItem(CartItem item) {
        int itemId = item.getItemId();
        
        if (items.containsKey(itemId)) {
            // If the item already exists in the cart, increase its quantity
            CartItem existingItem = items.get(itemId);
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
            MenuDAOImp mdi = new MenuDAOImp();
            Menu menu = mdi.getMenu(itemId);
            
            existingItem.setPrice(existingItem.getQuantity() * menu.getPrice());  // Update the price based on quantity
            System.out.println("Item " + itemId + " quantity updated in the cart.");
        } else {
            // If the item is new, add it to the cart
            items.put(itemId, item);
            System.out.println("Item " + item + " added to the cart.");
        }
    }

    // Update the quantity of an item in the cart
    public void updateItem(int itemId, int quantity) {
        if (items.containsKey(itemId)) {
            
                // Update the item quantity and adjust the price accordingly
                CartItem item = items.get(itemId);
                item.setQuantity(quantity);
                MenuDAOImp mdi = new MenuDAOImp();
                Menu menu = mdi.getMenu(itemId);
                item.setPrice(quantity * menu.getPrice());
//                item.setPrice(quantity * item.getPrice());
                System.out.println("Item " + itemId + " updated in the cart.");
            
        } else {
            System.out.println("Item " + itemId + " not found in the cart.");
        }
    }

    // Remove an item from the cart
    public void removeItem(int itemId) {
        if (items.containsKey(itemId)) {
            items.remove(itemId);
            System.out.println("Item " + itemId + " removed from the cart.");
        } else {
            System.out.println("Item " + itemId + " not found in the cart.");
        }
    }

    // Get all items in the cart
    public List<CartItem> getItems() {
    	Collection<CartItem> values = items.values();

        // Convert the collection to an ArrayList
        List<CartItem> valuesList = new ArrayList<>(values);
        return valuesList;
    }

    // Clear the entire cart
    public void clear() {
        items.clear();
        System.out.println("Cart cleared.");
    }

    // Calculate the total price of all items in the cart
    public double getTotalAmount() {
        double total = 0;
        for (CartItem item : items.values()) {
            total += item.getPrice();  // Sum up the price of all items
        }
        return total;
    }
}

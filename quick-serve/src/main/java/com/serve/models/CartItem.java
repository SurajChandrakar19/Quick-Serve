package com.serve.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CartItem {
    private int cartItemId;                 // Unique identifier for each cart item
    private int userId;                     // Foreign key linking to the user
    private int restaurantId;               // Foreign key linking to the restaurant
    private int menuItemId;                 // Foreign key linking to the menu item
    private String itemName;                // Name of the menu item
    private BigDecimal price;               // Price of the menu item
    private int quantity;                   // Quantity of the item added to the cart
    private BigDecimal totalPrice;          // Total price (price * quantity)
    private boolean isCustomized;           // If the user made any customizations
    private String customizationDetails;    // Customization details (e.g., extra cheese, no onions)
    private boolean isSpicy;                // If the item is spicy
    private boolean isVeg;                  // If the item is vegetarian
    private Timestamp orderDate;            // When the item was added to the cart
    private boolean isAvailable;            // Whether the item is still available for order
    private String status;                  // Status of the item ('in_cart', 'ordered', 'cancelled')
    private String payMethod;
    
	public int getCartItemId() {
		return cartItemId;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getMenuItemId() {
		return menuItemId;
	}
	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public boolean isCustomized() {
		return isCustomized;
	}
	public void setCustomized(boolean isCustomized) {
		this.isCustomized = isCustomized;
	}
	public String getCustomizationDetails() {
		return customizationDetails;
	}
	public void setCustomizationDetails(String customizationDetails) {
		this.customizationDetails = customizationDetails;
	}
	public boolean isSpicy() {
		return isSpicy;
	}
	public void setSpicy(boolean isSpicy) {
		this.isSpicy = isSpicy;
	}
	public boolean isVeg() {
		return isVeg;
	}
	public void setVeg(boolean isVeg) {
		this.isVeg = isVeg;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}


package com.serve.models;

public class MenuModel {
	private int itemId;
    private int restaurantId;
    private String itemName;
    private String description;
    private String cuisineType;
    private double price;
    private String ingredients;
    private boolean isVeg;
    private boolean isSpicy;
    private String preparationTime;
    private int calories;
    private double rating;
    private int reviewCount;
    private boolean isAvailable;
    private String availabilityTimes;
    private double discount;
    private boolean isFeatured;
    private String menuImageUrl;

    // Constructors
    public MenuModel() {}

    public MenuModel(int restaurantId, String itemName, String description, String cuisineType, double price, String ingredients, boolean isVeg, boolean isSpicy, String preparationTime, int calories, double rating, int reviewCount, boolean isAvailable, String availabilityTimes, double discount, boolean isFeatured, String menuImageUrl) {
        this.restaurantId = restaurantId;
        this.itemName = itemName;
        this.description = description;
        this.cuisineType = cuisineType;
        this.price = price;
        this.ingredients = ingredients;
        this.isVeg = isVeg;
        this.isSpicy = isSpicy;
        this.preparationTime = preparationTime;
        this.calories = calories;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.isAvailable = isAvailable;
        this.availabilityTimes = availabilityTimes;
        this.discount = discount;
        this.isFeatured = isFeatured;
        this.menuImageUrl = menuImageUrl;
    }

    // Getters and Setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isVeg() {
        return isVeg;
    }

    public void setVeg(boolean isVeg) {
        this.isVeg = isVeg;
    }

    public boolean isSpicy() {
        return isSpicy;
    }

    public void setSpicy(boolean isSpicy) {
        this.isSpicy = isSpicy;
    }

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getAvailabilityTimes() {
        return availabilityTimes;
    }

    public void setAvailabilityTimes(String availabilityTimes) {
        this.availabilityTimes = availabilityTimes;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean isFeatured) {
        this.isFeatured = isFeatured;
    }

    public String getMenuImageUrl() {
        return menuImageUrl;
    }

    public void setMenuImageUrl(String menuImageUrl) {
        this.menuImageUrl = menuImageUrl;
    }

    @Override
    public String toString() {
        return "MenuItem [itemId=" + itemId + ", restaurantId=" + restaurantId + ", itemName=" + itemName + ", description=" + description
                + ", cuisineType=" + cuisineType + ", price=" + price + ", ingredients=" + ingredients + ", isVeg=" + isVeg
                + ", isSpicy=" + isSpicy + ", preparationTime=" + preparationTime + ", calories=" + calories
                + ", rating=" + rating + ", reviewCount=" + reviewCount + ", isAvailable=" + isAvailable
                + ", availabilityTimes=" + availabilityTimes + ", discount=" + discount + ", isFeatured=" + isFeatured
                + ", menuImageUrl=" + menuImageUrl + "]";
    }
}

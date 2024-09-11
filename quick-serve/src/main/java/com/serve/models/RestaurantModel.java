package com.serve.models;

import java.sql.Timestamp;

public class RestaurantModel {
    private int id;                  // Unique identifier for each restaurant
    private String name;             // Restaurant name
    private String description;      // Brief description of the restaurant
    private String cuisineType;      // Type of cuisine (e.g., Indian, Italian)
    
    // Location Details
    private String address;          // Full address of the restaurant
    private String city;             // City where the restaurant is located
    private String state;            // State or region
    private String postalCode;       // ZIP or postal code
    
    // Contact Details
    private String phoneNumber;      // Restaurant phone number
    private String email;            // Restaurant email
    private String website;          // Restaurant's website
    
    // Operational Information
    private String openingHours;     // Opening hours (e.g., "Mon-Fri 9 AM to 10 PM")
    private String deliveryTime;     // Estimated delivery time (e.g., "30-45 mins")
    private String deliveryAreas;    // Locations or radius within which they deliver
    private int reviewCount;         // Total number of reviews

    // Image URLs
    private String logoUrl;          // URL of the restaurant's logo
    private String menuImageUrl;     // URL of menu item images
    private String restaurantPhotoUrl; // URL of the restaurant photos

    // Availability and Status
    private boolean isOpen;          // Whether the restaurant is open or closed
    private boolean isBusy;          // If the restaurant is too busy for orders
    
    // Partner and Registration Info
    private String ownerName;        // Name of the restaurant owner/manager
    private String ownerContact;     // Contact number of the owner/manager
    private Timestamp registrationDate; // When the restaurant was added to the platform

    // Getters and Setters for each field

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryAreas() {
        return deliveryAreas;
    }

    public void setDeliveryAreas(String deliveryAreas) {
        this.deliveryAreas = deliveryAreas;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getMenuImageUrl() {
        return menuImageUrl;
    }

    public void setMenuImageUrl(String menuImageUrl) {
        this.menuImageUrl = menuImageUrl;
    }

    public String getRestaurantPhotoUrl() {
        return restaurantPhotoUrl;
    }

    public void setRestaurantPhotoUrl(String restaurantPhotoUrl) {
        this.restaurantPhotoUrl = restaurantPhotoUrl;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public boolean getIsBusy() {
        return isBusy;
    }

    public void setIsBusy(boolean isBusy) {
        this.isBusy = isBusy;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerContact() {
        return ownerContact;
    }

    public void setOwnerContact(String ownerContact) {
        this.ownerContact = ownerContact;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }
}


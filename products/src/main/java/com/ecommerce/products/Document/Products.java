package com.ecommerce.products.Document;


import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
@Document

public class Products {

    @Id
    String productId;
    private String productName;
    private String imageUrl;
    private String description;
    private float age;
    private String color;
    private String gender;
    private int quantity;
    private int price;
    private int merchantId;
    private String merchantName;
    private String categoryName;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId ;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", gender='" + gender + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", merchantId=" + merchantId +
                ", merchantName='" + merchantName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}

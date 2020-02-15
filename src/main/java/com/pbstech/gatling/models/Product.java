package com.pbstech.gatling.models;

public class Product {

    private String productName;
    private String productCategory;
    private Long delay;

    public Product(String productName, String productCategory, Long delay) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.delay = delay;
    }

    public Product() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Long getDelay() {
        return delay;
    }

    public void setDelay(Long delay) {
        this.delay = delay;
    }
}
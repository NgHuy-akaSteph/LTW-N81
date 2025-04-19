package com.nhom81.model;


import java.sql.Date;

public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private Date releaseDate;
    private String describe;
    private String image;
    private int cid;

    public Product() {
    }

    public Product(String id, String name, double price, int quantity, Date releaseDate, String describe, String image, int cid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.releaseDate = releaseDate;
        this.describe = describe;
        this.image = image;
        this.cid = cid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}

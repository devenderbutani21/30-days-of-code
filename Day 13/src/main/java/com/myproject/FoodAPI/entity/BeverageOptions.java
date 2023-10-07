package com.myproject.FoodAPI.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "beverage_options")
public class BeverageOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "beverage_name")
    private String beverageName;

    @Column(name = "price")
    private float price;
    @Column(name = "rating")
    private float rating;

    public BeverageOptions() {

    }

    public BeverageOptions(String imgUrl, String beverageName, float price, float rating) {
        this.imgUrl = imgUrl;
        this.beverageName = beverageName;
        this.price = price;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getBeverageName() {
        return beverageName;
    }

    public void setBeverageName(String beverageName) {
        this.beverageName = beverageName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "BeverageOptions{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", beverageName='" + beverageName + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}

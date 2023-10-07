package com.myproject.FoodAPI.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "desert_options")
public class DesertOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "desert_name")
    private String desertName;

    @Column(name = "price")
    private float price;

    @Column(name = "rating")
    private float rating;

    public DesertOptions() {

    }

    public DesertOptions(String imgUrl, String desertName, float price, float rating) {
        this.imgUrl = imgUrl;
        this.desertName = desertName;
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

    public String getDesertName() {
        return desertName;
    }

    public void setDesertName(String desertName) {
        this.desertName = desertName;
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
        return "DesertOptions{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", desertName='" + desertName + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}

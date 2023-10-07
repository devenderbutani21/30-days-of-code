package com.myproject.FoodAPI.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bowl_options")
public class BowlOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "bowl_name")
    private String bowlName;

    @Column(name = "price")
    private float price;

    @Column(name = "rating")
    private float rating;

    public BowlOptions() {

    }

    public BowlOptions(String imgUrl, String bowlName, float price, float rating) {
        this.imgUrl = imgUrl;
        this.bowlName = bowlName;
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

    public String getBowlName() {
        return bowlName;
    }

    public void setBowlName(String bowlName) {
        this.bowlName = bowlName;
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
        return "BowlOptions{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", bowlName='" + bowlName + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}

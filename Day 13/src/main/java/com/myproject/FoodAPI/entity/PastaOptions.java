package com.myproject.FoodAPI.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pasta_options")
public class PastaOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "pasta_name")
    private String pastaName;

    @Column(name = "price")
    private float price;

    @Column(name = "rating")
    private float rating;

    public PastaOptions() {

    }

    public PastaOptions(String imgUrl, String pastaName, float price, float rating) {
        this.imgUrl = imgUrl;
        this.pastaName = pastaName;
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

    public String getPastaName() {
        return pastaName;
    }

    public void setPastaName(String pastaName) {
        this.pastaName = pastaName;
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
        return "PastaOptions{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", pastaName='" + pastaName + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}

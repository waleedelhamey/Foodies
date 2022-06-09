package com.example.foodies.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Adapter;

import java.io.Serializable;

public class Restaurant implements Serializable  {
    private String uuid;
    private String name;
    private String address1;
    private String address2;
    private String city;
    private String province;
    private String postalCode ;
    private int minPrice ;
    private int maxPrice ;
    private double deliveryFee ;
    private boolean isFeatured ;
    private int bannerImage ;
    private Double rating ;
    private boolean isVegetarian ;

    public Restaurant(){

    }
    public Restaurant(Restaurant temp){
        this.uuid=temp.getUuid();
        this.name=temp.getName();
        this.address1=temp.getAddress1();
        this.address2=temp.getAddress2();
        this.city=temp.getCity();
        this.province=temp.getProvince();
        this.postalCode = temp.getPostalCode();
        this.minPrice =temp.getMinPrice();
        this.maxPrice =temp.getMaxPrice();
        this.deliveryFee =temp.getDeliveryFee();
        this.isFeatured =temp.isFeatured();
        this.bannerImage =temp.getBannerImage();
        this.rating =temp.getRating();
        this.isVegetarian =temp.isVegetarian();
    }
    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    private String deliveryTime;

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(int bannerImage) {
        this.bannerImage = bannerImage;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }


}
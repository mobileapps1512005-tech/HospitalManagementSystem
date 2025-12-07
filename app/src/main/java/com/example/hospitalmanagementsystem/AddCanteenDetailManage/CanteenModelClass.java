package com.example.hospitalmanagementsystem.AddCanteenDetailManage;

public class CanteenModelClass {
    int id;

    String menu,half,halfPrice,fullPlate,fullPrice,discount,combo,phone;

    public CanteenModelClass(int id, String menu, String half, String halfPrice, String fullPlate, String fullPrice, String discount, String combo, String phone) {
        this.id = id;
        this.menu = menu;
        this.half = half;
        this.halfPrice = halfPrice;
        this.fullPlate = fullPlate;
        this.fullPrice = fullPrice;
        this.discount = discount;
        this.combo = combo;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getHalf() {
        return half;
    }

    public void setHalf(String half) {
        this.half = half;
    }

    public String getHalfPrice() {
        return halfPrice;
    }

    public void setHalfPrice(String halfPrice) {
        this.halfPrice = halfPrice;
    }

    public String getFullPlate() {
        return fullPlate;
    }

    public void setFullPlate(String fullPlate) {
        this.fullPlate = fullPlate;
    }

    public String getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(String fullPrice) {
        this.fullPrice = fullPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getCombo() {
        return combo;
    }

    public void setCombo(String combo) {
        this.combo = combo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

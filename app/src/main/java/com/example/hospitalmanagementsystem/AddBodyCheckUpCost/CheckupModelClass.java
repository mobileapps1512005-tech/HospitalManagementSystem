package com.example.hospitalmanagementsystem.AddBodyCheckUpCost;

public class CheckupModelClass {
    int id;
    String name,part,price,discount,phone;

    public CheckupModelClass(int id, String name, String part, String price, String discount, String phone) {
        this.id = id;
        this.name = name;
        this.part = part;
        this.price = price;
        this.discount = discount;
        this.phone = phone;
    }

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

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

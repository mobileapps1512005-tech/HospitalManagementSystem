package com.example.hospitalmanagementsystem.AddCanteenDetailManage;

public class PatientFoodRequestModelClass {
    int id;
    String name,menu,quantity,floor,bad,phone;

    public PatientFoodRequestModelClass(int id, String name, String menu, String quantity, String floor, String bad, String phone) {
        this.id = id;
        this.name = name;
        this.menu = menu;
        this.quantity = quantity;
        this.floor = floor;
        this.bad = bad;
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

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBad() {
        return bad;
    }

    public void setBad(String bad) {
        this.bad = bad;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

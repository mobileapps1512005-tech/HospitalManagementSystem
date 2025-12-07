package com.example.hospitalmanagementsystem.AddLabTestReports;

public class LabModelClass {
    int id;
    String name,part,cost,phone;

    public LabModelClass(int id, String name, String part, String cost, String phone) {
        this.id = id;
        this.name = name;
        this.part = part;
        this.cost = cost;
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

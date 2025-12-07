package com.example.hospitalmanagementsystem.MedicineReturnsPolicy;

public class MedicineReturnModelClass {
    int id;
    String name,condition,phone;

    public MedicineReturnModelClass(int id, String name, String condition, String phone) {
        this.id = id;
        this.name = name;
        this.condition = condition;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

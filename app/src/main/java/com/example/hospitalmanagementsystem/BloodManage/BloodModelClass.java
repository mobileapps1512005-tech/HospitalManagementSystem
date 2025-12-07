package com.example.hospitalmanagementsystem.BloodManage;

public class BloodModelClass {
    int id;
    String hospital,blood,quantity,phone;

    public BloodModelClass(int id, String hospital, String blood, String quantity, String phone) {
        this.id = id;
        this.hospital = hospital;
        this.blood = blood;
        this.quantity = quantity;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

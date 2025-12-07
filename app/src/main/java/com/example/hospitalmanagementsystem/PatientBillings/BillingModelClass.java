package com.example.hospitalmanagementsystem.PatientBillings;

public class BillingModelClass {
    int id;
    String hospital,name,email,phone,typeBill,cost,typeDiscount,date,time;

    public BillingModelClass(int id, String hospital, String name, String email, String phone, String typeBill, String cost, String typeDiscount, String date, String time) {
        this.id = id;
        this.hospital = hospital;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.typeBill = typeBill;
        this.cost = cost;
        this.typeDiscount = typeDiscount;
        this.date = date;
        this.time = time;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTypeBill() {
        return typeBill;
    }

    public void setTypeBill(String typeBill) {
        this.typeBill = typeBill;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTypeDiscount() {
        return typeDiscount;
    }

    public void setTypeDiscount(String typeDiscount) {
        this.typeDiscount = typeDiscount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

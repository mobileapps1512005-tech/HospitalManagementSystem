package com.example.hospitalmanagementsystem.MedicineOrderTaskManage;

public class MedicineModelClass {
    int id;
    String  name,email,Phone,Location,deliveryLocation,medicineName,order,requiredDate,requiredTime;

    public MedicineModelClass(int id, String name, String email, String phone, String location, String deliveryLocation, String medicineName, String order, String requiredDate, String requiredTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        Phone = phone;
        Location = location;
        this.deliveryLocation = deliveryLocation;
        this.medicineName = medicineName;
        this.order = order;
        this.requiredDate = requiredDate;
        this.requiredTime = requiredTime;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(String requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getRequiredTime() {
        return requiredTime;
    }

    public void setRequiredTime(String requiredTime) {
        this.requiredTime = requiredTime;
    }
}

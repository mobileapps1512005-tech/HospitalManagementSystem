package com.example.hospitalmanagementsystem.PharmacyManageTask;

public class PharmacyModelClass {
    int id;
    String name,email,phone,location,pharmacyName,qualification,EmergencyService,discount,returns,EmergencyTime,home;

    public PharmacyModelClass(int id, String name, String email, String phone, String location, String pharmacyName, String qualification, String emergencyService, String discount, String returns, String emergencyTime, String home) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.pharmacyName = pharmacyName;
        this.qualification = qualification;
        EmergencyService = emergencyService;
        this.discount = discount;
        this.returns = returns;
        EmergencyTime = emergencyTime;
        this.home = home;
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
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getEmergencyService() {
        return EmergencyService;
    }

    public void setEmergencyService(String emergencyService) {
        EmergencyService = emergencyService;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getReturns() {
        return returns;
    }

    public void setReturns(String returns) {
        this.returns = returns;
    }

    public String getEmergencyTime() {
        return EmergencyTime;
    }

    public void setEmergencyTime(String emergencyTime) {
        EmergencyTime = emergencyTime;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }
}

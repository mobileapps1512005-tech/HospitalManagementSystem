package com.example.hospitalmanagementsystem.HospitalManageTask;

public class HospitalModelClass {
    int id;
    String name,year,email,location,phone;

    public HospitalModelClass(int id, String name, String year, String email, String location, String phone) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.email = email;
        this.location = location;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

package com.example.hospitalmanagementsystem.GrievanceActivity;

public class GrievanceModelClass {
    int id;
    String hospital,name,phone,staff,grievance;

    public GrievanceModelClass(int id, String hospital, String name, String phone, String staff, String grievance) {
        this.id = id;
        this.hospital = hospital;
        this.name = name;
        this.phone = phone;
        this.staff = staff;
        this.grievance = grievance;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getGrievance() {
        return grievance;
    }

    public void setGrievance(String grievance) {
        this.grievance = grievance;
    }
}

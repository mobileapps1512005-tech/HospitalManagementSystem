package com.example.hospitalmanagementsystem.DoctorManageTask;

public class PatientModelClassAppointment {
    int id;
    String name,email,day,time,phone;

    public PatientModelClassAppointment(int id, String name, String email, String day, String time, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.day = day;
        this.time = time;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

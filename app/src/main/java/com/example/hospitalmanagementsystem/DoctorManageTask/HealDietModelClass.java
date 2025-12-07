package com.example.hospitalmanagementsystem.DoctorManageTask;

public class HealDietModelClass {
    int id;
    String name,age,morning,lunch,dinner,doctor,phone;

    public HealDietModelClass(int id, String name, String age, String morning, String lunch, String dinner, String doctor, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.morning = morning;
        this.lunch = lunch;
        this.dinner = dinner;
        this.doctor = doctor;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

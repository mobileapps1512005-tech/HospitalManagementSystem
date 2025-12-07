package com.example.hospitalmanagementsystem.DoctorManageTask;

public class DoctorCallModelClass {
    int id;
    String name,email,qualification,experience,specialist,availableDay,availableTime,phone;

    public DoctorCallModelClass(int id, String name, String email, String qualification, String experience, String specialist, String availableDay, String availableTime, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.qualification = qualification;
        this.experience = experience;
        this.specialist = specialist;
        this.availableDay = availableDay;
        this.availableTime = availableTime;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getAvailableDay() {
        return availableDay;
    }

    public void setAvailableDay(String availableDay) {
        this.availableDay = availableDay;
    }

    public String getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(String availableTime) {
        this.availableTime = availableTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

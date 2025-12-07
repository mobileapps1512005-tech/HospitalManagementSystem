package com.example.hospitalmanagementsystem.NurseManageTask;

public class NurseModelClass {
    int id;
    String name,email,Qualification,Experience,Gender,Location,Phone;

    public NurseModelClass(int id, String name, String email, String qualification, String experience, String gender, String location, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        Qualification = qualification;
        Experience = experience;
        Gender = gender;
        Location = location;
        Phone = phone;
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
        return Qualification;
    }

    public void setQualification(String qualification) {
        Qualification = qualification;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String experience) {
        Experience = experience;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}


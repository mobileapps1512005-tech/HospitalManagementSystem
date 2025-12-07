package com.example.hospitalmanagementsystem.DoctorManageTask;

public class MedSuggestModelClass {
    int id;
    String hospital,doctor,phone,name,treatment,medicine;

    public MedSuggestModelClass(int id, String hospital, String doctor, String phone, String name, String treatment, String medicine) {
        this.id = id;
        this.hospital = hospital;
        this.doctor = doctor;
        this.phone = phone;
        this.name = name;
        this.treatment = treatment;
        this.medicine = medicine;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }
}

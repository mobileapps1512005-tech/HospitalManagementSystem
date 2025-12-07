package com.example.hospitalmanagementsystem.AmbulanceManageTask;

public class AmbulanceModelClass {
    int id;
    String name,email,Experience,license,DriverContact,VehicleNo,HospitalName,HospitalNo,BaseFare,
            PerKmCost,EmergencyCost,WithDoctor,WithoutDoctor,WithAC,WithoutAC,AmbulanceAllPackage;

    public AmbulanceModelClass(int id, String name, String email, String experience, String license, String driverContact, String vehicleNo, String hospitalName, String hospitalNo, String baseFare, String perKmCost, String emergencyCost, String withDoctor, String withoutDoctor, String withAC, String withoutAC, String ambulanceAllPackage) {
        this.id = id;
        this.name = name;
        this.email = email;
        Experience = experience;
        this.license = license;
        DriverContact = driverContact;
        VehicleNo = vehicleNo;
        HospitalName = hospitalName;
        HospitalNo = hospitalNo;
        BaseFare = baseFare;
        PerKmCost = perKmCost;
        EmergencyCost = emergencyCost;
        WithDoctor = withDoctor;
        WithoutDoctor = withoutDoctor;
        WithAC = withAC;
        WithoutAC = withoutAC;
        AmbulanceAllPackage = ambulanceAllPackage;
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

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String experience) {
        Experience = experience;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getDriverContact() {
        return DriverContact;
    }

    public void setDriverContact(String driverContact) {
        DriverContact = driverContact;
    }

    public String getVehicleNo() {
        return VehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        VehicleNo = vehicleNo;
    }

    public String getHospitalName() {
        return HospitalName;
    }

    public void setHospitalName(String hospitalName) {
        HospitalName = hospitalName;
    }

    public String getHospitalNo() {
        return HospitalNo;
    }

    public void setHospitalNo(String hospitalNo) {
        HospitalNo = hospitalNo;
    }

    public String getBaseFare() {
        return BaseFare;
    }

    public void setBaseFare(String baseFare) {
        BaseFare = baseFare;
    }

    public String getPerKmCost() {
        return PerKmCost;
    }

    public void setPerKmCost(String perKmCost) {
        PerKmCost = perKmCost;
    }

    public String getEmergencyCost() {
        return EmergencyCost;
    }

    public void setEmergencyCost(String emergencyCost) {
        EmergencyCost = emergencyCost;
    }

    public String getWithDoctor() {
        return WithDoctor;
    }

    public void setWithDoctor(String withDoctor) {
        WithDoctor = withDoctor;
    }

    public String getWithoutDoctor() {
        return WithoutDoctor;
    }

    public void setWithoutDoctor(String withoutDoctor) {
        WithoutDoctor = withoutDoctor;
    }

    public String getWithAC() {
        return WithAC;
    }

    public void setWithAC(String withAC) {
        WithAC = withAC;
    }

    public String getWithoutAC() {
        return WithoutAC;
    }

    public void setWithoutAC(String withoutAC) {
        WithoutAC = withoutAC;
    }

    public String getAmbulanceAllPackage() {
        return AmbulanceAllPackage;
    }

    public void setAmbulanceAllPackage(String ambulanceAllPackage) {
        AmbulanceAllPackage = ambulanceAllPackage;
    }
}

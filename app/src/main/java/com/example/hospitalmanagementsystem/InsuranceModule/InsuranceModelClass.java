package com.example.hospitalmanagementsystem.InsuranceModule;

public class InsuranceModelClass {
    int id;
    String name,dob,gender,phone,email,aadhar,policyNumber,selectCompany,selectHospital,date,time,nominee,hospital;

    public InsuranceModelClass(int id, String name, String dob, String gender, String phone, String email, String aadhar, String policyNumber, String selectCompany, String selectHospital, String date, String time, String nominee, String hospital) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.aadhar = aadhar;
        this.policyNumber = policyNumber;
        this.selectCompany = selectCompany;
        this.selectHospital = selectHospital;
        this.date = date;
        this.time = time;
        this.nominee = nominee;
        this.hospital = hospital;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getSelectCompany() {
        return selectCompany;
    }

    public void setSelectCompany(String selectCompany) {
        this.selectCompany = selectCompany;
    }

    public String getSelectHospital() {
        return selectHospital;
    }

    public void setSelectHospital(String selectHospital) {
        this.selectHospital = selectHospital;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}

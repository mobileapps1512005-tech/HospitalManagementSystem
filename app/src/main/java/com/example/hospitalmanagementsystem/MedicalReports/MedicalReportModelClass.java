package com.example.hospitalmanagementsystem.MedicalReports;

public class MedicalReportModelClass {
    int id;
    String name,part,date,time,condition,describe,phone;

    public MedicalReportModelClass(int id, String name, String part, String date, String time, String condition, String describe, String phone) {
        this.id = id;
        this.name = name;
        this.part = part;
        this.date = date;
        this.time = time;
        this.condition = condition;
        this.describe = describe;
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

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

package com.example.hospitalmanagementsystem.AddLabTestReports;

public class ReportModelClass {
    String name,phone,condition;

    public ReportModelClass(String name, String phone, String condition) {
        this.name = name;
        this.phone = phone;
        this.condition = condition;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}

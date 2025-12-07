package com.example.hospitalmanagementsystem.AboutManage;

import android.widget.ImageView;

public class AboutModelClass {
    int img;
    String name,description;

    public AboutModelClass(int img, String name, String description) {
        this.img = img;
        this.name = name;
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

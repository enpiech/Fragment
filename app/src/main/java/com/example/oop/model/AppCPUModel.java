package com.example.oop.model;

import android.graphics.drawable.Drawable;

public class AppCPUModel extends ModelAppInfo{
    //Percent cpu usage
    private String percent;

    public AppCPUModel(Drawable icon, String name, String packageName, String percent) {
        super(icon, name, packageName);
        this.percent = percent;
    }

    public AppCPUModel() {
        super();
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}

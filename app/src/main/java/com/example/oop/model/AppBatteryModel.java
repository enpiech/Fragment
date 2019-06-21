package com.example.oop.model;

import android.graphics.drawable.Drawable;

public class AppBatteryModel extends ModelAppInfo{
    //Percent battery used
    private String percent;

    public AppBatteryModel(Drawable icon, String name, String packageName, String percent) {
        super(icon, name, packageName);
        this.percent = percent;
    }

    public AppBatteryModel() {
        super();
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}

package com.example.oop.model;

import android.graphics.drawable.Drawable;

public class ModelAppInfo {
    private Drawable icon;
    private String name, packageName;

    public ModelAppInfo(Drawable icon, String name, String packageName) {
        this.icon = icon;
        this.name = name;
        this.packageName = packageName;
    }

    public ModelAppInfo() {
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}

package com.example.oop.model;

import android.graphics.drawable.Drawable;

public class AppDetailModel extends ModelAppInfo {
    private String version;

    public AppDetailModel(Drawable icon, String name, String packageName, String version) {
        super(icon, name, packageName);
        this.version = version;
    }

    public AppDetailModel() {
        super();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

package com.example.selfcare.model;

import android.graphics.drawable.Drawable;

public class ListApp {
    Drawable icon;
    String name, oriname, version;

    public ListApp() {
    }

    public ListApp(Drawable icon, String name, String oriname, String version) {
        this.icon = icon;
        this.name = name;
        this.oriname = oriname;
        this.version = version;
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

    public String getOriname() {
        return oriname;
    }

    public void setOriname(String oriname) {
        this.oriname = oriname;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

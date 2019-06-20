package com.example.selfcare.model;

public class SelfcareModel {
    int icon, click;
    String title, dec;

    public SelfcareModel() {
    }

    public SelfcareModel(int icon, int click, String title, String dec) {
        this.icon = icon;
        this.click = click;
        this.title = title;
        this.dec = dec;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }
}

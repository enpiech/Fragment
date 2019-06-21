package com.example.oop.model;

public class ModelMain {
    private int icon, arrow;
    private String title, dec;

    public ModelMain() {
    }

    public ModelMain(int icon, int arrow, String title, String dec) {
        this.icon = icon;
        this.arrow = arrow;
        this.title = title;
        this.dec = dec;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getArrow() {
        return arrow;
    }

    public void setArrow(int arrow) {
        this.arrow = arrow;
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

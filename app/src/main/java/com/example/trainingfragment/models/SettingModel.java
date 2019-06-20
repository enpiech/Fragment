package com.example.trainingfragment.models;

public class SettingModel {
    private final int mImageIcon;
    private final String mName;
    private final String mDescription;

    public SettingModel(int imageIcon, String name, String description) {
        this.mImageIcon = imageIcon;
        this.mName = name;
        this.mDescription = description;
    }

    public int getImageIcon() {
        return mImageIcon;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }
}

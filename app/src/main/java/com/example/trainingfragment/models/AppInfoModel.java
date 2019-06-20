package com.example.trainingfragment.models;

import android.graphics.drawable.Drawable;

public class AppInfoModel {
    private final Drawable mAppIcon;
    private final String mAppName;
    private final String mAppPackageName;
    private String mVersion;
    private String mAverageCPUUsagePercent;
    private String mAverageBatteryUsagePercent;
    private String mLastTimeUsage;
    private String mLastLifeTime;

    public AppInfoModel(Drawable mAppIcon, String mAppName, String mAppPackageName) {
        this.mAppIcon = mAppIcon;
        this.mAppName = mAppName;
        this.mAppPackageName = mAppPackageName;
        this.mVersion = "";
        this.mAverageCPUUsagePercent = "";
        this.mAverageBatteryUsagePercent = "";
        this.mLastTimeUsage = "";
        this.mLastLifeTime = "";
    }

    public Drawable getAppIcon() {
        return mAppIcon;
    }

    public String getAppName() {
        return mAppName;
    }

    public String getAppPackageName() {
        return mAppPackageName;
    }

    public String getVersion() {
        return mVersion;
    }

    public void setVersion(String mVersion) {
        this.mVersion = mVersion;
    }

    public String getAverageCPUUsagePercent() {
        return mAverageCPUUsagePercent;
    }

    public void setAverageCPUUsagePercent(String mAverageCPUUsagePercent) {
        this.mAverageCPUUsagePercent = mAverageCPUUsagePercent;
    }

    public String getAverageBatteryUsagePercent() {
        return mAverageBatteryUsagePercent;
    }

    public void setAverageBatteryUsagePercent(String mAverageBatteryUsagePercent) {
        this.mAverageBatteryUsagePercent = mAverageBatteryUsagePercent;
    }

    public String getLastTimeUsage() {
        return mLastTimeUsage;
    }

    public void setLastTimeUsage(String mLastTimeUsage) {
        this.mLastTimeUsage = mLastTimeUsage;
    }

    public String getLastLifeTime() {
        return mLastLifeTime;
    }

    public void setLastLifeTime(String mLastLifeTime) {
        this.mLastLifeTime = mLastLifeTime;
    }
}

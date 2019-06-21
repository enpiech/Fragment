package com.example.oop.model;

import android.graphics.drawable.Drawable;

public class AppUsageModel extends ModelAppInfo {
    private String lastTimeUsed;
    private String timeused;

    public AppUsageModel(Drawable icon, String name, String packageName, String lastTimeUsed, String timeused) {
        super(icon, name, packageName);
        this.lastTimeUsed = lastTimeUsed;
        this.timeused = timeused;
    }

    public AppUsageModel() {
        super();
    }

    public String getLastTimeUsed() {
        return lastTimeUsed;
    }

    public void setLastTimeUsed(String lastTimeUsed) {
        this.lastTimeUsed = lastTimeUsed;
    }

    public String getTimeused() {
        return timeused;
    }

    public void setTimeused(String timeused) {
        this.timeused = timeused;
    }
}

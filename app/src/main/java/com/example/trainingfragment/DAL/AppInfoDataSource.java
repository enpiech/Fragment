package com.example.trainingfragment.DAL;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.example.trainingfragment.models.AppInfoModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppInfoDataSource {
    public static final List<AppInfoModel> ITEMS = new ArrayList<>();

    public static final Map<String, AppInfoModel> ITEM_MAP = new HashMap<String, AppInfoModel>();

    public static void getAppList(Context context) {
        PackageManager pm = context.getPackageManager();
        List<PackageInfo> installedPackages = pm.getInstalledPackages(0);
        for (PackageInfo packageInfo : installedPackages) {
            AppInfoModel appInfo;

            String appName = packageInfo.applicationInfo.loadLabel(pm).toString();
            String packageName = packageInfo.packageName;
            Drawable appIcon = null;
            try {
                appIcon = pm.getApplicationIcon(packageName);
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
            String versionName = packageInfo.versionName;
            if (appIcon != null) {
                appInfo = new AppInfoModel(appIcon, appName, packageName);
                appInfo.setVersion(versionName);
                addItem(appInfo);
            }
        }
    }

    private static void addItem(AppInfoModel item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getAppPackageName(), item);
    }

}

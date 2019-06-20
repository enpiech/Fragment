package com.example.trainingfragment.DAL;

import com.example.trainingfragment.R;
import com.example.trainingfragment.models.SettingModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingContent {
    public static final List<SettingModel> ITEMS = new ArrayList<>();

    public static final Map<String, SettingModel> ITEM_MAP = new HashMap<String, SettingModel>();

    static {
        SettingModel basicInfo = new SettingModel(R.drawable.ic_phone_android,
                "Basic Information",
                "Get about phone information");
        addItem(basicInfo);

        SettingModel deviceInfo = new SettingModel(R.drawable.ic_perm_device_information,
                "Device Information",
                "Get device phone information");
        addItem(deviceInfo);

        SettingModel settingInfo = new SettingModel(R.drawable.ic_phonelink_setup,
                "Setting Information",
                "Get setting phone information");
        addItem(settingInfo);

        SettingModel appInfo = new SettingModel(R.drawable.ic_android,
                "App Information",
                "Get apps information");
        addItem(appInfo);
    }

    private static void addItem(SettingModel item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getName(), item);
    }
}

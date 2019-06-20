package com.example.selfcare.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.selfcare.fragment.AppInfo;
import com.example.selfcare.fragment.BatteryInfo;
import com.example.selfcare.fragment.CpuInfo;
import com.example.selfcare.fragment.UsageInfo;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private String listTab[] = {"LIST", "CPU", "USAGE", "BATTERY"};

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new AppInfo();
                break;
            case 1:
                fragment = new CpuInfo();
                break;
            case 2:
                fragment = new UsageInfo();
                break;
            case 3:
                fragment = new BatteryInfo();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTab[position];
    }
}

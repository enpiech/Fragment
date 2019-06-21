package com.example.oop.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.oop.fragment.AppListFragment;
import com.example.oop.fragment.BatteryFragment;
import com.example.oop.fragment.CPUFragment;
import com.example.oop.fragment.UsageFragment;

public class AdapterFragment extends FragmentStateAdapter {
    private String[] listTab = {"LIST", "CPU", "USAGE", "BATTERY"};
    public AdapterFragment(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new AppListFragment();
            case 1:
                return new CPUFragment();
            case 2:
                return new UsageFragment();
            case 3:
                return new BatteryFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return listTab.length;
    }

}

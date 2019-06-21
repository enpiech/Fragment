package com.example.oop.controller;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.oop.R;
import com.example.oop.adapter.AdapterFragment;
import com.example.oop.fragment.AppListFragment;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class AppInfoActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    AdapterFragment adapterFragment;
    private ArrayList<Fragment> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);

        setControl();
        setEvent();
    }

    private void setEvent() {
        data.add(new AppListFragment());
        adapterFragment = new AdapterFragment(getSupportFragmentManager(), getLifecycle());
        viewPager2.setOrientation(viewPager2.ORIENTATION_HORIZONTAL);
        viewPager2.setAdapter(adapterFragment);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, true, new TabLayoutMediator.OnConfigureTabCallback() {
            @Override
            public void onConfigureTab(@NotNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("LIST");
                        break;
                    case 1:
                        tab.setText("CPU");
                        break;
                    case 2:
                        tab.setText("USAGE");
                        break;
                    case 3:
                        tab.setText("BATTERY");
                        break;
                }
            }
        });
        tabLayoutMediator.attach();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("App Information");
    }

    private void setControl() {
        viewPager2 = (ViewPager2) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
    }
}

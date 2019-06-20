package com.example.trainingfragment;

import android.view.Menu;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.example.trainingfragment.DAL.AppInfoDataSource;
import com.example.trainingfragment.RecycleViewAdapter.Listener.OnListFragmentInteractionListener;
import com.example.trainingfragment.ViewPagerAdapter.ViewPagerAdapter;
import com.example.trainingfragment.dummy.DummyContent.DummyItem;
import com.example.trainingfragment.fragments.AppInfoFragment;
import com.example.trainingfragment.fragments.BatteryUsageFragment;
import com.example.trainingfragment.fragments.CpuUsageFragment;
import com.example.trainingfragment.fragments.TimeUsageFragment;
import com.example.trainingfragment.models.AppInfoModel;
import com.google.android.material.tabs.TabLayout;

public class AppInformationActivity extends AppCompatActivity implements
        OnListFragmentInteractionListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_information);

        loadView();
        loadData();

        setupViewPager();
        tabLayout.setupWithViewPager(viewPager);
    }



    private void loadView() {
        tabLayout = findViewById(R.id.tabs_layout);
        viewPager = findViewById(R.id.view_pager);
    }

    private void loadData() {
        AppInfoDataSource.getAppList(this);
    }
    private void setupViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new AppInfoFragment(), "LIST");
        viewPagerAdapter.addFragment(new CpuUsageFragment(), "CPU");
        viewPagerAdapter.addFragment(new TimeUsageFragment(), "USAGE");
        viewPagerAdapter.addFragment(new BatteryUsageFragment(), "BATTERY");
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onListFragmentInteraction(AppInfoModel item) {

    }
}

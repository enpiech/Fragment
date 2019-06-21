package com.example.trainingfragment;

import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.trainingfragment.DAL.AppInfoDataSource;
import com.example.trainingfragment.RecycleViewAdapter.Listener.OnItemClickListener;
import com.example.trainingfragment.RecycleViewAdapter.MySettingRecyclerViewAdapter;
import com.example.trainingfragment.DAL.SettingContent;
import com.example.trainingfragment.models.SettingModel;

public class SettingActivity extends AppCompatActivity implements OnItemClickListener {
    private RecyclerView mListSettings;
    private ProgressBar mProgressBar;

    private MySettingRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        loadView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mListSettings.setVisibility(View.VISIBLE);
    }

    private void loadView() {
        mListSettings = findViewById(R.id.lst_setting);
        adapter = new MySettingRecyclerViewAdapter(SettingContent.ITEMS, this);
        mListSettings.setLayoutManager(new LinearLayoutManager(this));
        mListSettings.setAdapter(adapter);

        mProgressBar = findViewById(R.id.progress_circular);
    }

    private void loadData() {
        AppInfoDataSource.getAppList(this);
    }

    @Override
    public void onItemClickListener(SettingModel item) {
        mListSettings.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);

        Intent intent = null;
        switch (item.getName()) {
            case "Basic Information":
                intent = new Intent(SettingActivity.this, BasicInformationActivity.class);
                break;
            case "Device Information":
                intent = new Intent(SettingActivity.this, DeviceInformation.class);
                break;
            case "Setting Information":
                intent = new Intent(SettingActivity.this, SettingInformationActivity.class);
                break;
            case "App Information":
                intent = new Intent(SettingActivity.this, AppInformationActivity.class);
                break;
        }
        if (intent != null){
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        }
    }
}

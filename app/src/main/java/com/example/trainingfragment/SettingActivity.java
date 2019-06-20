package com.example.trainingfragment;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.trainingfragment.RecycleViewAdapter.Listener.OnItemClickListener;
import com.example.trainingfragment.RecycleViewAdapter.MySettingRecyclerViewAdapter;
import com.example.trainingfragment.DAL.SettingContent;
import com.example.trainingfragment.models.SettingModel;

public class SettingActivity extends AppCompatActivity implements OnItemClickListener {
    private RecyclerView lstSetting;

    private MySettingRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        loadView();
    }

    private void loadView() {
        lstSetting = findViewById(R.id.lst_setting);
        adapter = new MySettingRecyclerViewAdapter(SettingContent.ITEMS, this);
        lstSetting.setLayoutManager(new LinearLayoutManager(this));
        lstSetting.setAdapter(adapter);
    }


    @Override
    public void onItemClickListener(SettingModel item) {
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

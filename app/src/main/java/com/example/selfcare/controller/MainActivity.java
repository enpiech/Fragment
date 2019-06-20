package com.example.selfcare.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.selfcare.R;
import com.example.selfcare.adapter.SelfcareAdapter;
import com.example.selfcare.model.SelfcareModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView1;
    SelfcareAdapter adapter = null;
    ArrayList<SelfcareModel> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        KhoiTao();
        adapter = new SelfcareAdapter(this, R.layout.listview_item_main, data);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (data.get(i).getTitle()) {
                    case "Device Information":
                        startActivity(new Intent(MainActivity.this, DeviceInfo.class));
                        break;
                    case "App Information":
                        startActivity(new Intent(MainActivity.this, AppInfo_Main.class));
                        break;
                    default:
                        Toast.makeText(MainActivity.this, data.get(i).getTitle(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setControl() {
        listView1 = (ListView) findViewById(R.id.listView_main);
    }

    void KhoiTao() {
        data.add(new SelfcareModel(R.drawable.ic_phone_android, R.drawable.ic_keyboard_arrow_right, "Basic Information", "Get about phone information"));
        data.add(new SelfcareModel(R.drawable.ic_perm_device_information, R.drawable.ic_keyboard_arrow_right, "Device Information", "Get device phone information"));
        data.add(new SelfcareModel(R.drawable.ic_phonelink_setup, R.drawable.ic_keyboard_arrow_right, "Setting Information", "Get setting phone information"));
        data.add(new SelfcareModel(R.drawable.ic_android, R.drawable.ic_keyboard_arrow_right, "App Information", "Get app phone information"));
    }
}

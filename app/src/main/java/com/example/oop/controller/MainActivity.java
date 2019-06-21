package com.example.oop.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.oop.R;
import com.example.oop.adapter.AdapterMain;
import com.example.oop.model.ModelMain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    AdapterMain mAdapterMain;
    ArrayList<ModelMain> data = new ArrayList<>();
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setEvent();
    }

    @SuppressLint("WrongConstant")
    private void setEvent() {
        createItem();
        mAdapterMain = new AdapterMain(data, MainActivity.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapterMain);
        mAdapterMain.setOnItemClickedListener(new AdapterMain.OnItemClickedListener() {
            @Override
            public void onItemClick(String name) {
                switch (name) {
                    case "App Infomation":
                        progressBar.setVisibility(View.VISIBLE);
                        startActivity(new Intent(MainActivity.this, AppInfoActivity.class));
                        break;
                    default:
                        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setControl() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView_main);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
    }

    private void createItem() {
        data.add(new ModelMain(R.drawable.ic_phone_android, R.drawable.ic_keyboard_arrow_right, "Basic Infomation", "Get about phone information"));
        data.add(new ModelMain(R.drawable.ic_perm_device_information, R.drawable.ic_keyboard_arrow_right, "Device Infomation", "Get device phone information"));
        data.add(new ModelMain(R.drawable.ic_phonelink_setup, R.drawable.ic_keyboard_arrow_right, "Setting Infomation", "Get setting phone information"));
        data.add(new ModelMain(R.drawable.ic_android, R.drawable.ic_keyboard_arrow_right, "App Infomation", "Get apps phone information"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.INVISIBLE);
    }
}

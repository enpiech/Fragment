package com.example.selfcare.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.selfcare.R;

public class DeviceInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_info);

        setTitle("Device Information");
        Button button = (Button) findViewById(R.id.getSystemInfo);
        final TextView textView = (TextView) findViewById(R.id.info_display);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(
                        "SERIAL: " + Build.SERIAL + "\n" +
                                "MODEL: " + Build.MODEL + "\n" +
                                "ID: " + Build.ID + "\n" +
                                "Manufacture: " + Build.MANUFACTURER + "\n" +
                                "Brand: " + Build.BRAND + "\n" +
                                "Type: " + Build.TYPE + "\n" +
                                "User: " + Build.USER + "\n" +
                                "BASE: " + Build.VERSION_CODES.BASE + "\n" +
                                "INCREMENTAL: " + Build.VERSION.INCREMENTAL + "\n" +
                                "SDK:  " + Build.VERSION.SDK + "\n" +
                                "BOARD: " + Build.BOARD + "\n" +
                                "BRAND: " + Build.BRAND + "\n" +
                                "HOST: " + Build.HOST + "\n" +
                                "FINGERPRINT: " + Build.FINGERPRINT + "\n" +
                                "Version Code: " + Build.VERSION.RELEASE
                );
            }
        });
    }
}

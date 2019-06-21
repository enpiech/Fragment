package com.example.oop.fragment;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oop.R;
import com.example.oop.adapter.AppInfoAdapter;
import com.example.oop.adapter.CPUAdapter;
import com.example.oop.model.AppCPUModel;
import com.example.oop.model.ModelAppInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static android.content.Context.ACTIVITY_SERVICE;

public class CPUFragment extends Fragment {
    RecyclerView recyclerView;
    CPUAdapter adapter = null;
    ArrayList<AppCPUModel> data = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cpu, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.listAppRecyclerView);
        setEvent();
        return view;
    }

    @SuppressLint("WrongConstant")
    private void setEvent() {
        adapter = new CPUAdapter(getContext(),data);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        PackageManager pm = getActivity().getPackageManager();
        List<ApplicationInfo> installedApps = pm.getInstalledApplications(0);
        for (ApplicationInfo aInfo : installedApps) {

            if ((aInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                // System apps
            } else {
                // Users apps
                AppCPUModel listApp = new AppCPUModel();
                listApp.setName(aInfo.loadLabel(pm).toString());
                listApp.setPackageName(aInfo.packageName);
                try {
                    String pkg = aInfo.packageName;//your package name
                    Drawable icon = getActivity().getPackageManager().getApplicationIcon(pkg);
                    listApp.setIcon(icon);
                } catch (PackageManager.NameNotFoundException ne) {

                }
                try {
                    PackageInfo info = pm.getPackageInfo(aInfo.packageName, 0);
                    listApp.setPercent(info.versionName);
                    data.add(listApp);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e("ERROR", "we could not get the user's apps");
                }
                adapter.notifyDataSetChanged();
            }
        }
    }
}

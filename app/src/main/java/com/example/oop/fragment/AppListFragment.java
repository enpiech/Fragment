package com.example.oop.fragment;


import android.annotation.SuppressLint;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oop.R;
import com.example.oop.adapter.AppInfoAdapter;
import com.example.oop.model.AppDetailModel;
import com.example.oop.model.ModelAppInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppListFragment extends Fragment {
    RecyclerView recyclerView;
    AppInfoAdapter adapter = null;
    ArrayList<AppDetailModel> data = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_app_list, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.listAppRecyclerView);
        setEvent();
        return view;
    }

    @SuppressLint("WrongConstant")
    private void setEvent() {
        adapter = new AppInfoAdapter(getContext(), data);

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
                AppDetailModel listApp = new AppDetailModel();
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
                    listApp.setVersion(info.versionName);
                    data.add(listApp);
                    Collections.sort(data, new Comparator<AppDetailModel>() {
                        public int compare(AppDetailModel o1, AppDetailModel o2) {
                            return o1.getName().compareTo(o2.getName());
                        }
                    });
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e("ERROR", "we could not get the user's apps");
                }
                adapter.notifyDataSetChanged();
            }
        }
    }
}

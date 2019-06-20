package com.example.selfcare.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.selfcare.R;
import com.example.selfcare.adapter.ListAppAdapter;
import com.example.selfcare.model.ListApp;

import java.util.ArrayList;
import java.util.List;

public class AppInfo extends Fragment {
    ListView listView1;
    ArrayList<ListApp> data = new ArrayList<>();
    ListAppAdapter adapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_app_info, null);
        listView1 = (ListView) view.findViewById(R.id.listView_app);
        setEvent();
        return view;
    }

    private void setEvent() {

        adapter = new ListAppAdapter(getContext(), R.layout.listview_item_row_white, data);
        listView1.setAdapter(adapter);


        PackageManager pm = getActivity().getPackageManager();
        List<ApplicationInfo> installedApps = pm.getInstalledApplications(0);
        for (ApplicationInfo aInfo : installedApps) {

            if ((aInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                // System apps
            } else {
                // Users apps
                ListApp listApp = new ListApp();
                listApp.setName(aInfo.loadLabel(pm).toString());
                listApp.setOriname(aInfo.packageName);
                try {
                    String pkg = aInfo.packageName;//your package name
                    Drawable icon = getActivity().getPackageManager().getApplicationIcon(pkg);
                    listApp.setIcon(icon);
                } catch (PackageManager.NameNotFoundException ne) {

                }
                try {
                    PackageInfo info = pm.getPackageInfo(aInfo.packageName, 0);
                    listApp.setVersion(info.versionName.toString());
                    data.add(listApp);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e("ERROR", "we could not get the user's apps");
                }
                adapter.notifyDataSetChanged();
            }
        }
    }
}

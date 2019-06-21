package com.example.trainingfragment.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.trainingfragment.DAL.AppInfoDataSource;
import com.example.trainingfragment.ListAdapter.BatteryUsageAdapter;
import com.example.trainingfragment.R;

public class BatteryUsageFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon
     * screen orientation changes).
     */
    public BatteryUsageFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static BatteryUsageFragment newInstance(int columnCount) {
        BatteryUsageFragment fragment = new BatteryUsageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_battery_usage_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            BatteryUsageAdapter adapter = new BatteryUsageAdapter(new OnClickListener() {
                @Override
                public void onClick(final View view) {

                }
            });
            adapter.submitList(AppInfoDataSource.ITEMS);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }
}

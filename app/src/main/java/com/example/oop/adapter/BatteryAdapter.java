package com.example.oop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.oop.R;
import com.example.oop.model.AppBatteryModel;
import com.example.oop.model.ModelAppInfo;


import java.util.ArrayList;

public class BatteryAdapter extends BaseAdapter {
    private ArrayList<AppBatteryModel> data = null;

    public BatteryAdapter(Context mContext, ArrayList<AppBatteryModel> data) {
        super(mContext);
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.appinfo_battery_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    public class ViewHolder extends BaseAdapter.RecyclerViewHolder {
        TextView txtPercent;
        AppBatteryModel appBatteryModel;

        public ViewHolder(View itemView) {
            super(itemView);
            txtPercent = (TextView) itemView.findViewById(R.id.txtVersion);
        }

        @Override
        public void bind(ModelAppInfo modelAppInfo) {
            super.bind(modelAppInfo);
            appBatteryModel = (AppBatteryModel) modelAppInfo;
            txtPercent.setText(appBatteryModel.getPercent());
        }
    }
}

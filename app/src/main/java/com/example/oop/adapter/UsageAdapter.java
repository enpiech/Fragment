package com.example.oop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oop.R;
import com.example.oop.model.AppBatteryModel;
import com.example.oop.model.AppUsageModel;
import com.example.oop.model.ModelAppInfo;

import java.util.ArrayList;

public class UsageAdapter extends BaseAdapter{
    private ArrayList<AppUsageModel> data = null;

    public UsageAdapter(Context mContext, ArrayList<AppUsageModel> data) {
        super(mContext);
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.appinfo_usage_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends BaseAdapter.RecyclerViewHolder{
        TextView txtLastTimeUsed;
        TextView txtTimeUsed;
        AppUsageModel appUsageModel;
        public ViewHolder(View itemView) {
            super(itemView);
            txtLastTimeUsed = (TextView)itemView.findViewById(R.id.txtVersion);
            txtTimeUsed = (TextView)itemView.findViewById(R.id.txtTimeUsed);
        }

        @Override
        public void bind(ModelAppInfo modelAppInfo) {
            super.bind(modelAppInfo);
            appUsageModel = (AppUsageModel)modelAppInfo;
            txtLastTimeUsed.setText(appUsageModel.getLastTimeUsed());
            txtTimeUsed.setText(appUsageModel.getTimeused());
        }
    }
}

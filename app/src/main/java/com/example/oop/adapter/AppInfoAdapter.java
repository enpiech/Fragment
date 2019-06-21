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
import com.example.oop.model.AppDetailModel;
import com.example.oop.model.ModelAppInfo;

import java.util.ArrayList;

public class AppInfoAdapter extends BaseAdapter {
    private ArrayList<AppDetailModel> data = null;

    public AppInfoAdapter(Context mContext, ArrayList<AppDetailModel> data) {
        super(mContext);
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.appinfo_item_row, parent, false);
        if(viewType != 0)
        {
            view.setBackgroundColor(view.getResources().getColor(R.color.colorItem));
        }
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
        TextView txtVersion;
        AppDetailModel appDetailModel;
        public ViewHolder(View itemView) {
            super(itemView);
            txtVersion = (TextView)itemView.findViewById(R.id.txtVersion);
        }

        @Override
        public void bind(ModelAppInfo modelAppInfo) {
            super.bind(modelAppInfo);
            appDetailModel = (AppDetailModel)modelAppInfo;
            txtVersion.setText(appDetailModel.getVersion());
        }
    }
}

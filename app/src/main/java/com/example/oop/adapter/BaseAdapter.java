package com.example.oop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oop.R;
import com.example.oop.model.ModelAppInfo;

public abstract class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.RecyclerViewHolder> {
    private Context mContext;

    public BaseAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public abstract RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    @Override
    public abstract void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position);

    @Override
    public abstract int getItemCount();


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtPackage;
        ImageView imgIcon;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtPackage = (TextView) itemView.findViewById(R.id.txtPackage);
            imgIcon = (ImageView) itemView.findViewById(R.id.imgListIcon);
        }

        public void bind(ModelAppInfo modelAppInfo) {
            txtName.setText(modelAppInfo.getName());
            txtPackage.setText(modelAppInfo.getPackageName());
            imgIcon.setImageDrawable(modelAppInfo.getIcon());
        }
    }
}

package com.example.oop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.oop.R;
import com.example.oop.controller.AppInfoActivity;
import com.example.oop.model.ModelMain;

import java.util.ArrayList;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.RecyclerViewHolder> {
    private ArrayList<ModelMain> data = null;
    private Context mContext;

    public AdapterMain(ArrayList<ModelMain> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview_item_row, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, final int position) {
        holder.imgIcon.setImageResource(data.get(position).getIcon());
        holder.imgArrow.setImageResource(data.get(position).getArrow());
        holder.txtTitle.setText(data.get(position).getTitle());
        holder.txtDec.setText(data.get(position).getDec());
        holder.line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickedListener != null) {
                    onItemClickedListener.onItemClick(holder.txtTitle.getText().toString());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtDec;
        ImageView imgIcon, imgArrow;
        LinearLayout line;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtDec = (TextView) itemView.findViewById(R.id.txtDec);
            imgArrow = (ImageView) itemView.findViewById(R.id.imgArrow);
            imgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
            line = (LinearLayout) itemView.findViewById(R.id.line);
        }
    }

    public interface OnItemClickedListener {
        void onItemClick(String name);
    }

    private OnItemClickedListener onItemClickedListener;

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }
}

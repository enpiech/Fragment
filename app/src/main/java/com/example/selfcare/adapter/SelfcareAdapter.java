package com.example.selfcare.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.selfcare.R;
import com.example.selfcare.model.SelfcareModel;

import java.util.ArrayList;

public class SelfcareAdapter extends ArrayAdapter<SelfcareModel> {
    Context context;
    int layoutResource;
    ArrayList<SelfcareModel> data = null;

    public SelfcareAdapter(Context context, int layoutResource, ArrayList<SelfcareModel> data) {
        super(context, layoutResource, data);
        this.context = context;
        this.layoutResource = layoutResource;
        this.data = data;
    }

    static class Holder {
        ImageView imgIcon, imgClick;
        TextView txtTitle, txtDec;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Holder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResource, parent, false);

            holder = new Holder();
            holder.imgIcon = (ImageView) row.findViewById(R.id.imgIcon);
            holder.imgClick = (ImageView) row.findViewById(R.id.imgClick);
            holder.txtTitle = (TextView) row.findViewById(R.id.txtTitle);
            holder.txtDec = (TextView) row.findViewById(R.id.txtDec);

            row.setTag(holder);
        } else {
            holder = (Holder) row.getTag();
        }

        SelfcareModel item = data.get(position);
        holder.imgIcon.setImageResource(item.getIcon());
        holder.txtTitle.setText(item.getTitle());
        holder.txtDec.setText(item.getDec());
        holder.imgClick.setImageResource(item.getClick());
        return row;
    }
}

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
import com.example.selfcare.model.ListApp;
import com.example.selfcare.model.SelfcareModel;

import java.util.ArrayList;

public class ListAppAdapter extends ArrayAdapter<ListApp> {
    Context context;
    int layoutResource;
    ArrayList<ListApp> data = null;

    public ListAppAdapter(Context context, int layoutResource, ArrayList<ListApp> data) {
        super(context, layoutResource, data);
        this.context = context;
        this.layoutResource = layoutResource;
        this.data = data;
    }

    static class Holder
    {
        ImageView imgIcon;
        TextView txtName, txtOriname, txtVersion;
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
            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.txtOriname = (TextView) row.findViewById(R.id.txtoriName);
            holder.txtVersion = (TextView) row.findViewById(R.id.txtVersion);

            row.setTag(holder);
        } else {
            holder = (Holder) row.getTag();
        }

        ListApp item = data.get(position);
        holder.imgIcon.setImageDrawable(item.getIcon());
        holder.txtName.setText(item.getName());
        holder.txtOriname.setText(item.getOriname());
        holder.txtVersion.setText(item.getVersion());
        return row;
    }
}

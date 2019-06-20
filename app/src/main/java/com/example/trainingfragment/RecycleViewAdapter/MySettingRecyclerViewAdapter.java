package com.example.trainingfragment.RecycleViewAdapter;

import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trainingfragment.R;
import com.example.trainingfragment.RecycleViewAdapter.Listener.OnItemClickListener;

import com.example.trainingfragment.models.SettingModel;
import java.util.List;

public class MySettingRecyclerViewAdapter extends
        RecyclerView.Adapter<MySettingRecyclerViewAdapter.ViewHolder> {

    private final List<SettingModel> mValues;
    private final OnItemClickListener mListener;

    public MySettingRecyclerViewAdapter(List<SettingModel> items,
            OnItemClickListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.setting_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIconView.setImageResource(mValues.get(position).getImageIcon());
        holder.mNameView.setText(mValues.get(position).getName());
        holder.mDescriptionView.setText(mValues.get(position).getDescription());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClickListener(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        final ImageView mIconView;
        final TextView mNameView;
        final TextView mDescriptionView;
        final ImageButton mButtonView;
        SettingModel mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mIconView = view.findViewById(R.id.img_icon);
            mNameView = view.findViewById(R.id.txt_name);
            mDescriptionView = view.findViewById(R.id.txt_description);
            mButtonView = view.findViewById(R.id.btn_load);
        }

        @Override
        public String toString() {
            return "ViewHolder{" +
                    "mView=" + mView +
                    ", mIconView=" + mIconView +
                    ", mNameView=" + mNameView +
                    ", mDescriptionView=" + mDescriptionView +
                    ", mButtonView=" + mButtonView +
                    ", mItem=" + mItem +
                    '}';
        }
    }
}

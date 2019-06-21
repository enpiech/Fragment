package com.example.trainingfragment.RecycleViewAdapter.ViewHolder.AppInfo;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.trainingfragment.R;
import com.example.trainingfragment.RecycleViewAdapter.Listener.OnRecycleClickListener;
import com.example.trainingfragment.RecycleViewAdapter.ViewHolder.BaseViewHolder;
import com.example.trainingfragment.models.AppInfoModel;

public class BaseAppInfoViewHolder extends
        BaseViewHolder<AppInfoModel, OnRecycleClickListener<AppInfoModel>> {
    private final View mView;
    private final ImageView mIconView;
    private final TextView mNameView;
    private final TextView mPackageNameView;
    private AppInfoModel mItem;

    public BaseAppInfoViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
        mIconView = (ImageView) itemView.findViewById(R.id.img_icon);
        mNameView = (TextView) itemView.findViewById(R.id.txt_name);
        mPackageNameView = (TextView) itemView.findViewById(R.id.txt_package_name);
    }

    @Override
    public void onBind(final AppInfoModel item,
            @Nullable final OnRecycleClickListener<AppInfoModel> listener) {
        mItem = item;
        mIconView.setImageDrawable(item.getAppIcon());
        mNameView.setText(item.getAppName());
        mPackageNameView.setText(item.getAppPackageName());

        if (listener != null) {
            super.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(final View view) {
                    listener.onListFragmentInteraction(item);
                }
            });
        }
    }
}

package com.example.trainingfragment.RecycleViewAdapter.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.trainingfragment.R;
import com.example.trainingfragment.RecycleViewAdapter.Adapter.CPUUsageAdapter.CPUUsageViewHolder;
import com.example.trainingfragment.RecycleViewAdapter.Listener.BaseRecycleListener;
import com.example.trainingfragment.RecycleViewAdapter.Listener.OnRecycleClickListener;
import com.example.trainingfragment.RecycleViewAdapter.GenericViewHolder;
import com.example.trainingfragment.models.AppInfoModel;

public class CPUUsageAdapter extends GenericRecycleViewAdapter<AppInfoModel, OnRecycleClickListener<AppInfoModel>, CPUUsageViewHolder> {
    public CPUUsageAdapter(final Context context) {
        super(context);
    }

    @NonNull
    @Override
    public CPUUsageViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
            final int viewType) {
        CPUUsageViewHolder view = new CPUUsageViewHolder(inflate(R.layout.fragment_cpu_usage_item, parent));

        switch (viewType) {
            case 0:
                break;
            case 1:
                view.itemView.setBackgroundColor(view.itemView.getResources().getColor(R.color.colorLight));
                break;
        }
        return view;
    }


    @Override
    public int getItemViewType(final int position) {
        return position % 2;
    }

    class CPUUsageViewHolder extends
            GenericViewHolder<AppInfoModel, OnRecycleClickListener<AppInfoModel>> {

        private final ImageView mIconView;
        private final TextView mNameView;
        private final TextView mPackageNameView;
        private final TextView mUsagePercentView;

        CPUUsageViewHolder(@NonNull View itemView) {
            super(itemView);
            mIconView = (ImageView) itemView.findViewById(R.id.img_icon);
            mNameView = (TextView) itemView.findViewById(R.id.txt_name);
            mPackageNameView = (TextView) itemView.findViewById(R.id.txt_package_name);
            mUsagePercentView = itemView.findViewById(R.id.txt_usage_percent);
        }

        /**
         * Bind data to the item and set listener
         * @param item object with associated with the item
         * @param listener listener a listener {@link BaseRecycleListener} which has to be set at the item (if not `null`)
         */
        public void onBind(final AppInfoModel item,
                @Nullable final OnRecycleClickListener<AppInfoModel> listener) {
            mIconView.setImageDrawable(item.getAppIcon());
            mNameView.setText(item.getAppName());
            mPackageNameView.setText(item.getAppPackageName());
            if (item.getAverageCPUUsagePercent() != null) {
                mUsagePercentView.setText(item.getAverageCPUUsagePercent());
            }
        }
    }
}

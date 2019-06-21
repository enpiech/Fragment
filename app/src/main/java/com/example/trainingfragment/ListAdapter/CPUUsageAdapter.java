package com.example.trainingfragment.ListAdapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.trainingfragment.R;
import com.example.trainingfragment.models.AppInfoModel;

public class CPUUsageAdapter extends BaseAppInfoListAdapter {
    public CPUUsageAdapter(final OnClickListener listener) {
        super(listener, R.layout.fragment_cpu_usage_item);
    }

    @Override
    protected BaseAppInfoViewHolder getViewHolder(final View view) {
        return new CPUUsageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BaseAppInfoViewHolder holder, final int position) {
        CPUUsageViewHolder thisHolder = (CPUUsageViewHolder) holder;
        AppInfoModel appInfo = getItem(position);
        if (appInfo != null) {
            thisHolder.bindTo(getItem(position), mListener);
        }
    }

    class CPUUsageViewHolder extends BaseAppInfoViewHolder {
        private final TextView mUsagePercentView;

        CPUUsageViewHolder(@NonNull View itemView) {
            super(itemView);
            mUsagePercentView = itemView.findViewById(R.id.txt_usage_percent);
        }

        @Override
        void bindTo(final AppInfoModel item, final OnClickListener clickListener) {
            super.bindTo(item, clickListener);
            if (item.getAverageCPUUsagePercent() != null) {
                mUsagePercentView.setText(item.getAverageCPUUsagePercent());
            }
        }
    }
}

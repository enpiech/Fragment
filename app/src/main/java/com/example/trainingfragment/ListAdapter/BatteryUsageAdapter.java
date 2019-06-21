package com.example.trainingfragment.ListAdapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.trainingfragment.R;
import com.example.trainingfragment.models.AppInfoModel;

public class BatteryUsageAdapter extends BaseAppInfoListAdapter {
    public BatteryUsageAdapter(final OnClickListener listener) {
        super(listener, R.layout.fragment_battery_usage_item);
    }

    @Override
    protected BaseAppInfoViewHolder getViewHolder(final View view) {
        return new BatteryUsageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BaseAppInfoViewHolder holder, final int position) {
        BatteryUsageViewHolder thisHolder = (BatteryUsageViewHolder) holder;
        AppInfoModel appInfo = getItem(position);
        if (appInfo != null) {
            thisHolder.bindTo(getItem(position), mListener);
        }
    }

    class BatteryUsageViewHolder extends BaseAppInfoViewHolder {
        private final TextView mUsagePercentView;

        BatteryUsageViewHolder(@NonNull View itemView) {
            super(itemView);
            mUsagePercentView = itemView.findViewById(R.id.txt_usage_percent);
        }

        @Override
        void bindTo(final AppInfoModel item, final OnClickListener clickListener) {
            super.bindTo(item, clickListener);
            if (item.getAverageBatteryUsagePercent() != null) {
                mUsagePercentView.setText(item.getAverageBatteryUsagePercent());
            }
        }
    }
}

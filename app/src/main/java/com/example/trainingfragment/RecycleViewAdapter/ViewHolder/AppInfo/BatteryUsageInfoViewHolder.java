package com.example.trainingfragment.RecycleViewAdapter.ViewHolder.AppInfo;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.example.trainingfragment.R;
import com.example.trainingfragment.RecycleViewAdapter.Listener.OnRecycleClickListener;
import com.example.trainingfragment.models.AppInfoModel;

public class BatteryUsageInfoViewHolder extends BaseAppInfoViewHolder {

    private final TextView mUsagePercentView;

    public BatteryUsageInfoViewHolder(View itemView) {
        super(itemView);
        mUsagePercentView = itemView.findViewById(R.id.txt_usage_percent);
    }

    @Override
    public void onBind(final AppInfoModel item,
            @Nullable final OnRecycleClickListener<AppInfoModel> listener) {
        super.onBind(item, listener);
        if (item.getAverageBatteryUsagePercent() != null) {
            mUsagePercentView.setText(item.getAverageBatteryUsagePercent());
        }
    }
}

package com.example.trainingfragment.RecycleViewAdapter.ViewHolder.AppInfo;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.trainingfragment.R;
import com.example.trainingfragment.RecycleViewAdapter.Listener.OnRecycleClickListener;
import com.example.trainingfragment.models.AppInfoModel;

public class TimeUsageInfoViewHolder extends BaseAppInfoViewHolder {
    final TextView mLastTimeUsed;
    final TextView mLifeTime;

    public TimeUsageInfoViewHolder(@NonNull final View itemView) {
        super(itemView);
        mLastTimeUsed   = (TextView) itemView.findViewById(R.id.txt_last_time_used);
        mLifeTime       = (TextView) itemView.findViewById(R.id.txt_life_time);
    }

    @Override
    public void onBind(final AppInfoModel item,
            @Nullable final OnRecycleClickListener<AppInfoModel> listener) {
        super.onBind(item, listener);
        if (item.getLastTimeUsage() != null) {
            mLastTimeUsed.setText(item.getLastTimeUsage());
        }
        if (item.getLastLifeTime() != null) {
            mLifeTime.setText(item.getLastLifeTime());
        }
    }
}

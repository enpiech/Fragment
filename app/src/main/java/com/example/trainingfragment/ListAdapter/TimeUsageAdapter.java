package com.example.trainingfragment.ListAdapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.trainingfragment.R;
import com.example.trainingfragment.models.AppInfoModel;

public class TimeUsageAdapter extends BaseAppInfoListAdapter {
    public TimeUsageAdapter(final OnClickListener listener) {
        super(listener, R.layout.fragment_time_usage_item);
    }

    @Override
    protected BaseAppInfoViewHolder getViewHolder(final View view) {
        return new TimeUsageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BaseAppInfoViewHolder holder, final int position) {
        TimeUsageViewHolder thisHolder = (TimeUsageViewHolder) holder;
        AppInfoModel appInfo = getItem(position);
        if (appInfo != null) {
            thisHolder.bindTo(getItem(position), mListener);
        }
    }

    class TimeUsageViewHolder extends BaseAppInfoViewHolder {
        private final TextView mLastTimeUsed;
        private final TextView mLifeTime;

        TimeUsageViewHolder(@NonNull View itemView) {
            super(itemView);
            mLastTimeUsed   = (TextView) itemView.findViewById(R.id.txt_last_time_used);
            mLifeTime       = (TextView) itemView.findViewById(R.id.txt_life_time);
        }

        @Override
        void bindTo(final AppInfoModel item, final OnClickListener clickListener) {
            super.bindTo(item, clickListener);
            if (item.getLastTimeUsage() != null) {
                mLastTimeUsed.setText(item.getLastTimeUsage());
            }
            if (item.getLastLifeTime() != null) {
                mLifeTime.setText(item.getLastLifeTime());
            }
        }
    }
}

package com.example.trainingfragment.RecycleViewAdapter.Adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.example.trainingfragment.R;
import com.example.trainingfragment.RecycleViewAdapter.Listener.OnRecycleClickListener;
import com.example.trainingfragment.RecycleViewAdapter.ViewHolder.AppInfo.AppDetailViewHolder;
import com.example.trainingfragment.RecycleViewAdapter.ViewHolder.AppInfo.BaseAppInfoViewHolder;
import com.example.trainingfragment.RecycleViewAdapter.ViewHolder.AppInfo.BatteryUsageInfoViewHolder;
import com.example.trainingfragment.RecycleViewAdapter.ViewHolder.AppInfo.CPUUsageInfoViewHolder;
import com.example.trainingfragment.RecycleViewAdapter.ViewHolder.AppInfo.TimeUsageInfoViewHolder;
import com.example.trainingfragment.models.AppInfoModel;

public class BaseAppDetailAdapter extends GenericRecycleViewAdapter<AppInfoModel, OnRecycleClickListener<AppInfoModel>, BaseAppInfoViewHolder> {

    public static final int APP_DETAIL = 0;
    public static final int CPU_USAGE = 1;
    public static final int TIME_USAGE = 2;
    public static final int BATTERY_USAGE = 3;

    private final int mViewType;

    public BaseAppDetailAdapter(final Context context, final int viewType) {
        super(context);
        this.mViewType = viewType;
    }

    @NonNull
    @Override
    public BaseAppInfoViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
            final int viewType) {
        BaseAppInfoViewHolder view;

        switch (mViewType) {
            case APP_DETAIL:
                view = new AppDetailViewHolder(inflate(R.layout.fragment_app_detail_item, parent));
                break;
            case CPU_USAGE:
                view = new CPUUsageInfoViewHolder(inflate(R.layout.fragment_cpu_usage_item, parent));
                break;
            case TIME_USAGE:
                view = new TimeUsageInfoViewHolder(inflate(R.layout.fragment_time_usage_item, parent));
                break;
            case BATTERY_USAGE:
                view = new BatteryUsageInfoViewHolder(inflate(R.layout.fragment_battery_usage_item, parent));
                break;
            default:
                view = new AppDetailViewHolder(inflate(R.layout.fragment_app_detail_item, parent));
        }

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
}

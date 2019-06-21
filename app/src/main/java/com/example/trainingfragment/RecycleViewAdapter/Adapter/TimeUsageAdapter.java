package com.example.trainingfragment.RecycleViewAdapter.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.trainingfragment.R;
import com.example.trainingfragment.RecycleViewAdapter.Adapter.TimeUsageAdapter.TimeUsageViewHolder;
import com.example.trainingfragment.RecycleViewAdapter.Listener.BaseRecycleListener;
import com.example.trainingfragment.RecycleViewAdapter.Listener.OnRecycleClickListener;
import com.example.trainingfragment.RecycleViewAdapter.GenericViewHolder;
import com.example.trainingfragment.models.AppInfoModel;

public class TimeUsageAdapter extends GenericRecycleViewAdapter<AppInfoModel, OnRecycleClickListener<AppInfoModel>, TimeUsageViewHolder> {
    public TimeUsageAdapter(final Context context) {
        super(context);
    }

    @NonNull
    @Override
    public TimeUsageViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
            final int viewType) {
        TimeUsageViewHolder view = new TimeUsageViewHolder(inflate(R.layout.fragment_time_usage_item, parent));

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

    class TimeUsageViewHolder extends
            GenericViewHolder<AppInfoModel, OnRecycleClickListener<AppInfoModel>> {

        private final ImageView mIconView;
        private final TextView mNameView;
        private final TextView mPackageNameView;
        private final TextView mLastTimeUsed;
        private final TextView mLifeTime;

        TimeUsageViewHolder(@NonNull View itemView) {
            super(itemView);
            mIconView = (ImageView) itemView.findViewById(R.id.img_icon);
            mNameView = (TextView) itemView.findViewById(R.id.txt_name);
            mPackageNameView = (TextView) itemView.findViewById(R.id.txt_package_name);
            mLastTimeUsed   = (TextView) itemView.findViewById(R.id.txt_last_time_used);
            mLifeTime       = (TextView) itemView.findViewById(R.id.txt_life_time);
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
            if (item.getLastTimeUsage() != null) {
                mLastTimeUsed.setText(item.getLastTimeUsage());
            }
            if (item.getLastLifeTime() != null) {
                mLifeTime.setText(item.getLastLifeTime());
            }
        }
    }
}

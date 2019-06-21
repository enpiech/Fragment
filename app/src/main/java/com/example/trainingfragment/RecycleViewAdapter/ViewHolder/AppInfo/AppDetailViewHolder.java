package com.example.trainingfragment.RecycleViewAdapter.ViewHolder.AppInfo;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.trainingfragment.R;
import com.example.trainingfragment.RecycleViewAdapter.Listener.OnRecycleClickListener;
import com.example.trainingfragment.models.AppInfoModel;

public class AppDetailViewHolder extends BaseAppInfoViewHolder {
    private final TextView mVersionView;

    public AppDetailViewHolder(@NonNull final View itemView) {
        super(itemView);
        mVersionView = (TextView) itemView.findViewById(R.id.txt_version);
    }

    @Override
    public void onBind(final AppInfoModel item,
            @Nullable final OnRecycleClickListener<AppInfoModel> listener) {
        super.onBind(item, listener);
        if (item.getVersion() != null) {
            mVersionView.setText(item.getVersion());
        }
    }
}

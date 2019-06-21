package com.example.trainingfragment.ListAdapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.trainingfragment.R;
import com.example.trainingfragment.models.AppInfoModel;

public class AppDetailListAdapter extends BaseAppInfoListAdapter {

    public AppDetailListAdapter(final OnClickListener listener) {
        super(listener, R.layout.fragment_app_detail_item);
    }

    @Override
    protected BaseAppInfoViewHolder getViewHolder(final View view) {
        return new AppDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BaseAppInfoViewHolder holder, final int position) {
        AppDetailViewHolder thisHolder = (AppDetailViewHolder) holder;
        AppInfoModel appInfo = getItem(position);
        if (appInfo != null) {
            thisHolder.bindTo(getItem(position), mListener);
        }
    }

    class AppDetailViewHolder extends BaseAppInfoViewHolder {
        private final TextView mVersionView;

        AppDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            mVersionView = (TextView) itemView.findViewById(R.id.txt_version);
        }

        @Override
        void bindTo(final AppInfoModel item, final OnClickListener clickListener) {
            super.bindTo(item, clickListener);
            if (item.getVersion() != null) {
                mVersionView.setText(item.getVersion());
            }
        }
    }
}

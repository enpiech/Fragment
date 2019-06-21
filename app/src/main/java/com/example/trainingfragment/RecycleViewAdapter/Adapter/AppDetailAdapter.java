package com.example.trainingfragment.RecycleViewAdapter.Adapter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.trainingfragment.R;
import com.example.trainingfragment.RecycleViewAdapter.Adapter.AppDetailAdapter.AppDetailViewHolder;
import com.example.trainingfragment.RecycleViewAdapter.Listener.OnRecycleClickListener;
import com.example.trainingfragment.RecycleViewAdapter.GenericViewHolder;
import com.example.trainingfragment.models.AppInfoModel;

public class AppDetailAdapter extends GenericRecycleViewAdapter<AppInfoModel, OnRecycleClickListener<AppInfoModel>, AppDetailViewHolder> {

    public AppDetailAdapter(final Context context) {
        super(context);
    }

    @NonNull
    @Override
    public AppDetailViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
            final int viewType) {

        AppDetailViewHolder view = new AppDetailViewHolder(inflate(R.layout.fragment_app_detail_item, parent));
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

    public class AppDetailViewHolder extends
            GenericViewHolder<AppInfoModel, OnRecycleClickListener<AppInfoModel>> {
        private final ImageView mIconView;
        private final TextView mNameView;
        private final TextView mPackageNameView;
        private final TextView mVersionView;
        private View mItemView;

        AppDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mItemView = itemView;
            mIconView = (ImageView) itemView.findViewById(R.id.img_icon);
            mNameView = (TextView) itemView.findViewById(R.id.txt_name);
            mPackageNameView = (TextView) itemView.findViewById(R.id.txt_package_name);
            mVersionView = (TextView) itemView.findViewById(R.id.txt_version);
        }

        @Override
        public void onBind(final AppInfoModel item,
                @Nullable final OnRecycleClickListener<AppInfoModel> listener) {
            mIconView.setImageDrawable(item.getAppIcon());
            mNameView.setText(item.getAppName());
            mPackageNameView.setText(item.getAppPackageName());
            if (item.getVersion() != null) {
                mVersionView.setText(item.getVersion());
            }

            if (listener != null) {
                mItemView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        listener.onListFragmentInteraction(item);
                    }
                });
            }
        }
    }
}

package com.example.trainingfragment.ListAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.example.trainingfragment.ListAdapter.BaseAppInfoListAdapter.BaseAppInfoViewHolder;
import com.example.trainingfragment.R;
import com.example.trainingfragment.models.AppInfoModel;

public abstract class BaseAppInfoListAdapter extends ListAdapter<AppInfoModel, BaseAppInfoViewHolder> {

    OnClickListener mListener;
    private final int mLayoutId;

    BaseAppInfoListAdapter(OnClickListener listener, int layoutId) {
        super(AppInfoModel.DIFF_CALLBACK);
        mListener = listener;
        mLayoutId = layoutId;
    }

    @NonNull
    @Override
    public BaseAppInfoViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
            final int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(mLayoutId, parent, false);
        switch (viewType) {
            case 0:
                break;
            case 1:
                view.setBackgroundColor(view.getResources().getColor(R.color.colorLight));
                break;
        }
        return getViewHolder(view);
    }

    protected abstract BaseAppInfoViewHolder getViewHolder(View view);

    @Override
    public int getItemViewType(final int position) {
        return position % 2;
    }

    class BaseAppInfoViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mIconView;
        private final TextView mNameView;
        private final TextView mPackageNameView;

         BaseAppInfoViewHolder(@NonNull final View itemView) {
            super(itemView);
            mIconView = (ImageView) itemView.findViewById(R.id.img_icon);
            mNameView = (TextView) itemView.findViewById(R.id.txt_name);
            mPackageNameView = (TextView) itemView.findViewById(R.id.txt_package_name);
        }

        void bindTo(AppInfoModel item, OnClickListener clickListener) {
            itemView.setOnClickListener(clickListener);
            mIconView.setImageDrawable(item.getAppIcon());
            mNameView.setText(item.getAppName());
            mPackageNameView.setText(item.getAppPackageName());

            if (mListener != null) {
                itemView.setOnClickListener(mListener);
            }
        }
    }
}

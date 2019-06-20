package com.example.trainingfragment.RecycleViewAdapter;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trainingfragment.R;
import com.example.trainingfragment.RecycleViewAdapter.Listener.OnListFragmentInteractionListener;
import com.example.trainingfragment.dummy.DummyContent.DummyItem;

import com.example.trainingfragment.models.AppInfoModel;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}. TODO: Replace the implementation with code
 * for your data type.
 */
public class MyCpuRecyclerViewAdapter extends
        RecyclerView.Adapter<MyCpuRecyclerViewAdapter.ViewHolder> {

    private final List<AppInfoModel> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyCpuRecyclerViewAdapter(List<AppInfoModel> items,
            OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_cpu_usage_item, parent, false);
        switch (viewType) {
            case 0:
                break;
            case 1:
                view.setBackgroundColor(view.getResources().getColor(R.color.colorLight));
                break;
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final AppInfoModel appInfo = mValues.get(position);

        holder.mItem = appInfo;
        holder.mIconView.setImageDrawable(appInfo.getAppIcon());
        holder.mNameView.setText(appInfo.getAppName());
        holder.mPackageNameView.setText(appInfo.getAppPackageName());
        holder.mUsagePercentView.setText(appInfo.getAverageCPUUsagePercent());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(appInfo);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        final ImageView mIconView;
        final TextView mNameView;
        final TextView mPackageNameView;
        final TextView mUsagePercentView;
        AppInfoModel mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mIconView = (ImageView) view.findViewById(R.id.img_icon);
            mNameView = (TextView) view.findViewById(R.id.txt_name);
            mPackageNameView = (TextView) view.findViewById(R.id.txt_package_name);
            mUsagePercentView = (TextView) view.findViewById(R.id.txt_usage_percent);
        }

        @Override
        public String toString() {
            return "ViewHolder{" +
                    "mView=" + mView +
                    ", mIconView=" + mIconView +
                    ", mNameView=" + mNameView +
                    ", mPackageNameView=" + mPackageNameView +
                    ", mUsagePercentView=" + mUsagePercentView +
                    ", mItem=" + mItem +
                    '}';
        }
    }
}

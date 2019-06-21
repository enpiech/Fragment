package com.example.trainingfragment.RecycleViewAdapter.ViewHolder;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.example.trainingfragment.RecycleViewAdapter.Listener.BaseRecycleListener;

public abstract class BaseViewHolder<T, L extends BaseRecycleListener> extends RecyclerView.ViewHolder {

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    /**
     * Bind data to the item and set listener
     * @param item object with associated with the item
     * @param listener listener a listener {@link BaseRecycleListener} which has to be set at the item (if not `null`)
     */
    public abstract void onBind(T item, @Nullable L listener);
}

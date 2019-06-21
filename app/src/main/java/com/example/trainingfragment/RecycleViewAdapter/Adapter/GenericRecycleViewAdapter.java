package com.example.trainingfragment.RecycleViewAdapter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.example.trainingfragment.RecycleViewAdapter.Listener.BaseRecycleListener;
import com.example.trainingfragment.RecycleViewAdapter.GenericViewHolder;
import java.util.ArrayList;
import java.util.List;

/**
 * Base generic RecycleView adapter.
 * Handles basic logic such as adding/removing items, setting listner, binding ViewHolders.
 * Extend the adapter for appropriate use case
 *
 * @param <T>   type of objects, which will be used in the adapter's dataset
 * @param <L>   click listener {@link BaseRecycleListener}
 * @param <VH>  ViewHolder {@link GenericViewHolder}
 */
public abstract class GenericRecycleViewAdapter<T, L extends BaseRecycleListener, VH extends GenericViewHolder<T, L>>
        extends RecyclerView.Adapter<VH>{

    private List<T> mItems;
    private L mListener;
    private LayoutInflater mLayoutInflater;

    /**
     * Base constructor
     * Allocate adapter-related objects here if needed
     *
     * @param context Context needed to retrieve LayoutInflater
     */
    public GenericRecycleViewAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mItems = new ArrayList<>();
    }

    /**
     * To be implemented in as specific adapter
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public abstract VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the itemView to reflect the item at the given
     * position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        T item = mItems.get(position);
        holder.onBind(item, mListener);
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    /**
     * Return all items from the dataset held by the adapter
     *
     * @return All of items in this adapter
     */
    public List<T> getItems() {
        return mItems;
    }

    /**
     * Returns an item from the dataset at specific position
     *
     * @param position position of requested item
     * @return The items of given position
     */
    public T getItemAt(int position) {
        return mItems.get(position);
    }

    /**
     * Sets items to the adapter and notifies that data set has been changed.
     *
     * @param   items items to set to the adapter
     * @throws  IllegalArgumentException in case of setting `null` items
     */
    public void setItems(List<T> items) {
        if (items == null) {
            throw new IllegalArgumentException("Cannot set `null` item to the Recycler adapter");
        }
        this.mItems.clear();
        this.mItems.addAll(items);
        notifyDataSetChanged();
    }

    /**
     * Adds item to the end of the dataset
     *
     * @param item item which has to be added to the adapter
     */
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item to the Recycle adapter");
        }
        mItems.add(item);
        notifyItemInserted(mItems.size() - 1);
    }

    /**
     * Adds list of items to the end of the adapter's data set.
     * Notifies that item has been inserted.
     *
     * @param items items which has to be added to the adapter.
     */
    public void addAll(List<T> items) {
        if (items == null) {
            throw new IllegalArgumentException("Cannot add `null` items to the Recycle Adapter");
        }
        mItems.addAll(items);
        notifyItemRangeInserted(mItems.size() - items.size(), mItems.size());
    }

    /**
     * Clears all the items in the adapter
     */
    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    /**
     * Removes an item from the adapter
     * Notifies that item has been changed
     *
     * @param item to be removes
     */
    public void remove(T item) {
        int position = mItems.indexOf(item);
        if (position > -1) {
            mItems.remove(position);
            notifyItemChanged(position);
        }
    }

    /**
     * Set interaction listener, must extend {@link BaseRecycleListener}
     *
     * @param listener click listener
     */
    public void setListener(L listener) {
        this.mListener = listener;
    }

    /**
     * Inflates a view.
     *
     * @param layout       layout to me inflater
     * @param parent       container where to inflate
     * @param attachToRoot whether to attach to root or not
     * @return inflated View
     */
    @NonNull
    protected View inflate(@LayoutRes final int layout, @Nullable final ViewGroup parent, final boolean attachToRoot) {
        return mLayoutInflater.inflate(layout, parent, attachToRoot);
    }

    /**
     * Inflates a view.
     *
     * @param layout layout to me inflater
     * @param parent container where to inflate
     * @return inflated View
     */
    @NonNull
    protected View inflate(@LayoutRes final int layout, final @Nullable ViewGroup parent) {
        return inflate(layout, parent, false);
    }
}

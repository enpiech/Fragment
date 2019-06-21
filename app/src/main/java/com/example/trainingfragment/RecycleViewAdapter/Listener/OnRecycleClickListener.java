package com.example.trainingfragment.RecycleViewAdapter.Listener;

public interface OnRecycleClickListener<T> extends BaseRecycleListener {

    /**
     *  Item has been interacted
     *
     * @param item object associated with the interacted item
     */
    void onListFragmentInteraction(T item);

    /**
     * Item has been interacted
     *
     * @param id of object associated with interacted item
     */
    void onListFragmentInteraction(int id);
}

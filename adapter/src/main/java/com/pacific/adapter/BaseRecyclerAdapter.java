package com.pacific.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;

import java.util.List;

public abstract class BaseRecyclerAdapter<T> extends AbsRecyclerAdapter<T, RecyclerAdapterHelper> {

//    public BaseRecyclerAdapter() {
//        super();
//    }

//    public BaseRecyclerAdapter(@Nullable List<T> data) {
//        super( data);
//    }

    public BaseRecyclerAdapter(RecyclerView recyclerView, @Nullable List<T> data) {
        super(recyclerView, data);
    }

    @Override
    protected RecyclerAdapterHelper getAdapterHelper(ViewHolder viewHolder) {
        return RecyclerAdapterHelper.get(viewHolder);
    }
}

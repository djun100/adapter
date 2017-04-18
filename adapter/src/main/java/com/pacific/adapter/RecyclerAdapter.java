package com.pacific.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;

import java.util.List;

public abstract class RecyclerAdapter<T> extends BaseRecyclerAdapter<T, RecyclerAdapterHelper> {

    public RecyclerAdapter(@NonNull int... layoutResIds) {
        super(layoutResIds);
    }

    public RecyclerAdapter(@Nullable List<T> data, @NonNull int... layoutResIds) {
        super( data, layoutResIds);
    }

    @Override
    protected RecyclerAdapterHelper getAdapterHelper(ViewHolder viewHolder) {
        return RecyclerAdapterHelper.get(viewHolder);
    }
}

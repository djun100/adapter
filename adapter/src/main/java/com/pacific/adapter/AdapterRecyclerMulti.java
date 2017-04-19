package com.pacific.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;

import java.util.List;

public abstract class AdapterRecyclerMulti<T> extends BaseRecyclerAdapter<T, RecyclerAdapterHelper> {

    public AdapterRecyclerMulti(@NonNull int... layoutResIds) {
        super(layoutResIds);
    }

    public AdapterRecyclerMulti(@Nullable List<T> data, @NonNull int... layoutResIds) {
        super( data, layoutResIds);
    }

    public AdapterRecyclerMulti(RecyclerView recyclerView,@Nullable List<T> data, @NonNull int... layoutResIds) {
        super(recyclerView, data, layoutResIds);
    }

    @Override
    protected RecyclerAdapterHelper getAdapterHelper(ViewHolder viewHolder) {
        return RecyclerAdapterHelper.get(viewHolder);
    }

    @Override
    public int getItemViewType(int position) {
        return itemViewType(position);
    }

    protected abstract int itemViewType(int position);
}

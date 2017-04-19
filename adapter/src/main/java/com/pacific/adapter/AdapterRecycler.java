package com.pacific.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;

import java.util.List;

public abstract class AdapterRecycler<T> extends BaseRecyclerAdapter<T, RecyclerAdapterHelper> {

    public AdapterRecycler(@NonNull int... layoutResIds) {
        super(layoutResIds);
    }

    public AdapterRecycler(@Nullable List<T> data, @NonNull int... layoutResIds) {
        super( data, layoutResIds);
    }

    public AdapterRecycler(RecyclerView recyclerView,@Nullable List<T> data, @NonNull int... layoutResIds) {
        super(recyclerView, data, layoutResIds);
    }

    @Override
    protected RecyclerAdapterHelper getAdapterHelper(ViewHolder viewHolder) {
        return RecyclerAdapterHelper.get(viewHolder);
    }

    @Override
    public int getItemViewType(int position) {
        if (getViewTypeCount() == 1) {
            return super.getItemViewType(position);
        }
        throw new RuntimeException("Required method getItemViewType was not overridden");
    }
}

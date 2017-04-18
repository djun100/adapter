package com.pacific.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class AdapterMulti<T> extends BaseAdapter<T, AdapterHelper> {

    public AdapterMulti(@NonNull int... layoutResIds) {
        super(layoutResIds);
    }

    public AdapterMulti(@Nullable List<T> data, @NonNull int... layoutResIds) {
        super(data, layoutResIds);
    }

    @Override
    protected AdapterHelper getAdapterHelper(int position, View convertView, ViewGroup parent, int layoutResId) {
        return AdapterHelper.get(convertView, parent, layoutResId, position);
    }

    @Override
    public int getItemViewType(int position) {
        return itemViewType(position);
    }

    protected abstract int itemViewType(int position);
}

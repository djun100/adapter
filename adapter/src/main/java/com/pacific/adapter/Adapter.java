package com.pacific.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class Adapter<T> extends BaseAdapter<T, AdapterHelper> {

    public Adapter(@NonNull int... layoutResIds) {
        super(layoutResIds);
    }

    public Adapter( @Nullable List<T> data, @NonNull int... layoutResIds) {
        super(data, layoutResIds);
    }

    @Override
    protected AdapterHelper getAdapterHelper(int position, View convertView, ViewGroup parent, int layoutResId) {
        return AdapterHelper.get(convertView, parent, layoutResId, position);
    }
}

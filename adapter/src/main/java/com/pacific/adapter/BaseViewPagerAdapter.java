package com.pacific.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class BaseViewPagerAdapter<T> extends AbsViewPagerAdapter<T, PagerAdapterHelper> {

    public BaseViewPagerAdapter(Context context) {
        super(context);
    }

    public BaseViewPagerAdapter(Context context, @LayoutRes int layoutResId) {
        super(context, layoutResId);
    }

    public BaseViewPagerAdapter(Context context, @Nullable List<T> data, @LayoutRes int layoutResId) {
        super(context, data, layoutResId);
    }

    @Override
    protected PagerAdapterHelper getAdapterHelper(int position, View convertView, ViewGroup parent) {
        if (layoutResId != 0) {
            return PagerAdapterHelper.get(context, convertView, parent, layoutResId, position);
        } else {
            if (convertView == null) {
                return PagerAdapterHelper.get(context, createView(parent, position), parent, position, true);
            } else {
                return PagerAdapterHelper.get(context, convertView, parent, position, true);
            }
        }
    }
}

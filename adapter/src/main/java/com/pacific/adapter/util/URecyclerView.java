package com.pacific.adapter.util;

import android.support.v7.widget.RecyclerView;

/**
 * Created by wangxuechao on 2017/4/19.
 */

public class URecyclerView {
    private final RecyclerView mRecyclerView;

    public URecyclerView(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
    }

    public URecyclerView addHorizontalItemDecoration(){
        mRecyclerView.addItemDecoration(new HorizontalItemDecoration
                .Builder(mRecyclerView.getContext())
                .size(2)
                .showLastDivider()
                .margin(0)
                .build());
        return this;
    }

    public URecyclerView addItemDecoration(RecyclerView.ItemDecoration decoration){
        mRecyclerView.addItemDecoration(decoration);
        return this;
    }

    public URecyclerView addItemDecoration(RecyclerView.ItemDecoration decoration,int index){
        mRecyclerView.addItemDecoration(decoration,index);
        return this;
    }
}

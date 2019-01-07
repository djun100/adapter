package com.pacific.adapter.util;

import android.support.v7.widget.RecyclerView;

/**
 * Created by wangxuechao on 2017/4/19.
 */

public class UtilRecyclerView {
    private RecyclerView mRecyclerView;

    private UtilRecyclerView() {
    }

    public static UtilRecyclerView recyclerView(RecyclerView recyclerView){
        UtilRecyclerView utilRecyclerView=new UtilRecyclerView();
        utilRecyclerView.mRecyclerView=recyclerView;
        return utilRecyclerView;
    }

    public UtilRecyclerView addHorizontalItemDecoration(){
        mRecyclerView.addItemDecoration(new HorizontalItemDecoration
                .Builder(mRecyclerView.getContext())
                .size(2)
                .showLastDivider()
                .margin(0)
                .build());
        return this;
    }

    public UtilRecyclerView addItemDecoration(RecyclerView.ItemDecoration decoration){
        mRecyclerView.addItemDecoration(decoration);
        return this;
    }

    public UtilRecyclerView addItemDecoration(RecyclerView.ItemDecoration decoration, int index){
        mRecyclerView.addItemDecoration(decoration,index);
        return this;
    }
}

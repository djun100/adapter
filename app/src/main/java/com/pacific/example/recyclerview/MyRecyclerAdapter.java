package com.pacific.example.recyclerview;

import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.pacific.adapter.BaseRecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;
import com.pacific.example.ExploreBean;
import com.pacific.example.R;

import java.util.List;

public class MyRecyclerAdapter extends BaseRecyclerAdapter<ExploreBean> {

    public MyRecyclerAdapter(RecyclerView recyclerView, @Nullable List<ExploreBean> data) {
        super(recyclerView, data);
    }

    @Override
    protected void convert(final RecyclerAdapterHelper helper, ExploreBean exploreBean,
                           final int pos, int viewTypeAndLayoutRes, RecyclerView.ViewHolder holder) {
        if (viewTypeAndLayoutRes == R.layout.item0) {
//                if (true) {
            helper.setImageResource(R.id.img_explore_icon0, exploreBean.getIconResId());
            helper.setText(R.id.tv_explore_name0, "__Index: " + String.valueOf(pos))
                    .setText(R.id.tv_explore_desc0, exploreBean.getDescription())
                    .getItemView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickSnack(pos);
                }
            });
        } else if (viewTypeAndLayoutRes == R.layout.item1) {
            helper.setImageResource(R.id.img_explore_icon1, R.drawable.camera);
            helper.setText(R.id.tv_explore_name1, "__Index: " + String.valueOf(pos))
                    .setText(R.id.tv_explore_desc1, exploreBean.getDescription())
                    .getItemView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickSnack(pos);
                }
            });
        } else {
            helper.setImageResource(R.id.img_explore_icon2, R.drawable.ic_launcher);
            helper.setText(R.id.tv_explore_name2, "__Index: " + String.valueOf(pos))
                    .setText(R.id.tv_explore_desc2, exploreBean.getDescription())
                    .getItemView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickSnack(pos);
                }
            });
        }
        helper.getItemView().setTag("hello world");
    }

    @Override
    protected int getLayoutResAsItemViewType(int position) {
        if (baseGetBeans().get(position).getType().equals("a")){
            return R.layout.item0;
        }else if (baseGetBeans().get(position).getType().equals("b")){
            return R.layout.item1;
        }else return R.layout.item2;
    }



    public void clickSnack(int position) {
        Snackbar.make(baseGetRecyclerView(), "click item0 " + String.valueOf(position), Snackbar.LENGTH_SHORT)
                .setAction(R.string.close, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).show();
    }
}

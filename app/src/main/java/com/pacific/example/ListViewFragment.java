package com.pacific.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pacific.adapter.Adapter;
import com.pacific.adapter.AdapterHelper;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.ArrayList;
import java.util.List;

public class ListViewFragment extends RxFragment {

    private ListView listView;
    private Adapter<ExploreBean> adapter;
    List<ExploreBean> mBeen;
    public ListViewFragment() {
    }

    public static ListViewFragment newInstance() {
        ListViewFragment fragment = new ListViewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.mBeen=fragment.load();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new Adapter<ExploreBean>(mBeen,R.layout.item0, R.layout.item1, R.layout.item2) {
            @Override
            protected void convert(final AdapterHelper helper, ExploreBean exploreBean, final int pos) {
                if (getItemViewType(pos) == 0) {
                    helper.setImageResource(R.id.img_explore_icon0, exploreBean.getIconResId())
                            .setText(R.id.tv_explore_name0, "__Index: " + String.valueOf(pos))
                            .setText(R.id.tv_explore_desc0, exploreBean.getDescription())
                            .getItemView().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            clickSnack(pos);
                        }
                    });
                } else if (getItemViewType(pos) == 1) {
                    helper.setImageResource(R.id.img_explore_icon1, exploreBean.getIconResId())
                            .setText(R.id.tv_explore_name1, "__Index: " + String.valueOf(pos))
                            .setText(R.id.tv_explore_desc1, exploreBean.getDescription())
                            .getItemView().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            clickSnack(pos);
                        }
                    });
                } else {
                    helper.setImageResource(R.id.img_explore_icon2, exploreBean.getIconResId())
                            .setImageResource(R.id.img_explore_icon0, exploreBean.getIconResId())
                            .setText(R.id.tv_explore_name2, "__Index: " + String.valueOf(pos))
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

            /**
             * Must be overridden , when you have more than one item0 layout.
             * No need to be overridden , when you only have one item0 layout.
             */
            @Override
            public int getItemViewType(int position) {
                if (mBeen.get(position).getType().equals("a")){
                    return 0;
                }else if (mBeen.get(position).getType().equals("b")){
                    return 1;
                }else return 2;
            }

        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView) view.findViewById(R.id.lv_list);
        listView.setAdapter(adapter);
    }

    public List<ExploreBean> load() {
        List<ExploreBean> list = new ArrayList<>();
        list.add(new ExploreBean("c",R.drawable.head, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c",R.drawable.head, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c",R.drawable.head, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c",R.drawable.head, "web work", "start：2016.01.01，end: 2016.02.01"));

        list.add(new ExploreBean("a",R.drawable.head, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a",R.drawable.head, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a",R.drawable.head, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a",R.drawable.head, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b",R.drawable.head, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b",R.drawable.head, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b",R.drawable.head, "web work", "start：2016.01.01，end: 2016.02.01"));

        return list;
    }

    public void clickSnack(int position) {
        Snackbar.make(listView, "click item0 " + String.valueOf(position), Snackbar.LENGTH_SHORT)
                .setAction(R.string.close, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).show();
    }
}

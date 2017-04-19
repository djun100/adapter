package com.pacific.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pacific.adapter.AdapterRecyclerMulti;
import com.pacific.adapter.RecyclerAdapterHelper;
import com.pacific.adapter.util.HorizontalItemDecoration;
import com.pacific.adapter.util.URecyclerView;
import com.trello.rxlifecycle.android.FragmentEvent;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class RecyclerViewFragment extends RxFragment {
    private RecyclerView recyclerView;
    private AdapterRecyclerMulti<ExploreBean> adapter;

    public RecyclerViewFragment() {
    }

    public static RecyclerViewFragment newInstance() {
        RecyclerViewFragment fragment = new RecyclerViewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_explore);

        new URecyclerView(recyclerView).addHorizontalItemDecoration();
//        recyclerView.setAdapter(adapter);
        Observable
                .just(null)
                .compose(this.bindUntilEvent(FragmentEvent.DESTROY))
                .subscribeOn(Schedulers.newThread())
                .map(new Func1<Object, List<ExploreBean>>() {
                    @Override
                    public List<ExploreBean> call(Object o) {
                        return load();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<ExploreBean>>() {
                    @Override
                    public void call(List<ExploreBean> list0) {
                        adapter.addAll(list0);
                    }
                });

        adapter = new AdapterRecyclerMulti<ExploreBean>(recyclerView,load(),
                R.layout.item0, R.layout.item1, R.layout.item2) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, ExploreBean exploreBean, final int pos) {
                if (getItemViewType(pos) == 0) {
                    helper.setImageResource(R.id.img_explore_icon0, exploreBean.getIconResId());
                    helper.setText(R.id.tv_explore_name0, "__Index: " + String.valueOf(pos))
                            .setText(R.id.tv_explore_desc0, exploreBean.getDescription())
                            .getItemView().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            clickSnack(pos);
                        }
                    });
                } else if (getItemViewType(pos) == 1) {
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

            /**
             * Must be overridden , when you have more than one item0 layout.
             * No need to be overridden , when you only have one item0 layout.
             */
//            @Override
//            public int getItemViewType(int position) {
//                if (position % 3 == 0) {
//                    return 0;
//                } else if (position % 3 == 1) {
//                    return 1;
//                } else {
//                    return 2;
//                }
//            }

            @Override
            protected int itemViewType(int position) {
                if (position % 3 == 0) {
                    return 0;
                } else if (position % 3 == 1) {
                    return 1;
                } else {
                    return 2;
                }
            }
        };
    }

    public void clickSnack(int position) {
        Snackbar.make(recyclerView, "click item0 " + String.valueOf(position), Snackbar.LENGTH_SHORT)
                .setAction(R.string.close, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).show();
    }

    public List<ExploreBean> load() {
        List<ExploreBean> list = new ArrayList<>();
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        return list;
    }
}

package com.pacific.example.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pacific.adapter.BaseRecyclerAdapter;
import com.pacific.adapter.util.UtilRecyclerView;
import com.pacific.example.ExploreBean;
import com.pacific.example.R;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewFragment extends RxFragment {
    private RecyclerView recyclerView;
    private BaseRecyclerAdapter<ExploreBean> adapter;
    List<ExploreBean> mBeen;
    public RecyclerViewFragment() {
    }

    public static RecyclerViewFragment newInstance() {
        RecyclerViewFragment fragment = new RecyclerViewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.mBeen=fragment.load();
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
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_explore);

        UtilRecyclerView.recyclerView(recyclerView).addHorizontalItemDecoration();

        adapter = new MyRecyclerAdapter(recyclerView,mBeen);
    }



    public List<ExploreBean> load() {
        List<ExploreBean> list = new ArrayList<>();
        list.add(new ExploreBean("a",R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a",R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a",R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a",R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a",R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b",R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b",R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b",R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b",R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b",R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c",R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c",R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c",R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c",R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c",R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        return list;
    }
}

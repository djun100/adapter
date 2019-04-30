package com.pacific.example.recyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cy.io.Log;
import com.pacific.adapter.BaseRecyclerAdapter;
import com.pacific.adapter.util.HorizontalItemDecoration;
import com.pacific.example.ExploreBean;
import com.pacific.example.R;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_SETTLING;

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
        fragment.mBeen = fragment.load();
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

        recyclerView.addItemDecoration(
                HorizontalItemDecoration.Builder.create().setMarginHorizontal(30).build());

        adapter = new MyRecyclerAdapter(recyclerView, mBeen);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            long timeBegin = 0;
            boolean watch = true;
            int scrollState;

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                scrollState = newState;
                if (scrollState == SCROLL_STATE_IDLE) watch = true;
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (watch) {
                    if (timeBegin == 0) {
                        Log.w("速度计算值初始化");
                        timeBegin = System.currentTimeMillis();
                    } else {
                        float timeSecLasted = (System.currentTimeMillis() - timeBegin) / 1000f;

                        timeBegin = System.currentTimeMillis();
                        System.out.println("dy:" + dy + " timeSecLasted:" + timeSecLasted);

                        float speed = Math.abs(dy / timeSecLasted);
                        System.out.println("current speed:" + speed);
                        System.out.println("scroll state:" + scrollState);

                        //滚动最终停止时最上面一个item在滚动过程中从下方刚出现的时候是最佳时机
                        if (speed < 1000 && scrollState == SCROLL_STATE_SETTLING) {
                            System.out.println("滚动快停了");
                            Toast.makeText(getActivity(), "滚动快停了", Toast.LENGTH_SHORT).show();
                            if (scrollState == SCROLL_STATE_SETTLING) {
                                watch = false;
                            }
                        }
                    }
                }

            }
        });
    }


    public List<ExploreBean> load() {
        List<ExploreBean> list = new ArrayList<>();
        list.add(new ExploreBean("a", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));

        list.add(new ExploreBean("a", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));

        list.add(new ExploreBean("a", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("a", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("b", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new ExploreBean("c", R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        return list;
    }
}

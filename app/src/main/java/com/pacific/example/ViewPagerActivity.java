package com.pacific.example;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.pacific.adapter.PagerAdapterHelper;
import com.pacific.adapter.BaseViewPagerAdapter;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ViewPagerActivity extends RxAppCompatActivity {

    private BaseViewPagerAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        adapter = new BaseViewPagerAdapter<String>(this) {
            @Override
            protected void convert(PagerAdapterHelper helper, String item) {
                helper.setImageUrl(R.id.img_view, "file:///"+item);
            }

            @Override
            protected View createView(ViewGroup container, int position) {
                FrameLayout fl = new FrameLayout(context);
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(1024, 1024, Gravity.CENTER);
                imageView.setId(R.id.img_view);
                fl.addView(imageView);
                imageView.setLayoutParams(lp);
                return fl;
            }
        };
        ((ViewPager) findViewById(R.id.view_pager)).setAdapter(adapter);
        loadImageUrl();
    }

    private void loadImageUrl(){
        Observable
                .just(new ArrayList<String>())
                .compose(this.<List<String>>bindUntilEvent(ActivityEvent.DESTROY))
                .observeOn(Schedulers.newThread())
                .map(new Func1<List<String>, List<String>>() {
                    @Override
                    public List<String> call(List<String> strings) {
                        String path = Environment.getExternalStorageDirectory().getAbsolutePath();

                        File file =new File(path+File.separator+"Pacific"+File.separator);
                        File[] files=file.listFiles();
                        if (files==null ||files.length==0){
                            return strings;
                        }
                        for (File f : files) {
                            if(f.getName().endsWith(".jpg") || (f.getName().endsWith(".png"))){
                                strings.add(f.getAbsolutePath());
                            }
                        }
                        return strings;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> strings) {
                        adapter.addAll(strings);
                    }
                });
    }
}

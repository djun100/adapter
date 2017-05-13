package com.pacific.example;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/**
 * Created by cy on 2017/4/23.
 */

public class BoundListView extends ListView {
    int mMaxYOverscrollDistance=200;

    public BoundListView(Context context) {
        super(context);
    }

    public BoundListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BoundListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BoundListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setOverScrollMode(int mode) {
        super.setOverScrollMode(View.OVER_SCROLL_ALWAYS);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX,
                                   int scrollY, int scrollRangeX, int scrollRangeY,
                                   int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX,
                scrollRangeY, maxOverScrollX, mMaxYOverscrollDistance, isTouchEvent);
    }
}

package com.pacific.adapter.util;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 分割线
 * <p>
 * 当同时设置了颜色和图片时，以图片为主
 * 当不设置size时，分割线以图片的厚度为标准或不显示分割线（size默认为0）。
 */
public class HorizontalItemDecoration extends RecyclerView.ItemDecoration {
    private Paint mPaint;
    private Builder mBuilder;
    private HorizontalItemDecoration(Builder builder) {
        this(builder.mDividerSize,builder.mDividerColor,builder.mDividerDrawable);
        mBuilder=builder;
    }

    private HorizontalItemDecoration(int dividerSize, int dividerColor, Drawable dividerDrawable) {

        //绘制纯色分割线
        if (dividerDrawable == null) {
            //初始化画笔(抗锯齿)并设置画笔颜色和画笔样式为填充
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setColor(dividerColor);
            mPaint.setStyle(Paint.Style.FILL);
            //绘制图片分割线
        } else {
            //如果没有指定分割线的size，则默认是图片的厚度
            if (dividerSize == 0) {
                mBuilder.mDividerSize = dividerDrawable.getIntrinsicHeight();
            }
        }
    }


    /**
     * 绘制item分割线
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        //纵向列表画横线，横向列表画竖线
        drawHorientationDivider(c, parent, state);
    }

    /**
     * 根据分割线的size设置item偏移量
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, 0, mBuilder.mDividerSize);

    }

    /**
     * 画横线
     */
    private void drawHorientationDivider(Canvas c, RecyclerView parent, RecyclerView.State state) {
        //得到分割线的四个点：左、上、右、下
        //画横线时左右可以根据parent得到
        int left = parent.getPaddingLeft()+mBuilder.marginLeft;
        int right = parent.getMeasuredWidth() - parent.getPaddingRight()-mBuilder.marginRight;

        //上下需要根据每个孩子控件计算
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mBuilder.mDividerSize;
            //得到四个点后开始画
            if (mBuilder.mDividerDrawable == null) {
                c.drawRect(left, top, right, bottom, mPaint);
            } else {
                mBuilder.mDividerDrawable.setBounds(left, top, right, bottom);
                mBuilder.mDividerDrawable.draw(c);
            }
        }
    }

    /**
     * 画竖线
     */
    private void drawVerticalDivider(Canvas c, RecyclerView parent, RecyclerView.State state) {
        //画竖线时上下可以根据parent得到
        int top = parent.getPaddingTop();
        int bottom = parent.getMeasuredHeight() - parent.getPaddingBottom();

        //左右需要根据孩子控件计算
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int left = child.getRight() + params.rightMargin;
            int right = left + mBuilder.mDividerSize;
            //得到四个点后开始画
            if (mBuilder.mDividerDrawable == null) {
                c.drawRect(left, top, right, bottom, mPaint);
            } else {
                mBuilder.mDividerDrawable.setBounds(left, top, right, bottom);
                mBuilder.mDividerDrawable.draw(c);
            }
        }
    }


    public static class Builder{
        private int mDividerSize = 1;
        private int mDividerColor = Color.BLACK;
        private Drawable mDividerDrawable;
        private int marginLeft;
        private int marginRight;


        public static Builder create(){
            Builder builder=new Builder();
            return builder;
        }
        public HorizontalItemDecoration build(){
            HorizontalItemDecoration horizontalItemDecoration= new HorizontalItemDecoration(this);
            return horizontalItemDecoration;
        }

        public Builder setDividerSize(int dividerSize) {
            mDividerSize = dividerSize;
            return this;
        }

        public Builder setDividerColor(@ColorInt int dividerColor) {
            mDividerColor = dividerColor;
            return this;
        }

        public Builder setDividerColorRes(@ColorRes int dividerColor) {
            mDividerColor = UtilContext.getContext().getResources().getColor(dividerColor);
            return this;
        }

        public Builder setDividerDrawable(Drawable dividerDrawable) {
            mDividerDrawable = dividerDrawable;
            return this;
        }

        public Builder setMarginHorizontal(int marginHorizontal) {
            this.marginLeft=marginHorizontal;
            this.marginRight=marginHorizontal;
            return this;
        }

        public Builder setMarginLeft(int marginLeft) {
            this.marginLeft = marginLeft;
            return this;
        }

        public Builder setMarginRight(int marginRight) {
            this.marginRight = marginRight;
            return this;
        }
    }
}
package com.pacific.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public abstract class BaseFragmentPagerAdapter extends FragmentPagerAdapter {
    protected int currentPosition = -1;
    protected Fragment currentFragment;
    private int count;
    public BaseFragmentPagerAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        count=pageCount;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        this.currentPosition = position;
        if (object instanceof Fragment) {
            this.currentFragment = (Fragment) object;
        }
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }

    @Override
    public int getCount() {
        return count;
    }
}

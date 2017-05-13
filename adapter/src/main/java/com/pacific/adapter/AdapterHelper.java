package com.pacific.adapter;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pacific.adapter.util.UtilContext;


final public class AdapterHelper extends BaseAdapterHelper<AdapterHelper> {

    protected View convertView;
    protected int position = -1;

    private AdapterHelper( ViewGroup parent, int layoutId, int position) {
        this.position = position;
        this.views = new SparseArray<>();
        this.convertView = LayoutInflater.from(UtilContext.getContext()).inflate(layoutId, parent, false);
        this.convertView.setTag(R.id.tag_adapter_helper, this);
    }

    static AdapterHelper get(View convertView, ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new AdapterHelper( parent, layoutId, position);
        }
        AdapterHelper helper = (AdapterHelper) convertView.getTag(R.id.tag_adapter_helper);
        helper.position = position;
        return helper;
    }

    @Override
    public View getItemView() {
        return convertView;
    }

    public int getPosition() {
        return position;
    }
}

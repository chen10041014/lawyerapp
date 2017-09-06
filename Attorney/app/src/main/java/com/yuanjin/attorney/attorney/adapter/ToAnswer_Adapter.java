package com.yuanjin.attorney.attorney.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.yuanjin.attorney.attorney.R;

/**
 * Created by Chan on 2017/8/31.
 */

public class ToAnswer_Adapter extends BaseAdapter {

    private Context mContext;

    public ToAnswer_Adapter(Context context) {
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.customview_item_contact, parent, false);
        }

        return convertView;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}

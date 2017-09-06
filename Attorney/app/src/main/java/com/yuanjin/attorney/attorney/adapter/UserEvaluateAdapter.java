package com.yuanjin.attorney.attorney.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.yuanjin.attorney.attorney.R;

/**
 * Created by Chan on 2017/8/28.
 */

public class UserEvaluateAdapter extends BaseAdapter {
    private Context mContext;
//    private List mShowItems = new ArrayList();

    public UserEvaluateAdapter(Context context) {
        mContext = context;

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.user_evaluate, null);
        }

        return convertView;
    }
}

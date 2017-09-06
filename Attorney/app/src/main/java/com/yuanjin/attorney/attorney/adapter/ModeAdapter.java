package com.yuanjin.attorney.attorney.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.yuanjin.attorney.attorney.R;

import java.util.List;

/**
 * Created by Chan on 2017/8/25.
 */

public class ModeAdapter extends BaseAdapter {

    public ModeAdapter(Context context, int layoutId, List datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(ViewHolder holder, Object o) {
        holder.setText(R.id.textView, (String) o);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
}

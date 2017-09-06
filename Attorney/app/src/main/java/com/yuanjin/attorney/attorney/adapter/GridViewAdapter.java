package com.yuanjin.attorney.attorney.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuanjin.attorney.attorney.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Chan on 2017/8/21.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<Map<String, Object>> listItem;

    public GridViewAdapter(Context context, List<Map<String, Object>> listItem) {
        mContext = context;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.gridview_item, null);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        TextView textView = (TextView) convertView.findViewById(R.id.textView);

        Map<String, Object> map = listItem.get(position);
        imageView.setImageResource((Integer) map.get("image"));
        textView.setText(map.get("title") + "");
        return convertView;
    }
}

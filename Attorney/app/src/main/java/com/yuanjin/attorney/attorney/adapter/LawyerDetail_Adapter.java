package com.yuanjin.attorney.attorney.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuanjin.attorney.attorney.R;

/**
 * Created by Chan on 2017/8/29.
 */

public class LawyerDetail_Adapter extends BaseAdapter{
    private Context mContext;

    public LawyerDetail_Adapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return 16;
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
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.view_lawyer_list, null);
            viewHolder = new ViewHolder();
            viewHolder.lawyer_Icon = (ImageView) convertView.findViewById(R.id.lawyer_icon);
            viewHolder.lawyer_name = (TextView) convertView.findViewById(R.id.lawyer_name);
            viewHolder.case_num = (TextView) convertView.findViewById(R.id.case_num);
            viewHolder.consult_num = (TextView) convertView.findViewById(R.id.consult_num);
            viewHolder.goodAt = (TextView) convertView.findViewById(R.id.goodAt);
            viewHolder.lawoffice_name = (TextView) convertView.findViewById(R.id.lawoffice_name);
            viewHolder.distance = (TextView) convertView.findViewById(R.id.distance);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        return convertView;
    }

    static class ViewHolder{
        ImageView lawyer_Icon;
        TextView lawyer_name;
        TextView case_num;
        TextView consult_num;
        TextView lawoffice_name;
        TextView goodAt;
        TextView distance;
    }
}

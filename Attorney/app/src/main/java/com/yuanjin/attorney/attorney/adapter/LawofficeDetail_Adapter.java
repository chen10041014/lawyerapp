package com.yuanjin.attorney.attorney.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuanjin.attorney.attorney.R;

/**
 * Created by Chan on 2017/8/25.
 */

public class LawofficeDetail_Adapter extends BaseAdapter {
    private Context mContext;

    public LawofficeDetail_Adapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return 10;
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
            convertView = View.inflate(mContext, R.layout.view_lawoffice_list, null);
            viewHolder = new ViewHolder();
            viewHolder.iv_lawoffice_logo = (ImageView) convertView.findViewById(R.id.lawoffice_icon);
            viewHolder.lawoffice_name = (TextView) convertView.findViewById(R.id.lawoffice_name);
            viewHolder.phone_num = (TextView) convertView.findViewById(R.id.phone_num);
            viewHolder.lawyer_num = (TextView) convertView.findViewById(R.id.lawyer_num);
            viewHolder.case_num = (TextView) convertView.findViewById(R.id.case_num);
            viewHolder.consult_num = (TextView) convertView.findViewById(R.id.consult_num);
            viewHolder.goodAt = (TextView) convertView.findViewById(R.id.goodAt);
            viewHolder.address = (TextView) convertView.findViewById(R.id.lawoffice_address);
            viewHolder.distance = (TextView) convertView.findViewById(R.id.distance);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }




        return convertView;
    }

    static class ViewHolder {
        ImageView iv_lawoffice_logo;
        TextView  lawoffice_name;
        TextView  phone_num;
        TextView  lawyer_num;
        TextView  case_num;
        TextView  consult_num;
        TextView  goodAt;
        TextView  address;
        TextView  distance;
    }
}

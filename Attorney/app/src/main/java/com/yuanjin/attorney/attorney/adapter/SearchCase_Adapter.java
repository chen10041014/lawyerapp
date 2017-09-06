package com.yuanjin.attorney.attorney.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuanjin.attorney.attorney.R;

/**
 * Created by Chan on 2017/9/4.
 */

public class SearchCase_Adapter extends BaseAdapter {
    private Context mContext;

    public SearchCase_Adapter(Context context) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.search_case_adapter, null);
            viewHolder = new ViewHolder();
            viewHolder.mCaseTitle = (TextView) convertView.findViewById(R.id.case_title);
            viewHolder.mCaseType = (TextView) convertView.findViewById(R.id.case_type);
            viewHolder.mCaseContent = (TextView) convertView.findViewById(R.id.case_content);
            viewHolder.mCaseTime = (TextView) convertView.findViewById(R.id.case_time);
            viewHolder.mCaseCollectionNum = (TextView) convertView.findViewById(R.id.case_collectionNum);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


   static class ViewHolder{

       private TextView mCaseTitle;
       private TextView mCaseType;
       private TextView mCaseContent;
       private TextView mCaseTime;
       private TextView mCaseCollectionNum;



   }


}

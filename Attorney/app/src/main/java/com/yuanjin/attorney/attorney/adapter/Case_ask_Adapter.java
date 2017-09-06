package com.yuanjin.attorney.attorney.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuanjin.attorney.attorney.R;

/**
 * Created by Chan on 2017/9/5.
 */

public class Case_ask_Adapter extends RecyclerView.Adapter<Case_ask_Adapter.ViewHolder> {

    private Context mContext;


    public Case_ask_Adapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_case_ask_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mCaseContent.setText("这是我的测试数据");

    }

    @Override
    public int getItemCount() {
        return 30;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mLawofficeIcon;
        private TextView  mLawofficeName;
        private TextView  mCaseType;
        private TextView  mCaseContent;
        private TextView  mCaseTime;
        private TextView  mCaseCollectionNum;

        public ViewHolder(View itemView) {
            super(itemView);
            mLawofficeIcon = (ImageView) itemView.findViewById(R.id.lawoffice_icon);
            mLawofficeName = (TextView) itemView.findViewById(R.id.lawoffice_name);
            mCaseType = (TextView) itemView.findViewById(R.id.case_type);
            mCaseContent = (TextView) itemView.findViewById(R.id.case_content);
            mCaseTime = (TextView) itemView.findViewById(R.id.case_time);
            mCaseCollectionNum = (TextView) itemView.findViewById(R.id.case_collectionNum);


        }
    }
}


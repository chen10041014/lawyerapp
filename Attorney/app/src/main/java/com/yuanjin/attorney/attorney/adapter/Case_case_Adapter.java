package com.yuanjin.attorney.attorney.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuanjin.attorney.attorney.R;

/**
 * Created by Chan on 2017/8/29.
 */

public class Case_case_Adapter extends RecyclerView.Adapter<Case_case_Adapter.ViewHolder> {
    private Context mContext;

    public Case_case_Adapter(Context context) {
        mContext = context;
    }

    //绑定数据
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_case_case_detail, parent, false);


        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    //更新数据
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
      /*  ViewHolder viewHolder = holder;
        View view = viewHolder.itemView;
        TextView tv = (TextView) view.findViewById(R.id.tv);
        tv.setText("123");*/
    }

    @Override
    public int getItemCount() {
        return 1;
    }



    class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View itemView) {
            super(itemView);

        }
    }


}

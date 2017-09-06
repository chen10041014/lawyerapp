package com.yuanjin.attorney.attorney.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuanjin.attorney.attorney.R;
import com.yuanjin.attorney.attorney.bean.LawyerBean;
import com.yuanjin.attorney.attorney.ui.activity.MainActivity;
import com.yuanjin.attorney.attorney.utils.SpUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chan on 2017/8/22.
 */

public class Home_seekLawyer_adapter extends BaseAdapter {
    private Context mContext;
    private List<LawyerBean.LawyerListBean> mShowItem = new ArrayList<>();

    private ImageView ivAvatarLawyer;
    private TextView  tvLawyeerName;
    private ImageView lawType;
    private TextView  askContent;
    private TextView  tvTime;
    private TextView  tvKeepCount;

    private Activity mActivity;

    public Home_seekLawyer_adapter(Context context, List<LawyerBean.LawyerListBean> showItem,Activity activity) {
        mContext = context;
        mShowItem = showItem;
        mActivity = activity;
    }

    @Override
    public int getCount() {
        return mShowItem.size();
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

        switch (getItemViewType(position)) {
            case 0:
                if (convertView == null) {
                    convertView = View.inflate(mContext, R.layout.view_home_seeklawyer_head, null);

                }
                break;

            case 1:
                if (convertView == null) {
                    convertView = View.inflate(mContext, R.layout.view_home_seeklawoffice_middle, null);
                    TextView goodAsk_more = (TextView) convertView.findViewById(R.id.goodAsk_more);
                    goodAsk_more.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SpUtils.saveBoolean(mContext, "isClickToFragment", true);
                            MainActivity mainActivity = (MainActivity) mActivity;
                            mainActivity.changeAppointFragment("案例库");
                        }
                    });
                }
                break;
            case 2:
                if (convertView == null) {
                    convertView = View.inflate(mContext, R.layout.view_home_seeklawyer_body, null);

                    ivAvatarLawyer = (ImageView) convertView.findViewById(R.id.iv_avatar_lawyer);
                    tvLawyeerName = (TextView) convertView.findViewById(R.id.tv_lawyeer_name);
                    lawType = (ImageView) convertView.findViewById(R.id.law_type);
                    askContent = (TextView) convertView.findViewById(R.id.ask_content);
                    tvTime = (TextView) convertView.findViewById(R.id.tv_time);
                    tvKeepCount = (TextView) convertView.findViewById(R.id.tv_keep_count);

                    tvLawyeerName.setText(mShowItem.get(position).getName());
                    tvKeepCount.setText(mShowItem.get(position).getConsultCount()+"");
                }


                break;
        }


        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }
}

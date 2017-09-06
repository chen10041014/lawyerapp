package com.yuanjin.attorney.attorney.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yuanjin.attorney.attorney.R;
import com.yuanjin.attorney.attorney.bean.LawOfficeBean;
import com.yuanjin.attorney.attorney.ui.activity.MainActivity;
import com.yuanjin.attorney.attorney.utils.SpUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chan on 2017/8/22.
 */

public class Home_seekLawOffice_adapter extends BaseAdapter {
    private Context mContext;
    private List<LawOfficeBean.LawofficeListBean> mShowItem = new ArrayList<>();

    private ImageView ivAvatarLawoffice;
    private TextView tvLawofficeName;
    private TextView tvTime;
    private TextView tvKeepCount;
    private LinearLayout mLinearLayout1;
    private Activity mActivity;

    public Home_seekLawOffice_adapter(Context context, List<LawOfficeBean.LawofficeListBean> lawofficeList, Activity activity) {
        this.mContext = context;
        this.mShowItem = lawofficeList;
        this.mActivity = activity;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;


        switch (getItemViewType(position)) {
            case 0:
                if (convertView == null) {
                    convertView = View.inflate(mContext, R.layout.view_home_seeklawoffice_head, null);
                    ImageView iv_icon1 = (ImageView) convertView.findViewById(R.id.lawoffice_icon1);
                    ImageView iv_icon2 = (ImageView) convertView.findViewById(R.id.lawoffice_icon2);
                    ImageView iv_icon3 = (ImageView) convertView.findViewById(R.id.lawoffice_icon3);
                    ImageView iv_icon4 = (ImageView) convertView.findViewById(R.id.lawoffice_icon4);
                    TextView tv_name1 = (TextView) convertView.findViewById(R.id.lawoffice_name1);
                    TextView tv_name2 = (TextView) convertView.findViewById(R.id.lawoffice_name2);
                    TextView tv_name3 = (TextView) convertView.findViewById(R.id.lawoffice_name3);
                    TextView tv_name4 = (TextView) convertView.findViewById(R.id.lawoffice_name4);
                    mLinearLayout1 = (LinearLayout) convertView.findViewById(R.id.ll_lawoffice1);

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

                    convertView = View.inflate(mContext, R.layout.view_home_seeklawoffice_body, null);
                    ivAvatarLawoffice = (ImageView) convertView.findViewById(R.id.iv_avatar_lawoffice);
                    tvLawofficeName = (TextView) convertView.findViewById(R.id.tv_lawoffice_name);
                    tvTime = (TextView) convertView.findViewById(R.id.tv_time);
                    tvKeepCount = (TextView) convertView.findViewById(R.id.tv_keep_count);
                    tvLawofficeName.setText(mShowItem.get(position).getName());
                    tvKeepCount.setText("关注"+mShowItem.get(position).getCaseCount()+"人");
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


    static class ViewHolder {
        ImageView iv_seeklawoffice;
        TextView  tv_seeklawoffice;
    }


    //接口回调
    public interface OnLawofficeClickListener{
        void onLawofficeClick(int position);
    }

    private OnLawofficeClickListener mOnLawofficeClickListener;

    public void setOnLawofficeClickListener(OnLawofficeClickListener onLawofficeClickListener) {
        this.mOnLawofficeClickListener = onLawofficeClickListener;
    }

}

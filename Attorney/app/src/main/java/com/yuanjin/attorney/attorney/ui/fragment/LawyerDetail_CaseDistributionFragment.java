package com.yuanjin.attorney.attorney.ui.fragment;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import com.don.pieviewlibrary.PercentPieView;
import com.yuanjin.attorney.attorney.R;
import com.yuanjin.attorney.attorney.adapter.UserEvaluateAdapter;
import com.yuanjin.attorney.attorney.ui.view.CustomViewpager;
import com.yuanjin.attorney.attorney.ui.view.MyListView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Chan on 2017/9/5.
 */

public class LawyerDetail_CaseDistributionFragment extends BaseFragment {

    @Bind(R.id.user_evaluate_count)
    TextView   mUserEvaluateCount;
    @Bind(R.id.lv_user_evaluate)
    MyListView mLvUserEvaluate;
    @Bind(R.id.all_evaluate)
    TextView   mAllEvaluate;

    private CustomViewpager vp;

    public LawyerDetail_CaseDistributionFragment() {

    }
    @SuppressLint("ValidFragment")
    public LawyerDetail_CaseDistributionFragment(CustomViewpager vp) {
        this.vp = vp;
    }

    @Override
    protected View createSuccessView() {
        View view = View.inflate(getContext(), R.layout.custom_pieview, null);
        ButterKnife.bind(this, view);
        initView(view);
//        vp.setObjectForPosition(view,0);
        return view;
    }

    private void initView(View view) {
        int[] data = new int[]{15, 20, 30, 35};
        String[] name = new String[]{"兄弟", "姐妹", "情侣", "基友"};
        int[] color = new int[]{
                getResources().getColor(R.color.blue),
                getResources().getColor(R.color.list_divider_color),
                getResources().getColor(R.color.yellow),
                getResources().getColor(R.color.red)};

        PercentPieView pieView = (PercentPieView) view.findViewById(R.id.pieView2);
        //设置指定颜色
        pieView.setData(data, name, color);


        mLvUserEvaluate.setAdapter(new UserEvaluateAdapter(getContext()));

    }

    @Override
    protected Object requestData() {
        return "";
    }


}

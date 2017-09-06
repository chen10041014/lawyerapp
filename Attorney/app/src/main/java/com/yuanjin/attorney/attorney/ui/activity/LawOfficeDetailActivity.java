package com.yuanjin.attorney.attorney.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuanjin.attorney.attorney.R;
import com.yuanjin.attorney.attorney.adapter.Case_CaseAdapter;
import com.yuanjin.attorney.attorney.bean.FragmentInfo;
import com.yuanjin.attorney.attorney.ui.fragment.Case_AskFragment;
import com.yuanjin.attorney.attorney.ui.fragment.Case_DistributionFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LawOfficeDetailActivity extends BaseActivity {


    @Bind(R.id.lawoffice_logo)
    ImageView mLawofficeLogo;
    @Bind(R.id.lawoffice_name)
    TextView  mLawofficeName;
    @Bind(R.id.register_money)
    TextView  mRegisterMoney;
    @Bind(R.id.register_date)
    TextView  mRegisterDate;
    @Bind(R.id.lawyer_num)
    TextView  mLawyerNum;
    @Bind(R.id.tab_new_title_layout)
    TabLayout mTabNewTitleLayout;
    @Bind(R.id.vp_new_show_layout)
    ViewPager mVpNewShowLayout;

    private List<FragmentInfo> mShowItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law_office_detail);
        ButterKnife.bind(this);
        initToolbar();
        initNet();
        initView();
    }

    private void initToolbar() {

    }

    //初始化
    private void initNet() {


    }

    private void initView() {
        FragmentInfo fragmentInfo = new FragmentInfo();
        //显示的fragment
        fragmentInfo.fragment = new Case_DistributionFragment();
        fragmentInfo.title = "案件分布";
        mShowItems.add(fragmentInfo);
        FragmentInfo fragmentInfo2 = new FragmentInfo();
        //显示的fragment
        fragmentInfo2.fragment = new Case_AskFragment();
        fragmentInfo2.title = "案件数";
        mShowItems.add(fragmentInfo2);
        FragmentInfo fragmentInfo3 = new FragmentInfo();
        //显示的fragment
        fragmentInfo3.fragment = new Case_AskFragment();
        fragmentInfo3.title = "咨询量";
        mShowItems.add(fragmentInfo3);

        //如果初始化
        //第二层的fragment管理器永远用getChildFragmentManager()
        mVpNewShowLayout.setAdapter(new Case_CaseAdapter(getSupportFragmentManager(),mShowItems));

        mTabNewTitleLayout.setupWithViewPager(mVpNewShowLayout);

        //更新颜色
        mTabNewTitleLayout.setTabTextColors(Color.parseColor("#333333"),Color.parseColor("#CE2D24"));
        mTabNewTitleLayout.setSelectedTabIndicatorColor(Color.parseColor("#CE2D24"));

        //设置模式
        //滚动方法
        //        mTabNewTitleLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //填充
        mTabNewTitleLayout.setTabMode(TabLayout.MODE_FIXED);


    }

    @OnClick({R.id.lawoffice_name, R.id.register_money, R.id.register_date, R.id.lawyer_num})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lawoffice_name:
                break;
            case R.id.register_money:
                break;
            case R.id.register_date:
                break;
            case R.id.lawyer_num:
                break;
        }
    }

}

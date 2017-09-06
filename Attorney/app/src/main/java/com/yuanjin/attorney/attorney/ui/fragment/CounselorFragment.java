package com.yuanjin.attorney.attorney.ui.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yuanjin.attorney.attorney.R;
import com.yuanjin.attorney.attorney.adapter.Case_CaseAdapter;
import com.yuanjin.attorney.attorney.bean.FragmentInfo;
import com.yuanjin.attorney.attorney.ui.activity.SearchActivity;
import com.yuanjin.attorney.attorney.utils.SpUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Chan on 2017/8/21.
 */

public class CounselorFragment extends BaseFragment {
    @Bind(R.id.iv_search_box)
    ImageView mIvSearchBox;
    @Bind(R.id.tab_new_title_layout)
    TabLayout mTabNewTitleLayout;
    @Bind(R.id.vp_new_show_layout)
    ViewPager mVpNewShowLayout;

    private List<FragmentInfo> mShowItems = new ArrayList<>();
    private TabLayout.Tab mTabAt;
    private View mTabView;
    private TabLayout.Tab mTab;


    public Fragment getFragment(){

        return this;

    }




    @Override
    protected View createSuccessView() {
        View view = View.inflate(getContext(), R.layout.view_counselor, null);
        ButterKnife.bind(this,view);
        init();
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        //跳转指定tablayout
        String seek_more = SpUtils.getString(getContext(), "seek_more", "1");


        if (seek_more.equals("1") ) {

            mVpNewShowLayout.setCurrentItem(0);
        } else {

            mVpNewShowLayout.setCurrentItem(1);
        }


    }

    private void init() {
        FragmentInfo fragmentInfo = new FragmentInfo();
        //显示的fragment
        fragmentInfo.fragment = new Counselor_LawOfficeFragment();
        fragmentInfo.title = "律所";
        mShowItems.add(fragmentInfo);
        FragmentInfo fragmentInfo2 = new FragmentInfo();
        //显示的fragment
        fragmentInfo2.fragment = new Counselor_LawyerFragment();
        fragmentInfo2.title = "律师";
        mShowItems.add(fragmentInfo2);

        //如果初始化
        //第二层的fragment管理器永远用getChildFragmentManager()
        Case_CaseAdapter adapter= new Case_CaseAdapter(getChildFragmentManager(),mShowItems);
        mVpNewShowLayout.setAdapter(adapter);

        mTabNewTitleLayout.setupWithViewPager(mVpNewShowLayout);

        //更新颜色
        mTabNewTitleLayout.setTabTextColors(Color.parseColor("#333333"),Color.parseColor("#CE2D24"));
        mTabNewTitleLayout.setSelectedTabIndicatorColor(Color.parseColor("#CE2D24"));

        //设置模式
        //滚动方法
        //        mTabNewTitleLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //填充
        mTabNewTitleLayout.setTabMode(TabLayout.MODE_FIXED);


        TabLayout.Tab mTabAt0 = mTabNewTitleLayout.getTabAt(0);
        mTabAt0.setCustomView(mVpNewShowLayout.getChildAt(0));

        TabLayout.Tab mTabAt1 = mTabNewTitleLayout.getTabAt(1);
        mTabAt1.setCustomView(mVpNewShowLayout.getChildAt(1));




    }

    public void dd(){
        for (int i = 0; i < mTabNewTitleLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabNewTitleLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(mVpNewShowLayout.getChildAt(0));
                if (tab.getCustomView() != null) {
                    View tabView = (View) tab.getCustomView().getParent();
                    tabView.setTag(i);

                }
            }
        }

    }





    public void seek(){
        //跳转指定tablayout
        String seek_more = SpUtils.getString(getContext(), "seek_more", "1");
        if (seek_more.equals("1") ) {
            mTab = mTabNewTitleLayout.getTabAt(0);
            if (mTab != null) {
                mTab.setCustomView(mVpNewShowLayout.getChildAt(0));
                if (mTab.getCustomView() != null) {
                    mTabView = (View) mTab.getCustomView().getParent();
                    mTabView.setTag(0);

                }
            }

            mVpNewShowLayout.setCurrentItem(0);
        }else{

            mTab = mTabNewTitleLayout.getTabAt(1);
            if (mTab != null) {
                mTab.setCustomView(mVpNewShowLayout.getChildAt(1));
                if (mTab.getCustomView() != null) {
                    mTabView = (View) mTab.getCustomView().getParent();
                    mTabView.setTag(1);

                }
            }

            mVpNewShowLayout.setCurrentItem(1);
        }


    }

    @Override
    protected Object requestData() {
        return "";
    }

    @OnClick(R.id.iv_search_box)
    public void onViewClicked() {
        getContext().startActivity(new Intent(getContext(), SearchActivity.class));
    }


    @Override
    public void onStart() {
        super.onStart();
        mTabNewTitleLayout.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(mTabNewTitleLayout, 50, 50);
            }
        });
    }

    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }


    }
}

package com.yuanjin.attorney.attorney.ui.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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

import static com.yuanjin.attorney.attorney.R.id.radioGroup;
import static com.yuanjin.attorney.attorney.R.id.tab_new_title_layout;

/**
 * Created by Chan on 2017/8/21.
 */

public class CaseFragment extends BaseFragment {
    @Bind(R.id.iv_search_box)
    ImageView  mIvSearchBox;
    @Bind(tab_new_title_layout)
    TabLayout  mTabNewTitleLayout;
    @Bind(R.id.vp_new_show_layout)
    ViewPager  mVpNewShowLayout;
    @Bind(radioGroup)
    RadioGroup mRadioGroup;

    private List<FragmentInfo> mShowItems = new ArrayList<>();
    private View mView;

    @Override
    protected View createSuccessView() {
        mView = View.inflate(getContext(), R.layout.view_case, null);
        ButterKnife.bind(this, mView);


        init();
        return mView;
    }

    private void init() {


        FragmentInfo fragmentInfo = new FragmentInfo();
        //显示的fragment
        fragmentInfo.fragment = new Case_CaseFragment();
        fragmentInfo.title = "案例";
        mShowItems.add(fragmentInfo);
        FragmentInfo fragmentInfo2 = new FragmentInfo();
        //显示的fragment
        fragmentInfo2.fragment = new Case_AskFragment();
        fragmentInfo2.title = "问答库";
        mShowItems.add(fragmentInfo2);

        //如果初始化
        //第二层的fragment管理器永远用getChildFragmentManager()
        mVpNewShowLayout.setAdapter(new Case_CaseAdapter(getChildFragmentManager(), mShowItems));

        mTabNewTitleLayout.setupWithViewPager(mVpNewShowLayout);

        //更新颜色
        mTabNewTitleLayout.setTabTextColors(Color.parseColor("#333333"), Color.parseColor("#CE2D24"));
        mTabNewTitleLayout.setSelectedTabIndicatorColor(Color.parseColor("#CE2D24"));

        //设置模式
        //滚动方法
        //        mTabNewTitleLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //填充
        mTabNewTitleLayout.setTabMode(TabLayout.MODE_FIXED);


        //
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                //                ToastUtils.ToastShow(getContext(), "checkedId:" + checkedId);
                selectRadioBtn();
            }
        });


        //找到指定tablayout
        TabLayout.Tab mTabAt1 = mTabNewTitleLayout.getTabAt(1);
        mTabAt1.setCustomView(mVpNewShowLayout.getChildAt(1));
        TabLayout.Tab mTabAt2 = mTabNewTitleLayout.getTabAt(0);
        mTabAt1.setCustomView(mVpNewShowLayout.getChildAt(0));

    }

    private void selectRadioBtn() {
        RadioButton radioButton = (RadioButton) mView.findViewById(mRadioGroup.getCheckedRadioButtonId());

        SpUtils.saveString(getContext(), "case_radiobutton", radioButton.getText().toString());

        //        ToastUtils.ToastShow(getContext(), radioButton.getText().toString());
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    //每次切换fragment走setCurrentItem方法
    @Override
    public void onResume() {
        super.onResume();
        boolean isClickToFragment = SpUtils.getBoolean(getContext(), "isClickToFragment", false);
        if (isClickToFragment) {
            mVpNewShowLayout.setCurrentItem(1);
        } else {
            mVpNewShowLayout.setCurrentItem(0);
        }
        SpUtils.saveBoolean(getContext(), "isClickToFragment", false);
    }
}

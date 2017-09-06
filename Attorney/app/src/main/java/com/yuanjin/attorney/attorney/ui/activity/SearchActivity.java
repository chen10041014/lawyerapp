package com.yuanjin.attorney.attorney.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yuanjin.attorney.attorney.R;
import com.yuanjin.attorney.attorney.adapter.SearchAdapter;
import com.yuanjin.attorney.attorney.bean.FragmentInfo;
import com.yuanjin.attorney.attorney.ui.fragment.SearchAskFragment;
import com.yuanjin.attorney.attorney.ui.fragment.SearchCaseFragment;
import com.yuanjin.attorney.attorney.ui.fragment.SearchLawOfficeFragment;
import com.yuanjin.attorney.attorney.ui.fragment.SearchLawyerFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity {


    @Bind(R.id.iv_search)
    TextView       mIvSearch;
    @Bind(R.id.edit_query)
    EditText       mEditQuery;
    @Bind(R.id.rl_search)
    RelativeLayout mRlSearch;
    @Bind(R.id.tv_search_or_cancel)
    TextView       mTvSearchOrCancel;
    @Bind(R.id.tab_new_title_layout)
    TabLayout      mTabNewTitleLayout;
    @Bind(R.id.vp_new_show_layout)
    ViewPager      mVpNewShowLayout;

    private List<FragmentInfo> mShowItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initView();
    }

    //初始化tablayout
    private void initView() {

        FragmentInfo fragmentInfo2 = new FragmentInfo();
        fragmentInfo2.fragment = new SearchCaseFragment();
        fragmentInfo2.title = "案例";
        mShowItems.add(fragmentInfo2);

        FragmentInfo fragmentInfo = new FragmentInfo();
        fragmentInfo.fragment = new SearchLawyerFragment();
        fragmentInfo.title = "律师";
        mShowItems.add(fragmentInfo);
        FragmentInfo fragmentInfo1 = new FragmentInfo();
        fragmentInfo1.fragment = new SearchLawOfficeFragment();
        fragmentInfo1.title = "律所";
        mShowItems.add(fragmentInfo1);

        FragmentInfo fragmentInfo3 = new FragmentInfo();
        fragmentInfo3.fragment = new SearchAskFragment();
        fragmentInfo3.title = "问答";
        mShowItems.add(fragmentInfo3);

        mVpNewShowLayout.setAdapter(new SearchAdapter(getSupportFragmentManager(), mShowItems));

        mTabNewTitleLayout.setupWithViewPager(mVpNewShowLayout);

        mTabNewTitleLayout.setTabMode(TabLayout.MODE_FIXED);


    }

    @OnClick({R.id.iv_search, R.id.edit_query, R.id.rl_search, R.id.tv_search_or_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_search:
                break;
            case R.id.edit_query:
                mEditQuery.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        System.out.println("count=" + count);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if (s.length() == 0) {
                            mTvSearchOrCancel.setText("取消");
                        } else {
                            mTvSearchOrCancel.setText("搜索");
                        }

                    }
                });
                break;
            case R.id.rl_search:
                break;
            case R.id.tv_search_or_cancel:
                if (mTvSearchOrCancel.getText().toString().equals("搜索")) {
                    searchContent();
                } else if (mTvSearchOrCancel.getText().toString().equals("取消")) {
                    finish();
                }

        }
    }
    //搜索输入内容
    private void searchContent() {


    }


}

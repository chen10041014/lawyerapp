package com.yuanjin.attorney.attorney.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuanjin.attorney.attorney.R;
import com.yuanjin.attorney.attorney.adapter.Case_CaseAdapter;
import com.yuanjin.attorney.attorney.adapter.UserEvaluateAdapter;
import com.yuanjin.attorney.attorney.bean.FragmentInfo;
import com.yuanjin.attorney.attorney.ui.fragment.Case_AskFragment;
import com.yuanjin.attorney.attorney.ui.fragment.LawyerDetail_CaseDistributionFragment;
import com.yuanjin.attorney.attorney.ui.fragment.LawyerDetail_CaseNumFragment;
import com.yuanjin.attorney.attorney.ui.view.ContentViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class LawyerDetailActivity extends BaseActivity {

    @Bind(R.id.arrow_back)
    ImageView mArrowBack;
    @Bind(R.id.lawyer_name)
    TextView  mLawyerName;
    @Bind(R.id.lawoffice_name)
    TextView  mLawofficeName;
    @Bind(R.id.lawyer_form)
    TextView  mLawyerForm;
    @Bind(R.id.lawyer_gender)
    TextView  mLawyerGender;
    @Bind(R.id.lawyer_age)
    TextView  mLawyerAge;
    @Bind(R.id.work_age)
    TextView  mWorkAge;
    @Bind(R.id.phone_num)
    TextView  mPhoneNum;
    @Bind(R.id.tab_new_title_layout)
    TabLayout mTabNewTitleLayout;

    @Bind(R.id.lawoffice_logo)
    CircleImageView  mLawofficeLogo;
    @Bind(R.id.vp_new_show_layout)
    ContentViewPager mVpNewShowLayout;
/*    @Bind(R.id.vp_new_show_layout)
    CustomViewpager mVpNewShowLayout;*/


    private List<FragmentInfo>  mShowItems           = new ArrayList<>();
    private UserEvaluateAdapter mUserEvaluateAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyer_detail);
        ButterKnife.bind(this);
        initNet();
        initView();
    }

    private void initNet() {

    }

    private void initView() {
        FragmentInfo fragmentInfo = new FragmentInfo();
        //显示的fragment
        fragmentInfo.fragment = new LawyerDetail_CaseDistributionFragment(/*mVpNewShowLayout*/);
        fragmentInfo.title = "案件分布";
        mShowItems.add(fragmentInfo);
        FragmentInfo fragmentInfo2 = new FragmentInfo();
        //显示的fragment
        fragmentInfo2.fragment = new LawyerDetail_CaseNumFragment(/*mVpNewShowLayout*/);
        fragmentInfo2.title = "案件数";
        mShowItems.add(fragmentInfo2);
        FragmentInfo fragmentInfo3 = new FragmentInfo();
        //显示的fragment
        fragmentInfo3.fragment = new Case_AskFragment();
        fragmentInfo3.title = "咨询量";
        mShowItems.add(fragmentInfo3);

        //如果初始化
        //第二层的fragment管理器永远用getChildFragmentManager()
        mVpNewShowLayout.setAdapter(new Case_CaseAdapter(getSupportFragmentManager(), mShowItems));

        mTabNewTitleLayout.setupWithViewPager(mVpNewShowLayout);

        //更新颜色
        mTabNewTitleLayout.setTabTextColors(Color.parseColor("#333333"), Color.parseColor("#CE2D24"));
        mTabNewTitleLayout.setSelectedTabIndicatorColor(Color.parseColor("#CE2D24"));

        //设置模式
        //滚动方法
        //        mTabNewTitleLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //填充
        mTabNewTitleLayout.setTabMode(TabLayout.MODE_FIXED);

        //用户评价列表
   /*     if (mUserEvaluateAdapter == null) {
            mUserEvaluateAdapter = new UserEvaluateAdapter(this);
        }
        mLvUserEvaluate.setAdapter(mUserEvaluateAdapter);*/
    }


    @OnClick({R.id.arrow_back, R.id.phone_num})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.arrow_back:
                finish();
                break;
            case R.id.phone_num:
                //不提示用户直接拨打电话   不推荐
              /*  Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + 12345));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ToastUtils.ToastShow(this,"没有权限");
                    return;
                }
                startActivity(intent);*/

                //跳转到拨号界面
                String number = mPhoneNum.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + number);
                intent.setData(data);
                startActivity(intent);

                break;

        }
    }

}

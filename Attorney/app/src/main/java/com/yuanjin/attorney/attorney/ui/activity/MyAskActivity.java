package com.yuanjin.attorney.attorney.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.yuanjin.attorney.attorney.R;
import com.yuanjin.attorney.attorney.adapter.ToAnswer_Adapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyAskActivity extends BaseActivity {

    private static final int REQUEST_PERMISSION_CAMERA = 1;
    @Bind(R.id.iv_toanswer)
    ImageView mIvToanswer;
    @Bind(R.id.tv_toanswer)
    TextView  mTvToanswer;
    @Bind(R.id.iv_alreadyanswer)
    ImageView mIvAlreadyanswer;
    @Bind(R.id.tv_alreadyanswer)
    TextView  mTvAlreadyanswer;
    @Bind(R.id.iv_cancel)
    ImageView mIvCancel;
    @Bind(R.id.tv_cancel)
    TextView  mTvCancel;
    @Bind(R.id.lv_toanswer)
    ListView  mLvToanswer;
    private ToAnswer_Adapter mToAnswer_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ask);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        toAnswerList();
    }

    @OnClick({R.id.tv_toanswer, R.id.tv_alreadyanswer, R.id.tv_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_toanswer:
                mIvToanswer.setVisibility(View.VISIBLE);
                mTvToanswer.setTextColor(Color.parseColor("#ffffff"));
                mIvAlreadyanswer.setVisibility(View.INVISIBLE);
                mTvAlreadyanswer.setTextColor(Color.parseColor("#333333"));
                mIvCancel.setVisibility(View.INVISIBLE);
                mTvCancel.setTextColor(Color.parseColor("#333333"));
                toAnswerList();
                break;
            case R.id.tv_alreadyanswer:
                mIvAlreadyanswer.setVisibility(View.VISIBLE);
                mTvAlreadyanswer.setTextColor(Color.parseColor("#ffffff"));
                mIvToanswer.setVisibility(View.INVISIBLE);
                mTvToanswer.setTextColor(Color.parseColor("#333333"));
                mIvCancel.setVisibility(View.INVISIBLE);
                mTvCancel.setTextColor(Color.parseColor("#333333"));
                alreadyAnswerList();
                break;
            case R.id.tv_cancel:
                mIvCancel.setVisibility(View.VISIBLE);
                mTvCancel.setTextColor(Color.parseColor("#ffffff"));
                mIvAlreadyanswer.setVisibility(View.INVISIBLE);
                mTvAlreadyanswer.setTextColor(Color.parseColor("#333333"));
                mIvToanswer.setVisibility(View.INVISIBLE);
                mTvToanswer.setTextColor(Color.parseColor("#333333"));
                cancelAnswerList();
                break;
        }
    }

    //取消回答
    private void cancelAnswerList() {
        //动态权限申请
       /* if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PermissionChecker.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},REQUEST_PERMISSION_CAMERA);
            return;
        }*/
    }

    //已解答
    private void alreadyAnswerList() {

    }

    //待回答
    private void toAnswerList() {
        mToAnswer_adapter = new ToAnswer_Adapter(this);
        mLvToanswer.setAdapter(mToAnswer_adapter);
        mToAnswer_adapter.notifyDataSetChanged();
    }
}

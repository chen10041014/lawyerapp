package com.yuanjin.attorney.attorney.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.yuanjin.attorney.attorney.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Lawyer_EvaluateActivity extends BaseActivity {

    @Bind(R.id.arrow_back)
    ImageView mArrowBack;
    @Bind(R.id.order)
    ImageView mOrder;
    @Bind(R.id.lv_user_evaluate)
    ListView  mLvUserEvaluate;
    @Bind(R.id.et_user_evaluate)
    EditText  mEtUserEvaluate;
    @Bind(R.id.send_avaluate)
    TextView  mSendAvalutae;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyer__evaluate);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.arrow_back, R.id.order, R.id.send_avaluate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.arrow_back:
                finish();
                break;
            case R.id.order:
                order();
                break;
            case R.id.send_avaluate:
                sendAvaluate();
                break;
        }
    }
    //发送评论
    private void sendAvaluate() {
        String content = mEtUserEvaluate.getText().toString();

    }

    //按条件排序
    private void order() {


    }
}

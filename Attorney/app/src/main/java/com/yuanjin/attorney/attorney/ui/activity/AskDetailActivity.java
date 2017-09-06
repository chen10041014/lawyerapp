package com.yuanjin.attorney.attorney.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuanjin.attorney.attorney.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AskDetailActivity extends BaseActivity {

    @Bind(R.id.arrow_back)
    ImageView mArrowBack;
    @Bind(R.id.collection_star)
    ImageView mCollectionStar;
    @Bind(R.id.asker_name)
    TextView  mAskerName;
    @Bind(R.id.asker_time)
    TextView  mAskerTime;
    @Bind(R.id.asker_content)
    TextView  mAskerContent;
    @Bind(R.id.asker_pic)
    ImageView mAskerPic;
    @Bind(R.id.asker_date)
    TextView  mAskerDate;
    @Bind(R.id.attention_num)
    TextView  mAttentionNum;
    @Bind(R.id.lawoffice_icon)
    ImageView mLawofficeIcon;
    @Bind(R.id.lawoffice_name)
    TextView  mLawofficeName;
    @Bind(R.id.call_phone)
    TextView  mCallPhone;
    @Bind(R.id.answer_content)
    TextView  mAnswerContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_detail);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {


    }

    @OnClick({R.id.arrow_back, R.id.collection_star, R.id.call_phone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.arrow_back:
                finish();
                break;
            case R.id.collection_star:
                collection();
                break;
            case R.id.call_phone:
                callphone();
                break;
        }
    }


    //打电话给律所
    private void callphone() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel" + ""));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }

    //收藏问答详情
    private void collection() {


    }
}

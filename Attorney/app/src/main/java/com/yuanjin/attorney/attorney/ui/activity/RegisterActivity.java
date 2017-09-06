package com.yuanjin.attorney.attorney.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yuanjin.attorney.attorney.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.phone_num)
    EditText  mPhoneNum;
    @Bind(R.id.auth_num)
    EditText  mAuthNum;
    @Bind(R.id.getauth_num)
    TextView  mGetauthNum;
    @Bind(R.id.password)
    EditText  mPassword;
    @Bind(R.id.register)
    Button    mRegister;
    @Bind(R.id.auth_item)
    TextView  mAuthItem;
    private String mPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {



    }

    @OnClick({R.id.iv_back, R.id.getauth_num, R.id.register, R.id.auth_item})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.getauth_num:
                mPhone = mPhoneNum.getText().toString();
                getAuthNum();
                break;
            case R.id.register:
                register();
                break;
            case R.id.auth_item:

                break;
        }
    }

    //获取验证码
    private void getAuthNum() {
        Toast.makeText(this, mPhone, Toast.LENGTH_SHORT).show();
    }

    //注册
    private void register() {


    }


}

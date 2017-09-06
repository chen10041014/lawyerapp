package com.yuanjin.attorney.attorney.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuanjin.attorney.attorney.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.register)
    TextView  mRegister;
    @Bind(R.id.phone_num)
    EditText  mPhoneNum;
    @Bind(R.id.password)
    EditText  mPassword;
    @Bind(R.id.login)
    Button    mLogin;
    @Bind(R.id.reset_password)
    TextView  mResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

    }

    @OnClick({R.id.iv_back, R.id.register, R.id.login, R.id.reset_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.register:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.login:

                break;
            case R.id.reset_password:

                break;
        }
    }
}

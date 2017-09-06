package com.yuanjin.attorney.attorney.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.content.PermissionChecker;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.yuanjin.attorney.attorney.R;
import com.yuanjin.attorney.attorney.ui.fragment.CaseFragment;
import com.yuanjin.attorney.attorney.ui.fragment.CounselorFragment;
import com.yuanjin.attorney.attorney.ui.fragment.HomeFragment1;
import com.yuanjin.attorney.attorney.ui.fragment.MineFragment;
import com.yuanjin.attorney.attorney.utils.ToastUtils;

public class MainActivity extends BaseActivity {

    private static final int REQUEST_PERMISSION_LOCATION  = 1;
    private static final int REQUEST_PERMISSION_READWRITE = 2;
    private String[] mTitles                              = {"首页","案例库","顾问","我的"};
    private int[] mImageViewArray                         = {R.drawable.tab_icon_home, R.drawable.tab_icon_case, R.drawable.tab_icon_counselor, R.drawable.tab_icon_mine};
    public FragmentTabHost mFragmentTabHost;
    private Class[] mFragmentArray = {HomeFragment1.class, CaseFragment.class, CounselorFragment.class, MineFragment.class};
    private SearchView mSearchView;
    private long mFirstClickTime = 0;
    private TabHost.TabSpec mTabSpec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initView();

    }

    private void init() {
        //沉浸式状态栏
/*
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // 这个属性4.4算是全透明（有的机子是过渡形式的透明），5.0就是半透明了 我的模拟器、真机都是半透明，
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {// 4.4 全透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {// 5.0 全透明实现
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#CE2D24"));// calculateStatusColor(Color.WHITE, (int) alphaValue)
        }*/



        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PermissionChecker.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_PERMISSION_LOCATION);
//            return;
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PermissionChecker.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSION_READWRITE);
        }
    }

    private void initView() {

        mFragmentTabHost = (FragmentTabHost) findViewById(R.id.ftab_main_bottom_layout);
        mFragmentTabHost.setup(this, getSupportFragmentManager(), R.id.fl_main_show_layout);
        mFragmentTabHost.getTabWidget().setDividerDrawable(null);

        for (int i = 0; i < mTitles.length; i++) {
            //为每一个Tab按钮设置图标、文字和内容
            mTabSpec = mFragmentTabHost.newTabSpec(mTitles[i]).setIndicator(getTabItemView(i));
            //将Tab按钮添加进Tab选项卡中
            System.out.println(mTabSpec.getTag()+"tag");
            mFragmentTabHost.addTab(mTabSpec, mFragmentArray[i], null);
        }
    }


    //跳转指定fragment
    public void chanceFragment(int index){
        mFragmentTabHost.setCurrentTab(2);
        FragmentManager fragmentManager=getSupportFragmentManager();
        CounselorFragment fragmentByTag = (CounselorFragment) fragmentManager.findFragmentByTag("顾问");
        fragmentByTag.seek();

        mFragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                CounselorFragment fragmentByTag = (CounselorFragment) fragmentManager.findFragmentByTag("顾问");
                fragmentByTag.seek();

            }
        });

    }



    //跳转指定标签页的fragment
    public void changeAppointFragment(String tag) {
//        Fragment lawyer = getFragmentManager().findFragmentByTag("律师");
        mFragmentTabHost.setCurrentTabByTag(tag);


    }




    //fragmenttabhost
    private View getTabItemView(int index) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_item_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);

        imageView.setImageResource(mImageViewArray[index]);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTitles[index]);

        return view;
    }

    //双击退出
    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - mFirstClickTime < 2000) {
            finish();
        } else {
            ToastUtils.ToastShow(this,"再次点击退出");
        }
        mFirstClickTime = System.currentTimeMillis();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }



    //收到权限授权结果时被回调
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_LOCATION) {
//            ToastUtils.ToastShow(this, "授权了");

        } else {
//            ToastUtils.ToastShow(this,"拒绝了该权限请求");
        }

    }
}

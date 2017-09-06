package com.yuanjin.attorney.attorney.ui.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.yuanjin.attorney.attorney.R;
import com.yuanjin.attorney.attorney.utils.ThreadUtil;

import java.util.List;


public abstract class LoadView extends FrameLayout{


    private View mLoading;
    private View mSuccess;
    private View mError;
    private Button mBtn_reload;

    public LoadView(@NonNull Context context) {

        this(context, null);
    }

    public LoadView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();
    }

    private void initView() {

        mLoading = View.inflate(getContext(), R.layout.page_loading, null);

        mSuccess = getSuccess();

        mError = View.inflate(getContext(), R.layout.page_error, null);

        mBtn_reload = (Button) mError.findViewById(R.id.btn_reload);

        mBtn_reload.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showpage();
            }
        });

        this.addView(mLoading);
        this.addView(mSuccess);
        this.addView(mError);


        changView();

        showpage();


    }

    public  void showpage() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                Object obj = getNetData();

                mLoad = checkData(obj);

                ThreadUtil.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        changView();


                    }
                });


            }
        }).start();


    }

    private load checkData(Object obj) {
        if (obj == null){

            return load.error;

        }else if(obj instanceof List){

            List list = (List) obj;

            if (list.size() > 0){

                return load.success;

            }else {

                return load.error;

            }

        }else {

            return load.success;

        }
    }

    protected abstract Object getNetData();

    private void changView() {

        mLoading.setVisibility(View.GONE);
        mSuccess.setVisibility(View.GONE);
        mError.setVisibility(View.GONE);


        switch (mLoad) {


            case loading:
                mLoading.setVisibility(View.VISIBLE);
                break;
            case success:
                mSuccess.setVisibility(View.VISIBLE);
                break;
            case error:
                mError.setVisibility(View.VISIBLE);
                break;


        }


    }

    public abstract View getSuccess();

    private load mLoad = load.loading;

    public enum load {
        loading, success, error

    }
}

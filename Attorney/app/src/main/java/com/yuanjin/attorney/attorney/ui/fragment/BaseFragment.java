package com.yuanjin.attorney.attorney.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuanjin.attorney.attorney.ui.view.LoadView;

/**
 * Created by Chan on 2017/8/21.
 */

public abstract class BaseFragment extends Fragment {

    private LoadView mLoadPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //        System.out.println("fragmentStart");

        if (mLoadPager == null) {

            mLoadPager = new LoadView(container.getContext()) {

                @Override
                protected Object getNetData() {
                    return requestData();
                }

                @Override
                public View getSuccess() {
                    return createSuccessView();
                }

            };

        }

        return mLoadPager;
    }

    protected abstract View createSuccessView();

    protected abstract Object requestData();


    public void showpage() {

        mLoadPager.showpage();

    }
}

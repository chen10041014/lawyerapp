package com.yuanjin.attorney.attorney.ui.fragment;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Chan on 2017/8/21.
 */

public class HomeSeekLawyer extends BaseFragment {
    @Override
    protected View createSuccessView() {
        TextView tv = new TextView(getContext());
        tv.setText("找律师");
        return tv;
    }

    @Override
    protected Object requestData() {
        return "";
    }
}

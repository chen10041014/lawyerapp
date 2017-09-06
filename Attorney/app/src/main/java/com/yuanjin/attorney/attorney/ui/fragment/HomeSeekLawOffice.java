package com.yuanjin.attorney.attorney.ui.fragment;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Chan on 2017/8/21.
 */

public class HomeSeekLawOffice extends BaseFragment {
    @Override
    protected View createSuccessView() {
        TextView tv = new TextView(getContext());
        tv.setText("找律所");
        return tv;
    }

    @Override
    protected Object requestData() {
        return "";
    }
}

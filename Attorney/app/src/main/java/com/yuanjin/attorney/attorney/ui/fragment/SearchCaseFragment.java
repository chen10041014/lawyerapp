package com.yuanjin.attorney.attorney.ui.fragment;

import android.view.View;
import android.widget.ListView;

import com.yuanjin.attorney.attorney.R;
import com.yuanjin.attorney.attorney.adapter.SearchCase_Adapter;

/**
 * Created by Chan on 2017/8/22.
 */

public class SearchCaseFragment extends BaseFragment {
    @Override
    protected View createSuccessView() {
        View view = View.inflate(getContext(), R.layout.search_search_case, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        ListView lv_searchCase = (ListView) view.findViewById(R.id.lv_search_case);
        lv_searchCase.setAdapter(new SearchCase_Adapter(getContext()));

    }

    @Override
    protected Object requestData() {
        return "";
    }
}

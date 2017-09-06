package com.yuanjin.attorney.attorney.ui.fragment;

import android.view.View;
import android.widget.ListView;

import com.yuanjin.attorney.attorney.R;
import com.yuanjin.attorney.attorney.adapter.SearchAsk_Adapter;

/**
 * Created by Chan on 2017/8/22.
 */

public class SearchAskFragment extends BaseFragment {
    @Override
    protected View createSuccessView() {
        View view = View.inflate(getContext(), R.layout.search_search_ask, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        ListView lv_searchAsk = (ListView) view.findViewById(R.id.lv_search_ask);
        lv_searchAsk.setAdapter(new SearchAsk_Adapter(getContext()));
    }

    @Override
    protected Object requestData() {
        return "";
    }
}

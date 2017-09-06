package com.yuanjin.attorney.attorney.ui.fragment;

import android.view.View;
import android.widget.ListView;

import com.yuanjin.attorney.attorney.R;
import com.yuanjin.attorney.attorney.adapter.LawyerDetail_Adapter;

/**
 * Created by Chan on 2017/8/22.
 */

public class SearchLawyerFragment extends BaseFragment {

    private LawyerDetail_Adapter mAdapter;

    @Override
    protected View createSuccessView() {
        View view = View.inflate(getContext(), R.layout.search_search_lawyer, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        ListView lv_searchLawyer = (ListView) view.findViewById(R.id.lv_search_lawyer);
        mAdapter = new LawyerDetail_Adapter(getContext());
        lv_searchLawyer.setAdapter(mAdapter);
    }

    @Override
    protected Object requestData() {
        return "";
    }
}

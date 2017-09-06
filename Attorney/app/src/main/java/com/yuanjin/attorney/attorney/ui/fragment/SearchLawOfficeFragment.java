package com.yuanjin.attorney.attorney.ui.fragment;

import android.view.View;
import android.widget.ListView;

import com.yuanjin.attorney.attorney.R;
import com.yuanjin.attorney.attorney.adapter.LawofficeDetail_Adapter;

/**
 * Created by Chan on 2017/8/22.
 */

public class SearchLawOfficeFragment extends BaseFragment {

    private LawofficeDetail_Adapter mAdapter;

    @Override
    protected View createSuccessView() {
        View view = View.inflate(getContext(), R.layout.search_search_lawoffice, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        ListView lv_searchLawoffice = (ListView) view.findViewById(R.id.lv_search_lawoffice);
        mAdapter = new LawofficeDetail_Adapter(getContext());
        lv_searchLawoffice.setAdapter(mAdapter);

    }

    @Override
    protected Object requestData() {
        return "";
    }
}

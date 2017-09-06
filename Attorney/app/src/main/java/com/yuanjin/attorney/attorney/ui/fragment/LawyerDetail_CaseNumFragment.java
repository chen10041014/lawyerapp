package com.yuanjin.attorney.attorney.ui.fragment;

import android.annotation.SuppressLint;
import android.view.View;

import com.yuanjin.attorney.attorney.R;
import com.yuanjin.attorney.attorney.adapter.SearchCase_Adapter;
import com.yuanjin.attorney.attorney.ui.view.CustomViewpager;
import com.yuanjin.attorney.attorney.ui.view.MyListView;

import butterknife.ButterKnife;

/**
 * Created by Chan on 2017/9/5.
 */

public class LawyerDetail_CaseNumFragment extends BaseFragment {

    private CustomViewpager vp;

    public LawyerDetail_CaseNumFragment() {
    }

    @SuppressLint("ValidFragment")
    public LawyerDetail_CaseNumFragment(CustomViewpager vp) {
        this.vp = vp;
    }

    @Override
    protected View createSuccessView() {
        View view = View.inflate(getContext(), R.layout.lawofficedatail_casenum, null);
        ButterKnife.bind(this, view);
        initView(view);
//        vp.setObjectForPosition(view,1);
        return view;
    }

    private void initView(View view) {
      /*  PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.rv_caseNum);
        pullToRefreshRecyclerView.setAdapter(new Case_ask_Adapter(getContext()));*/

        MyListView myListView = (MyListView) view.findViewById(R.id.lv_caseNum);
        myListView.setAdapter(new SearchCase_Adapter(getContext()));
    }

    @Override
    protected Object requestData() {
        return "";
    }


}

package com.yuanjin.attorney.attorney.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.yuanjin.attorney.attorney.R;
import com.yuanjin.attorney.attorney.adapter.Case_ask_Adapter;
import com.yuanjin.attorney.attorney.utils.ToastUtils;

/**
 * Created by Chan on 2017/8/23.
 */

public class Case_AskFragment extends BaseFragment implements PullToRefreshListener {
    private SwipeRefreshLayout        mRefreshLayout;
    private RecyclerView              mRecycleView;
    private int                       mLastVisibleItemPosition;
    private PullToRefreshRecyclerView mPullToRefresh;
    private Case_ask_Adapter mCase_ask_adapter = new Case_ask_Adapter(getContext());

    @Override
    protected View createSuccessView() {
        View view = View.inflate(getContext(), R.layout.view_case_ask, null);
        init(view);
        return view;
    }

    private void init(View view) {
        mPullToRefresh = (PullToRefreshRecyclerView) view.findViewById(R.id.pull2refresh);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //        mPullToRefresh.addItemDecoration(new RecycleViewDivider(getContext(),LinearLayoutManager.VERTICAL,10,getResources().getColor(R.color.color_red)));
        mPullToRefresh.setLayoutManager(layoutManager);
        mPullToRefresh.setAdapter(mCase_ask_adapter);
        mPullToRefresh.setPullRefreshEnabled(true);
        mPullToRefresh.setLoadingMoreEnabled(true);
        mPullToRefresh.setPullToRefreshListener(this);




       /* mRecycleView = (RecyclerView) view.findViewById(R.id.recycleview);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        mRecycleView.setAdapter(null);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });

        mRecycleView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ToastUtils.ToastShow(getContext(),"上拉加载");
                        }
                    }, 2000);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mRecycleView.getLayoutManager();
                mLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            }
        });*/
    }

    @Override
    protected Object requestData() {


        return "";
    }

    @Override
    public void onRefresh() {
        mPullToRefresh.postDelayed(new Runnable() {
            @Override
            public void run() {
                ToastUtils.ToastShow(getContext(), "下拉刷新");
            }
        }, 3000);
        mPullToRefresh.setRefreshComplete();
    }

    @Override
    public void onLoadMore() {
        mPullToRefresh.postDelayed(new Runnable() {
            @Override
            public void run() {
                ToastUtils.ToastShow(getContext(), "上拉加载");
            }
        }, 2000);
        mPullToRefresh.setLoadMoreComplete();
    }
}

package com.yuanjin.attorney.attorney.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.yuanjin.attorney.attorney.R;
import com.yuanjin.attorney.attorney.adapter.LawofficeDetail_Adapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Chan on 2017/8/23.
 */

public class Counselor_LawOfficeFragment extends BaseFragment {
    @Bind(R.id.main_sp1)
    Spinner  mMainSp1;
    @Bind(R.id.main_sp2)
    Spinner  mMainSp2;
    @Bind(R.id.main_sp3)
    Spinner  mMainSp3;
    @Bind(R.id.lv_lawoffice_detail)
    ListView mLvLawofficeDetail;

    private List<String> data_list1;
    private List<String> data_list2;
    private List<String> data_list3;

    private BaseAdapter arr_adapter;//适配器

    @Override
    protected View createSuccessView() {
        View view = View.inflate(getContext(), R.layout.view_counselor_lawoffice, null);
        ButterKnife.bind(this, view);
        initData();
        initAdapter();
        setListener();

        return view;
    }

    private void setListener() {
        //设置监听事件，将来商家列表的排序都在这里面处理
        mMainSp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getContext(), "点击了" + data_list1.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mMainSp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getContext(), "点击了" + data_list2.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mMainSp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getContext(), "点击了" + data_list3.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    protected Object requestData() {
        return "";
    }

    private void initAdapter() {
        //适配器
        arr_adapter = new MyAdapter(data_list1);
        mMainSp1.setAdapter(arr_adapter);

        //适配器
        arr_adapter = new MyAdapter(data_list2);
        mMainSp2.setAdapter(arr_adapter);

        //适配器
        arr_adapter = new MyAdapter(data_list3);
        mMainSp3.setAdapter(arr_adapter);

        mLvLawofficeDetail.setAdapter(new LawofficeDetail_Adapter(getContext()));

    }

    //设置数据来源，这个要在网络获取。由于数据不会太多，不再考虑性能优化问题
    private void initData() {
        //数据
        data_list1 = new ArrayList<>();
        data_list1.add("地区");
        data_list1.add("北京");
        data_list1.add("上海");
        data_list1.add("广州");
        data_list1.add("深圳");

        //数据
        data_list2 = new ArrayList<>();
        data_list2.add("擅长");
        data_list2.add("婚姻继承");
        data_list2.add("合同纠纷");
        data_list2.add("法律纠纷");

        //数据
        data_list3 = new ArrayList<>();
        data_list3.add("智能排序");
        data_list3.add("好评优先");
        data_list3.add("离我最近");




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    //适配器
    class MyAdapter extends BaseAdapter {
        private LayoutInflater mLayoutInflater;
        private List<String>   mDataList;

        MyAdapter(List<String> dataList) {
            this.mDataList = dataList;
            mLayoutInflater = LayoutInflater.from(getContext());
        }

        @Override
        public int getCount() {
            return mDataList.size();
        }

        @Override
        public Object getItem(int position) {
            return mDataList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        //数据不太多，没有使用ViewHolder进行处理。
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(getContext(), R.layout.item_main, null);
            TextView textView = (TextView) convertView.findViewById(R.id.item_main_tv);
            textView.setText(mDataList.get(position));
            return convertView;
        }
    }


}

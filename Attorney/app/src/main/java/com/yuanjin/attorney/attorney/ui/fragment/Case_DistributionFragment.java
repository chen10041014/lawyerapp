package com.yuanjin.attorney.attorney.ui.fragment;

import android.view.View;

import com.don.pieviewlibrary.PercentPieView;
import com.yuanjin.attorney.attorney.R;

/**
 * Created by Chan on 2017/9/1.
 */

public class Case_DistributionFragment extends BaseFragment {




    @Override
    protected View createSuccessView() {
        View view = View.inflate(getContext(), R.layout.custom_pieview, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
   /*     PieChartView pieChartView = (PieChartView) view.findViewById(R.id.pie_chart);
        List<PieChartView.PieceDataHolder> pieceDataHolders = new ArrayList<>();
        pieceDataHolders.add(new PieChartView.PieceDataHolder(1,Color.RED, "今天"));
        pieceDataHolders.add(new PieChartView.PieceDataHolder(10, 0xFF11AA33, "明天"));
        pieceDataHolders.add(new PieChartView.PieceDataHolder(12, Color.GRAY, "就是风"));


        pieChartView.setData(pieceDataHolders);*/

        int[] data = new int[]{15, 20, 30, 35};
        String[] name = new String[]{"兄弟", "姐妹", "情侣", "基友"};
        int[] color = new int[]{
                getResources().getColor(R.color.blue),
                getResources().getColor(R.color.list_divider_color),
                getResources().getColor(R.color.yellow),
                getResources().getColor(R.color.red)};

        PercentPieView pieView = (PercentPieView) view.findViewById(R.id.pieView2);
        //设置指定颜色
        pieView.setData(data, name, color);

   /*     PercentPieView pieView2 = (PercentPieView) view.findViewById(R.id.pieView2);
        //使用随机颜色
        pieView2.setData(data, name);*/

    }

    @Override
    protected Object requestData() {
        return "";
    }
}

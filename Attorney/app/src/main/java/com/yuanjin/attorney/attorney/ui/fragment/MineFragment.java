package com.yuanjin.attorney.attorney.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;

import com.yuanjin.attorney.attorney.R;

/**
 * Created by Chan on 2017/8/21.
 */

public class MineFragment extends BaseFragment {
    @Override
    protected View createSuccessView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_mine, null);

        return view;
    }

    @Override
    protected Object requestData() {
/*
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("count","1")
                .build();
        Request request = new Request.Builder()
                .url(BASE_URL+"/v1/home/getbanner")
                .post(body)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });
*/

        return "";
    }
}

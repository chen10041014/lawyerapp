package com.yuanjin.attorney.attorney.cachemanager;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Chan on 2017/6/21.
 */

public class NetManager {

    public static String netGet(String url){

        try {
            OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

            Request request = new Request.Builder()
                    .get()
                    .url(url)
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            String content = response.body().string();
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

}

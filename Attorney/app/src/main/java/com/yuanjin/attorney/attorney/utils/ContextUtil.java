package com.yuanjin.attorney.attorney.utils;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by Chan on 2017/8/22.
 */

public class ContextUtil extends Application {
    public static Context context;
    public static Handler mainHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        mainHandler = new Handler();
    }
}

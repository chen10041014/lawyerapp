package com.yuanjin.attorney.attorney.utils;

import android.content.res.Resources;


/**
 * Created by sy_heima on 2016/10/8.
 */

public class Utils {
    //这个是在主线程去更新ui,在没有上下文的环境,
    public static void runOnUIThread(Runnable runnable)
    {
        ContextUtil.mainHandler.post(runnable);
    }

    //得到资源管理的类
    public static Resources getResources()
    {
        return ContextUtil.context.getResources();
    }

    //在屏幕适配时候使用,让代码中使用dip属性
    public static int getDimens(int resId)
    {

        return getResources().getDimensionPixelSize(resId);
    }

    //得到颜色
    public static int getColor(int resId)
    {
        return getResources().getColor(resId);
    }

    //得到字符串数组信息
    public static String[] getStringArray(int resId)
    {
        return getResources().getStringArray(resId);
    }
}

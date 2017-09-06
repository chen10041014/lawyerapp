package com.yuanjin.attorney.attorney.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.yuanjin.attorney.attorney.constant.Constants;


/**
 * Created by Administrator on 2017-09-02.
 *
 * @创建者 admin
 * @描述
 * @创建时间 2017-09-02 9:03
 * @更新描述
 */

public class SpUtils {

    private static SharedPreferences sp;

    public static void saveBoolean(Context context, String key, boolean value) {


        if (sp == null) {
            sp = context.getSharedPreferences(Constants.SPPATH, Context.MODE_PRIVATE);
        }

        sp.edit().putBoolean(key, value).commit();

    }


    public static boolean getBoolean(Context context, String key, boolean defValue) {


        if (sp == null) {
            sp = context.getSharedPreferences(Constants.SPPATH, Context.MODE_PRIVATE);
        }


        boolean value = sp.getBoolean(key, defValue);

        return value;

    }


    public static void saveString(Context context, String key, String value) {


        if (sp == null) {
            sp = context.getSharedPreferences(Constants.SPPATH, Context.MODE_PRIVATE);
        }
        sp.edit().putString(key, value).commit();

    }


    public static String getString(Context context, String key, String defValue) {

        if (sp == null) {
            sp = context.getSharedPreferences(Constants.SPPATH, Context.MODE_PRIVATE);
        }


        String value = sp.getString(key, defValue);

        return value;

    }
}
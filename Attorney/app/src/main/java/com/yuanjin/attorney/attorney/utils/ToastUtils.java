package com.yuanjin.attorney.attorney.utils;

import android.content.Context;
import android.widget.Toast;


public class ToastUtils {

    public static Toast toast;

    public static void ToastShow(Context context, String msg) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        }
        toast.setText(msg);
        toast.show();

    }


}
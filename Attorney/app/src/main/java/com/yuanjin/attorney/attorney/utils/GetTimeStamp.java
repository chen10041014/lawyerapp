package com.yuanjin.attorney.attorney.utils;

/**
 * Created by Chan on 2017/9/4.
 */

public class GetTimeStamp {

    public static String getTime(){

        long time = System.currentTimeMillis() / 1000;//获取系统时间的10位的时间戳

        String  str=String.valueOf(time);

        return str;

    }
}

package com.yuanjin.attorney.attorney.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 猩猩系列
 * 描述.
 */

public class GetTimeUtil {
    public static String getTime(String pubData) {
        //设置时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date pubD = sdf.parse(pubData);
            Date currentData = new Date();//得到当前时间的 秒数
            long time = currentData.getTime() - pubD.getTime();

            long day = time / (24 * 60 * 60 * 1000);
            long hour = time / (60 * 60 * 1000) - day * 24;
            long min = time / (60 * 1000) - day * 24 * 60 - hour * 60;
            long sec = time / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60;

            if (day >= 365) {
                return day / 365 + "年前";
            } else if (day >= 30) {
                return day / 30 + "个月前";
            } else if (day > 0) {
                return day + "天前";
            } else if (hour > 0) {
                if (hour == 24) {
                    return "1天前";
                } else {
                    return hour + "小时前";
                }
            } else if (min > 0) {
                if (min == 60) {
                    return "1小时";
                } else {
                    return min + "分钟前";
                }
            } else if (sec > 0) {
                if (sec == 60) {
                    return "1分钟前";
                } else {
                    return sec + "秒前";
                }
            } else {
                return "刚刚";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

}



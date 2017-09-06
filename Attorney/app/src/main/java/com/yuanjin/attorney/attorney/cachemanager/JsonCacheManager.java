package com.yuanjin.attorney.attorney.cachemanager;

import android.text.TextUtils;

import com.yuanjin.attorney.attorney.utils.GsonUtil;

import java.util.List;

/**
 * Created by Chan on 2017/6/21.
 */

public class JsonCacheManager {

    public static<T> T getBeanObj(String url, Class<T> clazz) {
        //请求网络数据
        //判断当前数据是否为空,为空则缓存获取数据
        //不为空则保存数据
        //解析json对象并返回

        String content = NetManager.netGet(url);
        if (TextUtils.isEmpty(content)) {
            //数据为空,缓存拿数据
            content = CacheManager.getData(url);
        } else {
            //不为空,保存数据
            CacheManager.saveData(content,url);
        }


        if (TextUtils.isEmpty(content)) {
            //缓存也没有数据返回空
            return null;
        } else {
            //返回保存数据
            return GsonUtil.parseJsonToBean(content, clazz);
        }


    }    public static<T> List<T> getListObj(String url, Class<T> clazz) {
        //请求网络数据
        //判断当前数据是否为空,为空则缓存获取数据
        //不为空则保存数据
        //解析json对象并返回

        String content = NetManager.netGet(url);
        if (TextUtils.isEmpty(content)) {
            //数据为空,缓存拿数据
            content = CacheManager.getData(url);
        } else {
            //不为空,保存数据
            CacheManager.saveData(content,url);
        }


        if (TextUtils.isEmpty(content)) {
            //缓存也没有数据返回空
            return null;
        } else {
            //返回保存数据
            return GsonUtil.fromJsonArray(content,clazz);
        }
    }
}

package com.yuanjin.attorney.attorney.cachemanager;

import android.os.Environment;

import com.yuanjin.attorney.attorney.utils.ContextUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Chan on 2017/6/21.
 */

public class CacheManager {


    private static File mDir;

    //保存缓存数据
    public static void saveData(String json,String url){


        String dirpath = Environment.getExternalStorageDirectory().getPath() + File.separator + ContextUtil.context.getPackageName() + File.separator + "cache";
        mDir = new File(dirpath);
        if (!mDir.exists()) {
            mDir.mkdirs();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(mDir, getFileName(url)));
            fileOutputStream.write(json.getBytes());
        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    //缓存拿数据
    public static String getData(String url){
        FileInputStream fileInputStream = null;
        StringBuffer sb = new StringBuffer();
        try {
            fileInputStream = new FileInputStream(new File(mDir, getFileName(url)));
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    private static String getFileName(String url) {
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(url.getBytes());
            byte[] bytes = messageDigest.digest();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toHexString(bytes[i]&0xFF));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

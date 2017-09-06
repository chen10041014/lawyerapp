package com.yuanjin.attorney.attorney.utils;

import java.security.MessageDigest;

/**
 * Created by Chan on 2017/9/4.
 */

public class MD5Utils {

    public static String getMD5(String str){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
//            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = (str+"b#M6k)3J").toCharArray();
        byte[] byteArray = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

/*    public static String getMD5(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        //md
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //加密
            messageDigest.update((string+"b#M6k)3J").getBytes());

            //得到加密后的数据
            byte[] bytes = messageDigest.digest();
            for (int i = 0; i < bytes.length; i++) {
                //System.out.println(Integer.toHexString(bytes[i]&0xFF));
                stringBuffer.append(Integer.toHexString(bytes[i] & 0xFF));
            }

            return stringBuffer.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }*/
}

package com.zhong.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MD5 {


    public static String encoderByMd5(String str) {
        //确定计算方法
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Base64.Encoder encoder = Base64.getEncoder();
        String code = null;
        try {
            code = new String(md5.digest(code.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //加密后的字符串
        return code;
    }

}
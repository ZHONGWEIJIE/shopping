package com.zhong.utils;


import java.util.UUID;

public class IdGen {

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        System.out.println(uuid());
    }
}
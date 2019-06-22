package com.zhong.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderGen {

    /*
    生成订单号
     */
    public static String orderId() {
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMdd");
        Random random = new Random();
        DecimalFormat df = new DecimalFormat("000000");
        return format.format(new Date())+df.format(random.nextInt(1000000))+new Date().getTime();
    }
    public static void main(String [] agrs){

    }
}

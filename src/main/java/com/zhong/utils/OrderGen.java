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

    public static String RandomEmailCode() {
        Random random = new Random();
        String str = "";
        for (int i = 0; i < 6; i++){
            int key = random.nextInt(3);
            switch (key){
                case 0:
                    int code1 = random.nextInt(10);
                    str += code1;
                    break;
                case 1:
                    char code2 = (char)(random.nextInt(26)+65);
                    str += code2;
                    break;
                case 2:
                    char code3 = (char)(random.nextInt(26)+97);
                    str += code3;
                    break;
            }
        }
        return str;
    }

}

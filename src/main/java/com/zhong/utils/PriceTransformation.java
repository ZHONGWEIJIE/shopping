package com.zhong.utils;

public class PriceTransformation {

    /**
     * 元变成分
     * @param price
     * @return
     */
    public static int  YuanToBranch(double price) {
        double p = price*100;
        return (int)p;
    }

    /**
     * 分转换成元
     * @param price
     * @return
     */
    public static double  BranchToYuan(int price) {
        double p = price;
        return p/100;
    }

}

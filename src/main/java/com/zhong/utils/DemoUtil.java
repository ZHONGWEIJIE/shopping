package com.zhong.utils;

import java.util.UUID;

public class DemoUtil {

    /**
     * 页面长度
     */
    public static final Integer PAGE_SIZE = 9;

    /**
     * 随机生成loginToken序列
     *
     * @return String
     */
    public static String createRandomCode() {
        return System.currentTimeMillis() +
                UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取当前页数
     *
     * @param allCount 所有记录
     * @return 当前页数
     */
    public static Integer getPageNum(int allCount) {
        Double num = Math.ceil(allCount * 1.0 / PAGE_SIZE);
        return num.intValue();
    }

}

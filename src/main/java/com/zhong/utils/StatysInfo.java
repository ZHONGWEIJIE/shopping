package com.zhong.utils;

public class StatysInfo {

    /**
     *  存放用户提示
     */

    private String detail ;
    /**
     * 存放接口处理失败时的详细错误信息
     */
    private String message ;


    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public StatysInfo(String detail) {
        this.detail = detail;
        this.message="";
    }

    public StatysInfo(String detail, String message) {
        this.detail = detail;
        this.message = message;
    }

    public StatysInfo() {
        this.detail = "";
        this.message="";
    }
}

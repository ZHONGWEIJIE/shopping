package com.zhong.utils;


import java.util.Map;

public class Result {

    /**
     * 状态code和状态message，200就是成功，500就是服务器异常，400+就是调用端异常
     */
    public final static String SUCCESS_CODE = "200";
    public final static String SUCCESS_MESSAGE = "Request Success";

    public final static String EXCEPTION_CODE = "500";
    public final static String EXCEPTION_MESSAGE = "Server Exception";

    public final static String FAIL_CODE = "400";
    public final static String FAIL_MESSAGE = "Request Fail";

    public final static String ACCESS_DENIED_CODE= "401";
    public final static String ACCESS_DENIED_MESSAGE = "Access Denied";

    public final static String PERMISSION_DENIED_CODE = "403";
    public final static String PERMISSION_DENIED_MESSAGE = "Permission Denied";
    public final static String DATA_PERMISSION_DENIED_MESSAGE = "Data Permission Denied";

    public final static String VALIDATE_FALI_CODE = "402";
    public final static String VALIDATE_FALI_MESSAGE = "Validate Failed";

    public final static String DATA_MISSING_CODE ="499";
    public final static String DATA_MISSING_MESSAGE = "Data Missing";

    private String statusCode;

    private String message;

    private Map<String, Object> resultMap;

    /**
     * 重载多种返回Result
     */
    public static Result makeResult(String statusCode, String message) {
        return new Result(statusCode, message, null);
    }

    public static Result makeResult(String statusCode, String message, Map<String, Object> resultMap) {
        return new Result(statusCode, message, resultMap);
    }

    /**
     * 返回成功Result
     */
    public static Result makeSuccessResult(Map<String, Object> resultMap) {
        return new Result(SUCCESS_CODE, SUCCESS_MESSAGE, resultMap);
    }

    public static Result makeSuccessResult(){
        return new Result(SUCCESS_CODE, SUCCESS_MESSAGE,null);
    }

    public static Result makeSuccessResult(String message){
        return new Result(SUCCESS_CODE, message, null);
    }

    /**
     * 返回失败Result
     */
    public static Result makeFailResult() {
        return new Result(FAIL_CODE, FAIL_MESSAGE, null);
    }

    public static Result makeFailResult(String message) {
        return new Result(FAIL_CODE, message, null);
    }

    /**
     * 返回异常Result
     */
    public static Result makeExcpetionResult() {
        return new Result(EXCEPTION_CODE, EXCEPTION_MESSAGE, null);
    }

    /**
     * 返回权限拒绝result
     */
    public static Result makePermissionDeniedResult(){
        return new Result(PERMISSION_DENIED_CODE,PERMISSION_DENIED_MESSAGE,null);
    }

    public static Result makePermissionDeniedResult(String message){
        return new Result(PERMISSION_DENIED_CODE,message,null);
    }

    public static Result makeDataPermissionDeniedResult(){
        return new Result(PERMISSION_DENIED_CODE,DATA_PERMISSION_DENIED_MESSAGE,null);
    }

    /**
     * 数据丢失result
     * @return
     */
    public static Result makeDataMissingResult(){
        return new Result(DATA_MISSING_CODE,DATA_MISSING_MESSAGE,null);
    }

    /**
     * 返回拒绝访问result
     */
    public static Result makeAccessDenied(){
        return new Result(ACCESS_DENIED_CODE,ACCESS_DENIED_MESSAGE,null);
    }
    public static Result makeAccessDenied(String message){
        return new Result(ACCESS_DENIED_CODE,message,null);
    }
    /**
     * 验证失败
     */
    public static Result makeValidateFail(Map<String, Object> resultMap,String message){
        return new Result(VALIDATE_FALI_CODE,message,resultMap);
    }

    /**
     * 限制不可以实例对象
     */
    private Result() {

    }

    /**
     * 构造方法
     * @param statusCode
     * @param message

     */
    private Result(String statusCode, String message, Map<String, Object> resultMap) {
        super();
        this.statusCode = statusCode;
        this.message = message;
        this.resultMap = resultMap;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

}

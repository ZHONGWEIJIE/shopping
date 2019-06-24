package com.zhong.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderDto {

    private String  orderNo;            /*订单号*/
    private String nickName;        /* 用户昵称*/
    private String receiverName;    /*收件人*/
    private String address;         /*收货地址*/
    private String mobile;          /*联系电话*/
    private String productName;     /*商品*/
    private String detail;          /*商品规格*/
    private int quantity;           /*购买数量*/
    private double price;           /*金额*/
    private int status;             /*订单状态*/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;      /*更新时间*/

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderNo=" + orderNo +
                ", nickName='" + nickName + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", productName='" + productName + '\'' +
                ", detail='" + detail + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", status=" + status +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}

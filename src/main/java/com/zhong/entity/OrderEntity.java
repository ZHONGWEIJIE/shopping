package com.zhong.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.DateOnlyTypeHandler;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Alias("OrderEntity")
public class OrderEntity {

    private int id;             /*订单id*/
    private int orderNo;       /*订单号*/
    private User userId;        /*用户id*/
    private Shipping shippingId;    /*商品id*/
    private int payment;        /*钱，单位是分*/
    private int paymentType;    /*支付类型，1为在线支付*/
    private int postage;        /*运费，单位是分*/
    private int status;         /*订单状态0-取消 10-未支付 20-已支付 40-已发货 50-交易成功 60-交易关闭*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date paymentTime;   /*支付时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date sendTime;      /*发货时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date endTime;       /*交易完成时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date closeTime;     /*交易关闭时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;    /*创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updateTime;    /*更新时间*/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Shipping getShippingId() {
        return shippingId;
    }

    public void setShippingId(Shipping shippingId) {
        this.shippingId = shippingId;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public int getPostage() {
        return postage;
    }

    public void setPostage(int postage) {
        this.postage = postage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", orderNo=" + orderNo +
                ", userId=" + userId +
                ", shippingId=" + shippingId +
                ", payment=" + payment +
                ", paymentType=" + paymentType +
                ", postage=" + postage +
                ", status=" + status +
                ", paymentTime=" + paymentTime +
                ", sendTime=" + sendTime +
                ", endTime=" + endTime +
                ", closeTime=" + closeTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

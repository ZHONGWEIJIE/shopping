package com.zhong.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("PayInfoEntity")
public class PayInfo {
    private int id;
    private int userId;
    private OrderEntity orderNo;
    private int payPlatform;
    private String platformNumber;
    private String platformStatus;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public OrderEntity getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(OrderEntity orderNo) {
        this.orderNo = orderNo;
    }

    public int getPayPlatform() {
        return payPlatform;
    }

    public void setPayPlatform(int payPlatform) {
        this.payPlatform = payPlatform;
    }

    public String getPlatformNumber() {
        return platformNumber;
    }

    public void setPlatformNumber(String platformNumber) {
        this.platformNumber = platformNumber;
    }

    public String getPlatformStatus() {
        return platformStatus;
    }

    public void setPlatformStatus(String platformStatus) {
        this.platformStatus = platformStatus;
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
        return "PayInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderNo=" + orderNo +
                ", payPlatform=" + payPlatform +
                ", platformNumber='" + platformNumber + '\'' +
                ", platformStatus='" + platformStatus + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

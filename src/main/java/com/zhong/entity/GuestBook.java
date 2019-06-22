package com.zhong.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class    GuestBook {
    private int id;
    private  String askContent;
    private int userId;
    private int ProductId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;
    private int isReply;
    private String replyContent;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date replyTime;
    private int adminId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAskContent() {
        return askContent;
    }

    public void setAskContent(String askContent) {
        this.askContent = askContent;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public int getIsReply() {
        return isReply;
    }

    public void setIsReply(int isReply) {
        this.isReply = isReply;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "GuestBook{" +
                "id=" + id +
                ", askContent='" + askContent + '\'' +
                ", userId=" + userId +
                ", ProductId=" + ProductId +
                ", createdTime=" + createdTime +
                ", isReply=" + isReply +
                ", replyContent='" + replyContent + '\'' +
                ", replyTime=" + replyTime +
                ", adminId=" + adminId +
                '}';
    }
}

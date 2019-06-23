package com.zhong.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias(value="GuestBookEntity")
public class GuestBook {
    private String id;
    private  String askContent;
    private User userId;
    private Product productId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;
    private int isReply;
    private String replyContent;
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date replyTime;
    private String adminId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAskContent() {
        return askContent;
    }

    public void setAskContent(String askContent) {
        this.askContent = askContent;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
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

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "GuestBook{" +
                "id='" + id + '\'' +
                ", askContent='" + askContent + '\'' +
                ", userId=" + userId +
                ", ProductId=" + productId +
                ", createdTime=" + createdTime +
                ", isReply=" + isReply +
                ", replyContent='" + replyContent + '\'' +
                ", replyTime=" + replyTime +
                ", adminId='" + adminId + '\'' +
                '}';
    }

    public GuestBook(String id, String askContent, User userId, Product productId, Date createdTime, int isReply, String replyContent, Date replyTime, String adminId) {
        this.id = id;
        this.askContent = askContent;
        this.userId = userId;
        productId = productId;
        this.createdTime = createdTime;
        this.isReply = isReply;
        this.replyContent = replyContent;
        this.replyTime = replyTime;
        this.adminId = adminId;
    }

    public GuestBook() {
    }
}

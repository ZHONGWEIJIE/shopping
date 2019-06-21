package com.zhong.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GuestBook {
    private int id;
    private  String askContent;
    private User userId;
    private Product ProductId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;
    private int isReply;
    private String replyContent;
    private Date replyTime;
    private int adminId;

}

package com.zhong.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * 分类表
 */
@Alias("CategoryEntity")
public class Category {
    private String id;
    /** 类别id 当id=0时说明是根节点，一级类别*/
    private String parentId;
    private String name;
    /** 类别状态1-正常 2-已放弃*/
    private short status;
    /**排序序号，同类展示顺序，数值相同则自然排序*/
    private int sortOrder;
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date udateTime;

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", sortOrder=" + sortOrder +
                ", createTime=" + createTime +
                ", udateTime=" + udateTime +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUdateTime() {
        return udateTime;
    }

    public void setUdateTime(Date udateTime) {
        this.udateTime = udateTime;
    }

    public Category(String id, String parentId, String name, short status, int sortOrder, Date createTime, Date udateTime) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.status = status;
        this.sortOrder = sortOrder;
        this.createTime = createTime;
        this.udateTime = udateTime;
    }
}

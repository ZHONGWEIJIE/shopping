package com.zhong.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * 订单明细表
 */

@Alias(value="OrderItemEntity")
public class OrderItem {

    private String id;                 /*id*/
    private User userId;            /*用户id*/
    private Order orderId;    /*订单id*/
    private Product productId;          /*商品id*/
    private String productName;     /*商品名称*/
    private String productImage;    /*商品图片地址*/
    private int currentPrice;       /*生成订单时的商品单价 单位的分*/
    private int quantity;           /*商品数量*/
    private int totalPrice;         /*商品总价*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;        /*创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updateTime;        /*更新时间*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
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
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", userId=" + userId +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productImage='" + productImage + '\'' +
                ", currentPrice=" + currentPrice +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public OrderItem() {
    }

    public OrderItem(String id, User userId, Order orderId, Product productId, String productName, String productImage, int currentPrice, int quantity, int totalPrice, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.currentPrice = currentPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}

package com.akina.bean;

import java.util.Date;

public class WantPay {
    private Integer id;

    private Integer userId;

    private String payPrice;

    private Integer picId;

    private Integer picPayStat;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(String payPrice) {
        this.payPrice = payPrice == null ? null : payPrice.trim();
    }

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public Integer getPicPayStat() {
        return picPayStat;
    }

    public void setPicPayStat(Integer picPayStat) {
        this.picPayStat = picPayStat;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
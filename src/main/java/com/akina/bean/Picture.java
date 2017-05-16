package com.akina.bean;

import java.util.Date;

public class Picture {
    private Integer picId;

    private String picName;

    private Integer picIspixiv;

    private String picHttpPath;

    private String picFloorPrice;

    private String picPresentPrice;

    private Integer picPlusTimes;

    private Integer picState;

    private Integer picUserId;

    private String picKey;

    private Date createTime;

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName == null ? null : picName.trim();
    }

    public Integer getPicIspixiv() {
        return picIspixiv;
    }

    public void setPicIspixiv(Integer picIspixiv) {
        this.picIspixiv = picIspixiv;
    }

    public String getPicHttpPath() {
        return picHttpPath;
    }

    public void setPicHttpPath(String picHttpPath) {
        this.picHttpPath = picHttpPath == null ? null : picHttpPath.trim();
    }

    public String getPicFloorPrice() {
        return picFloorPrice;
    }

    public void setPicFloorPrice(String picFloorPrice) {
        this.picFloorPrice = picFloorPrice == null ? null : picFloorPrice.trim();
    }

    public String getPicPresentPrice() {
        return picPresentPrice;
    }

    public void setPicPresentPrice(String picPresentPrice) {
        this.picPresentPrice = picPresentPrice == null ? null : picPresentPrice.trim();
    }

    public Integer getPicPlusTimes() {
        return picPlusTimes;
    }

    public void setPicPlusTimes(Integer picPlusTimes) {
        this.picPlusTimes = picPlusTimes;
    }

    public Integer getPicState() {
        return picState;
    }

    public void setPicState(Integer picState) {
        this.picState = picState;
    }

    public Integer getPicUserId() {
        return picUserId;
    }

    public void setPicUserId(Integer picUserId) {
        this.picUserId = picUserId;
    }

    public String getPicKey() {
        return picKey;
    }

    public void setPicKey(String picKey) {
        this.picKey = picKey == null ? null : picKey.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
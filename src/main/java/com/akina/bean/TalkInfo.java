package com.akina.bean;

import java.util.Date;

public class TalkInfo {
    private Integer talkInfoId;

    private String talkInfo;

    private Integer talkId;

    private Integer userId;

    private Integer readFlag;

    private Date createTime;

    public Integer getTalkInfoId() {
        return talkInfoId;
    }

    public void setTalkInfoId(Integer talkInfoId) {
        this.talkInfoId = talkInfoId;
    }

    public String getTalkInfo() {
        return talkInfo;
    }

    public void setTalkInfo(String talkInfo) {
        this.talkInfo = talkInfo == null ? null : talkInfo.trim();
    }

    public Integer getTalkId() {
        return talkId;
    }

    public void setTalkId(Integer talkId) {
        this.talkId = talkId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(Integer readFlag) {
        this.readFlag = readFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
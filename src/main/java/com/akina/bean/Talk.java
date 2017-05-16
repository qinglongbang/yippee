package com.akina.bean;

import java.util.Date;

public class Talk {
    private Integer talkId;

    private Integer sendUserId;

    private Integer receiveUserId;

    private Integer unreadNumber;

    private Date createTime;

    public Integer getTalkId() {
        return talkId;
    }

    public void setTalkId(Integer talkId) {
        this.talkId = talkId;
    }

    public Integer getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(Integer sendUserId) {
        this.sendUserId = sendUserId;
    }

    public Integer getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public Integer getUnreadNumber() {
        return unreadNumber;
    }

    public void setUnreadNumber(Integer unreadNumber) {
        this.unreadNumber = unreadNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
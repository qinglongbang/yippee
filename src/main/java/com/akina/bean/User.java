package com.akina.bean;

import java.util.Date;

/**
 * @Creator  Akina
 * @packge
 * @Time 2017-5-16 -  14:54
 * @Describe ： 用户实体
 */
public class User {
    private Integer userId;

    private String userName;

    private String userMail;

    private String userPwd;

    private String userAbstract;

    private String userHeadPath;

    private String userPayPath;

    private Date createTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail == null ? null : userMail.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserAbstract() {
        return userAbstract;
    }

    public void setUserAbstract(String userAbstract) {
        this.userAbstract = userAbstract == null ? null : userAbstract.trim();
    }

    public String getUserHeadPath() {
        return userHeadPath;
    }

    public void setUserHeadPath(String userHeadPath) {
        this.userHeadPath = userHeadPath == null ? null : userHeadPath.trim();
    }

    public String getUserPayPath() {
        return userPayPath;
    }

    public void setUserPayPath(String userPayPath) {
        this.userPayPath = userPayPath == null ? null : userPayPath.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public User(Integer userId, String userName, String userMail, String userPwd, String userAbstract, String userHeadPath, String userPayPath, Date createTime) {
        this.userId = userId;
        this.userName = userName;
        this.userMail = userMail;
        this.userPwd = userPwd;
        this.userAbstract = userAbstract;
        this.userHeadPath = userHeadPath;
        this.userPayPath = userPayPath;
        this.createTime = createTime;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userAbstract='" + userAbstract + '\'' +
                ", userHeadPath='" + userHeadPath + '\'' +
                ", userPayPath='" + userPayPath + '\'' +
                ", createTime=" + createTime +
                '}';
    }

     
}
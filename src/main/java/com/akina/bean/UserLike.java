package com.akina.bean;

import java.util.Date;

public class UserLike {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_like.id
     *
     * @mbggenerated Sat May 20 23:37:32 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_like.user_id
     *
     * @mbggenerated Sat May 20 23:37:32 CST 2017
     */
    private Integer userId;

    private User user;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_like.pic_id
     *
     * @mbggenerated Sat May 20 23:37:32 CST 2017
     */
    private Integer picId;
    private Picture pic;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_like.create_time
     *
     * @mbggenerated Sat May 20 23:37:32 CST 2017
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_like.id
     *
     * @return the value of user_like.id
     * @mbggenerated Sat May 20 23:37:32 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_like.id
     *
     * @param id the value for user_like.id
     * @mbggenerated Sat May 20 23:37:32 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_like.user_id
     *
     * @return the value of user_like.user_id
     * @mbggenerated Sat May 20 23:37:32 CST 2017
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_like.user_id
     *
     * @param userId the value for user_like.user_id
     * @mbggenerated Sat May 20 23:37:32 CST 2017
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_like.pic_id
     *
     * @return the value of user_like.pic_id
     * @mbggenerated Sat May 20 23:37:32 CST 2017
     */
    public Integer getPicId() {
        return picId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_like.pic_id
     *
     * @param picId the value for user_like.pic_id
     * @mbggenerated Sat May 20 23:37:32 CST 2017
     */
    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_like.create_time
     *
     * @return the value of user_like.create_time
     * @mbggenerated Sat May 20 23:37:32 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_like.create_time
     *
     * @param createTime the value for user_like.create_time
     * @mbggenerated Sat May 20 23:37:32 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Picture getPic() {
        return pic;
    }

    public void setPic(Picture pic) {
        this.pic = pic;
    }

    public UserLike(Integer id, Integer userId, Integer picId, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.picId = picId;
        this.createTime = createTime;
    }

    public UserLike() {
    }

    @Override
    public String toString() {
        return "UserLike{" +
                "id=" + id +
                ", userId=" + userId +
                ", user=" + user +
                ", picId=" + picId +
                ", pic=" + pic +
                ", createTime=" + createTime +
                '}';
    }
}
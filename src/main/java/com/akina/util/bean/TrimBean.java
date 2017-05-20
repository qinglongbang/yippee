package com.akina.util.bean;

/**
 * @Creator Akina
 * @packge
 * @Time 2017-5-16 -  16:50
 * @Describe ： 价格调整实体
 */
public class TrimBean {

    /**
     * 参与调价用户头像
     */
    private String pay_user_head_path;

    /**
     * 调整价格后的价格
     */
    private Integer now_price;

    /***
     * 调整时间
     */
    private Integer trim_times;

    public TrimBean(String pay_user_head_path, Integer now_price, Integer trim_times) {
        this.pay_user_head_path = pay_user_head_path;
        this.now_price = now_price;
        this.trim_times = trim_times;
    }

    public TrimBean() {
    }

    public String getPay_user_head_path() {
        return pay_user_head_path;
    }

    public void setPay_user_head_path(String pay_user_head_path) {
        this.pay_user_head_path = pay_user_head_path;
    }

    public Integer getNow_price() {
        return now_price;
    }

    public void setNow_price(Integer now_price) {
        this.now_price = now_price;
    }

    public Integer getTrim_times() {
        return trim_times;
    }

    public void setTrim_times(Integer trim_times) {
        this.trim_times = trim_times;
    }
}


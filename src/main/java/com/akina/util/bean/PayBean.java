package com.akina.util.bean;

/**
 * @Creator Akina
 * @packge
 * @Time 2017-5-16 -  16:50
 * @Describe ： 购买实体
 */
public class PayBean {

    private String pay_user_head_path;
    private Integer now_price;
    private Integer plus_times;


    public PayBean(String pay_user_head_path, Integer now_price, Integer plus_times) {
        this.pay_user_head_path = pay_user_head_path;
        this.now_price = now_price;
        this.plus_times = plus_times;
    }


    public PayBean() {
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

    public Integer getPlus_times() {
        return plus_times;
    }

    public void setPlus_times(Integer plus_times) {
        this.plus_times = plus_times;
    }
}


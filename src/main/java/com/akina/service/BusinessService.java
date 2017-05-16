package com.akina.service;

/**
 * @Creator Akina
 * @packge
 * @Time 2017-5-16 -  16:45
 * @Describe ： 拍卖业务接口
 */
public interface BusinessService {


    /**
     * 查询已成交数量
     *
     * @return
     */
    Integer findBusinessEd();


    /****
     * 查询拍品数量
     * @return
     */
    Integer findPicNumber();
}

package com.akina.service;

import com.akina.bean.Picture;
import com.akina.util.bean.CutPageBean;
import com.akina.util.bean.PayBean;

import java.util.List;

/**
 * @Creator Akina
 * @packge
 * @Time 2017-5-16 -  16:35
 * @Describe ： 图片业务
 */
public interface PictureService {

    /**
     * 根据喜欢还有想购买的人数查询前20  取五位随机数   返回
     *
     * @return 图片集合
     */
    List<Picture> findTopPic();


    /***
     *根据状态展示展示前5
     * @param pic_stat 图片状态
     * @return 返回查询集合
     */
    List<Picture> findPicByPram(Integer pic_stat);


    /**
     * 点赞
     *
     * @param user_id 用户id
     * @param pic_id  画id
     * @return 返回现在的点赞数
     */
    Integer likeNumber(Integer user_id, Integer pic_id);


    /***
     * 根据条件查询 画
     * @param pic_stat 画的状态
     * @param page_no  页码
     * @param s_str    搜索关键字  查询pic_name    or   user_name(画师名
     * @param time     是否按照投稿时间排序   null 不排序   true 正序   false  倒叙
     * @param like_number  是否按照喜欢人数排序
     * @param price         是都按照价格排序
     * @return
     */
    CutPageBean findPicByPageAndPram(Integer pic_stat, Integer page_no, String s_str, Boolean time, Boolean like_number, Boolean price);


    /**
     * 按照id查询
     *
     * @return 返回画实体
     */
    Picture findByid();

    /**
     * 用户后台查看自己的画
     *
     * @param page_no 页码
     * @param user_id 画师id
     * @return
     */
    CutPageBean findPicByUserId(Integer page_no, Integer user_id);


    /**
     * 用户后台查看自己买到的画
     *
     * @param page_no 页码
     * @param user_id 买家id
     * @return
     */
    CutPageBean findPicByPayUserId(Integer page_no, Integer user_id);


    /***
     * 投稿：添加pic
     * @param picture 图片
     * @return
     */
    Boolean addPic(Picture picture);


    /***
     * 提价
     * @param user_id 用户id
     * @param pic_id  画id
     * @return 返回购买实体
     */
    PayBean want_pay(Integer user_id, Integer pic_id);

    /**
     * 授予购买权限
     *
     * @param user_id
     * @return
     */
    Boolean give_pay(Integer user_id);


    

}

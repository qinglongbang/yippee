package com.akina.service;

import com.akina.bean.Comment;
import com.akina.util.bean.CutPageBean;

/**
 * @Creator Akina
 * @packge
 * @Time 2017-5-16 -  17:14
 * @Describe ： 用户评论业务
 */
public interface ICommentService {


    /**
     * 按照图片id,分页获得评论集合
     *
     * @param pic_id 图片ID
     * @param pageNum 页码
     * @return
     */
    CutPageBean findByPicId(Integer pic_id,Integer pageNum);

    /***
     * sql已经写好
     * 添加评论
     * @param comment 评论实体
     * @return
     */
    Integer addComment(Comment comment);
}

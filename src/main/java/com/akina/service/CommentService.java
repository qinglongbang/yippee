package com.akina.service;

import com.akina.bean.Comment;

import java.util.List;

/**
 * @Creator Akina
 * @packge
 * @Time 2017-5-16 -  17:14
 * @Describe ： 用户评论业务
 */
public interface CommentService {


    /**
     * 按照图片id查询评论集合
     *
     * @param pic_id
     * @return
     */
    List<Comment> findByPicId(Integer pic_id);

    /***
     * 添加评论
     * @param comment 评论实体
     * @return
     */
    Boolean addComment(Comment comment);
}

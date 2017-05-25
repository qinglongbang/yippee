package com.akina.service.impl;

import com.akina.bean.Comment;
import com.akina.mapper.CommentMapper;
import com.akina.service.ICommentService;
import com.akina.util.StaticStr;
import com.akina.util.bean.CutPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gavin on 2017/5/22.
 * @Describe ：用户评论实现
 */
@Service("commentService")
public class CommentServiceImpl implements ICommentService{
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public CutPageBean findByPicId(Integer pic_id,Integer pageNum) {
        CutPageBean page =  new CutPageBean();
        page.setDataList(commentMapper.findCommentDate((pageNum - 1) * StaticStr.PAGE_SIZE, StaticStr.PAGE_SIZE,pic_id));
        // 查询一共多少条记录
        Integer count = commentMapper.findCommentCount(pic_id);
        page.setCount(count);
        // 计算页数
        if (count % StaticStr.PAGE_SIZE == 0) {
            page.setTotalPage(count / StaticStr.PAGE_SIZE);
        } else {
            page.setTotalPage(count / StaticStr.PAGE_SIZE + 1);
        }
        return page;
    }

    @Override
    public Integer addComment(Comment comment) {
        return commentMapper.insert(comment);
    }
}

package com.akina.service;

import com.akina.bean.Talk;
import com.akina.bean.TalkInfo;

import java.util.List;

/**
 * @Creator Akina
 * @packge
 * @Time 2017-5-21 -  0:47
 * @Describe ：会话业务类
 */
public interface ITalkService {


    /***
     * 用户获取所有属于自己的会话
     * @return
     */
    List<Talk> findAll(Integer user_id);

    /***
     * 按照会话id查询 所有会话内容
     * 1.查询完成，把所属会话表记录的 unread_numberint(11)会话所属内容未读条数归零
     * @param talk_id
     * @return
     */
    List<TalkInfo> findById(Integer talk_id);

    /***
     * 发送消息
     * 1  发送完毕，把所属会话表记录的 unread_numberint(11)会话所属内容未读条数+1
     * @param info
     */
    void sendMassage(TalkInfo info);


    /**
     * 查询所有的未读消息有几条
     * 对talk的 unread_numberint字段count
     *
     * @return
     */
    Integer findUnreadNumber();


    /***
     * 删除会话以及会话所属内容
     * 1.首先按照talk_id字段删除talk_info记录
     * 2.删除talk表
     * @param talk_id
     * @return
     */
    Integer deleteTalk(Integer talk_id);
}

package com.akina.service;

import com.akina.bean.Talk;
import com.akina.bean.TalkInfo;

import java.util.List;

/**
 * Created by Akina on 2017-5-16.
 */
public interface TalkService {


    /***
     * 查询所有的会话
     * @return
     */
    List<Talk> findAll();

    /***
     * 按照会话id查询 所有对话
     * @param talk_id
     * @return
     */
    List<TalkInfo> findById(Integer talk_id);


    /**
     * 查询所有的未读消息有几条
     *
     * @return
     */
    Integer findUnreadnumber();


    /***
     * 删除会话以及会话所属内容
     * @param talk_id
     * @return
     */
    Integer deleteTalk(Integer talk_id);
}

package com.akina.mapper;

import com.akina.bean.Talk;
import org.springframework.stereotype.Component;

@Component
public interface TalkMapper {
    int deleteByPrimaryKey(Integer talkId);

    int insert(Talk record);

    int insertSelective(Talk record);

    Talk selectByPrimaryKey(Integer talkId);

    int updateByPrimaryKeySelective(Talk record);

    int updateByPrimaryKey(Talk record);
}
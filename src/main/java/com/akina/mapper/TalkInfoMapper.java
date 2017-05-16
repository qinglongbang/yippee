package com.akina.mapper;

import com.akina.bean.TalkInfo;
import org.springframework.stereotype.Component;

@Component
public interface TalkInfoMapper {
    int deleteByPrimaryKey(Integer talkInfoId);

    int insert(TalkInfo record);

    int insertSelective(TalkInfo record);

    TalkInfo selectByPrimaryKey(Integer talkInfoId);

    int updateByPrimaryKeySelective(TalkInfo record);

    int updateByPrimaryKey(TalkInfo record);
}
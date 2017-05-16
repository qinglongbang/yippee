package com.akina.mapper;

import com.akina.bean.PrivateLetter;
import org.springframework.stereotype.Component;

@Component
public interface PrivateLetterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrivateLetter record);

    int insertSelective(PrivateLetter record);

    PrivateLetter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrivateLetter record);

    int updateByPrimaryKey(PrivateLetter record);
}
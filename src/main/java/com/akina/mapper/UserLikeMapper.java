package com.akina.mapper;

import com.akina.bean. UserLike;
import org.springframework.stereotype.Component;

@Component
public interface  UserLikeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserLike record);

    int insertSelective(UserLike record);

     UserLike selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLike record);

    int updateByPrimaryKey(UserLike record);
}
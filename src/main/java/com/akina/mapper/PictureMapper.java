package com.akina.mapper;

import com.akina.bean.Picture;
import org.springframework.stereotype.Component;

@Component
public interface PictureMapper {
    int deleteByPrimaryKey(Integer picId);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(Integer picId);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}
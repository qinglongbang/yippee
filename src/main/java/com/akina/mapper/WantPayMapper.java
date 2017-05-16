package com.akina.mapper;

import com.akina.bean.WantPay;
import org.springframework.stereotype.Component;
@Component
public interface WantPayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WantPay record);

    int insertSelective(WantPay record);

    WantPay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WantPay record);

    int updateByPrimaryKey(WantPay record);
}
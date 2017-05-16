package com.akina.service;

import com.akina.bean.User;
import org.springframework.stereotype.Component;

/**
 * @Creator Akina
 * @packge
 * @Time 2017-5-16 -  13:34
 * @Describe ：用户接口
 */
public interface IUserService {

    /***
     * 按照用户 id查询
     * @param user_id
     * @return
     */
    User findById(Integer user_id);

}

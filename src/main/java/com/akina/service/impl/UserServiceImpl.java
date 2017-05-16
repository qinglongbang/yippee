package com.akina.service.impl;

import com.akina.bean.User;
import com.akina.mapper.UserMapper;
import com.akina.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Creator Akina
 * @packge
 * @Time 2017-5-16 -  12:28
 * @Describe ：用户接口实现
 */

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer user_id) {
        return userMapper.selectByPrimaryKey(user_id);
    }
}

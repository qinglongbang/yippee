package com.akina.service.impl;

import com.akina.bean.User;
import com.akina.mapper.UserMapper;
import com.akina.service.IUserService;
import com.akina.util.CommonUtil;
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
    public User Login(String mail, String pwd) {
        return userMapper.selectUserBypram(mail, CommonUtil.GetMD5(pwd));
    }

    @Override
    public User regUser(User user) {
        if (user != null) {
            userMapper.insert(user);
        }
        return user;
    }

    @Override
    public User selectUserByMail(String mail) {
        User use = userMapper.selectUserByMail(mail);
        if (use == null) {
            return null;
        }
        return use;
    }


}

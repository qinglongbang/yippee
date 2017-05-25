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
        User use = userMapper.selectUserByMail(user.getUserMail());
        if(null != null){
            userMapper.insert(user);
        }
        return use;
    }

}

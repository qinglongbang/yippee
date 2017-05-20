package com.akina.service;

import com.akina.bean.User;

/**
 * @Creator Akina
 * @packge
 * @Time 2017-5-16 -  13:34
 * @Describe ：用户接口
 */
public interface IUserService {


    /***
     * 用户登陆
     * @param mail 邮箱
     * @param pwd  密码
     * @return 返回用户对象
     *
     *
     */
    User Login(String mail, String pwd);

    /***
     * 用户注册
     * @param user  用户对象
     * @return 返回注册成功的对象 并且登陆
     *
     * 1.需要确认该邮箱是否注册
     * 2.确认验证码
     *
     */
    User regUser(User user);


}

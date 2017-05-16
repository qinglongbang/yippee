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
     * 用户登陆
     * @param mail 邮箱
     * @param pwd  密码
     * @return 返回用户对象
     */
    User Login(String mail, String pwd);

    /***
     * 用户注册
     * @param user  用户对象
     * @return 返回注册成功的对象
     */
    User regUser(User user);


    /***
     * 按照用户 id查询
     * @param user_id 用户id
     * @return
     */
    User findById(Integer user_id);

}

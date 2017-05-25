package com.akina.controller;

import com.akina.service.IUserService;
import com.akina.util.MailUtil;
import com.akina.util.StaticStr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Creator Akina
 * @packge
 * @Time 2017-5-16 -  14:55
 * @Describe ：用户控制器
 */
@Controller
@RequestMapping("user")
public class UserController {

    /**
     * 用户接口
     */
    @Autowired
    private IUserService iUserService;


    /**
     * 登录界面
     *
     * @return
     */
    @RequestMapping("login")
    public String welcome() {
        return StaticStr.USER_LOGIN;
    }


    /**
     * 跳转至个人中心页面
     *
     * @return
     */
    @RequestMapping("cente")
    public String myCente() throws Exception {
//        //测试代码
//        new MailUtil().sendSimpleMail("1601358582@qq.com", "测试", "您的验证码为123213");
        return StaticStr.USER_CENTE;
    }


    @RequestMapping("talk")
    public String talk() {
        return StaticStr.USER_TALK;
    }


    @RequestMapping("talkInfo")
    public String talkInfo() {
        return StaticStr.USER_TALK_INFO;
    }


    @RequestMapping("subm")
    public String submission() {
        return StaticStr.USER_SUBMISSION;
    }

}

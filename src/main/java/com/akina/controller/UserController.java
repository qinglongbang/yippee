package com.akina.controller;

import com.akina.service.IUserService;
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


    @RequestMapping("index")
    public String user_welcome() {
        return StaticStr.SYS_INDEX;
    }

    
}

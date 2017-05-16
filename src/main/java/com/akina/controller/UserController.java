package com.akina.controller;

import com.akina.service.IUserService;
import com.akina.util.StaticStr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Akina on 2017-5-16.
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
        System.out.println(iUserService.findById(1));
        //返回页面
        return StaticStr.SYS_INDEX;
    }
}

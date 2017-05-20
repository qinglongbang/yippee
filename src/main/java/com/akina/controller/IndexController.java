package com.akina.controller;

import com.akina.util.StaticStr;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Creator Akina
 * @packge
 * @Time 2017-5-14 -  23:34
 * @Describe ： 全系統的歡迎頁面  返回的是文字格式， 必须用RestController  注解，如果返回的是页面就要使用Controller了
 */
@Controller
public class IndexController {
    /**
     * 登录界面
     *
     * @return
     */
    @RequestMapping("login")
    public String welcome() {
        return StaticStr.USER_LOGIN;
    }
    
}

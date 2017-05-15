package com.akina.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Creator Akina
 * @packge
 * @Time 2017-5-14 -  23:34
 * @Describe ： 全系統的歡迎頁面  返回的是文字格式， 必须用RestController  注解，如果返回的是页面就要使用Controller了
 */
@Controller
public class indexController {

    private static String SYS_INDEX = "index";
    private static String WELCOME = "welcome";

    /**
     * 跳轉至歡迎頁面
     *
     * @return
     */
    @RequestMapping("/")
    public String welcome() {
        return WELCOME;
    }


    /**
     * 跳轉至主頁面
     *
     * @return
     */
    @RequestMapping("index")
    public String index(Integer id) {
        int i = 0 / 0;
        return SYS_INDEX;
    }

}

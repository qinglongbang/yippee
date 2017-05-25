package com.akina.controller;

import com.akina.util.StaticStr;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Creator Akina
 * @packge
 * @Time 2017-5-17 -  19:05
 * @Describe ： 图片控制器
 */
@Controller
@RequestMapping("pic")
public class PictureController {


    /**
     * 跳转详情页面
     *
     * @param pic_id 图片id
     * @return 图片详情页面
     */
    @RequestMapping("details")
    public String details(Integer pic_id) {
        return StaticStr.PICTURE_DETAILS;
    }


    /***
     * 跳转到列表
     * @return
     */
    @RequestMapping("list")
    public String picList() {
        return StaticStr.PIC_LIST;
    }


}

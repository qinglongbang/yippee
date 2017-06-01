package com.akina.controller;

import com.akina.bean.User;
import com.akina.service.IUserService;
import com.akina.util.MailUtil;
import com.akina.util.StaticStr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
    @Autowired
    private MailUtil mailUtil;


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

    /****
     * 登陆控制器
     *
     * @param login_mail
     * @param login_pwd
     * @return
     */
    @RequestMapping(value = "useLogin", method = RequestMethod.POST)
    public String useLogin(String login_mail, String login_pwd, HttpSession session, Model model) {
        System.out.println("进入登陆控制器");
        System.out.println(login_pwd+"进入登陆控制器"+login_mail);
        User bean = iUserService.Login(login_mail, login_pwd);
        if(null == bean){//登录失败
            model.addAttribute("errormsg", "登陆失败，请检查您的账号和密码");
            return StaticStr.USER_LOGIN;
        }else{//登陆成功
            System.out.println("登陆成功");
            session.setAttribute(StaticStr.SESSION_BEAN, bean);
            return StaticStr.SYS_INDEX;
        }
    }

    /****
     * 注册控制器
     *
     * @param reg_mail
     * @param reg_pwd
     * @return
     */
    @RequestMapping(value = "useReg", method = RequestMethod.POST)
    public String useReg(String reg_mail, String reg_pwd ,HttpSession session, Model model) {
        User use = new User();
        use.setUserMail(reg_mail);
        use.setUserPwd(reg_pwd);
        User bean = iUserService.regUser(use);
        if(null == bean){
            model.addAttribute("errormsg", "注册失败");
        }
        //这里是否要清空一下session？
        return StaticStr.USER_LOGIN;
    }

    /**
     * 验证码
     * @param reg_mail 注册邮箱
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "verifyCode", method = RequestMethod.POST)
    public Integer VerifyCode(String reg_mail,HttpSession session,Model model){
        User bean = iUserService.selectUserByMail(reg_mail);
        if(null != bean){//验证邮箱是否呗注册，好发送验证码
            return -1;
        }
        String code =  mailUtil.sendEmail(reg_mail);
        //存入会话session
        session.removeAttribute(StaticStr.SESSION_VERCODE); //删除以前的
        session.setAttribute(StaticStr.SESSION_VERCODE, code.toLowerCase());
        return 1;
    }

}

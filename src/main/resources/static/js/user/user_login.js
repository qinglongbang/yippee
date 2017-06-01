/**
 * Created by GAVIN on 2017-5-15.
 */

$(document).ready(function () {
    init();
});


function init() {
    //验证邮箱是否被注册
    $("#verifyEmail").click(function(){

        var email=$("#reg_mail").val();
        $.post("/user/verifyCode","reg_mail="+email,function(info){
            if(-1 == info){
                $("#mail_msg").css('color','red');
                $("#mail_msg").html("邮箱已被注册");
            }else {
                $("#mail_msg").html("邮箱");
            }
        },"json");

    });

    $("#subForm").click(function(){
        $.post("/user/useReg",
            {
                'reg_mail':$("#reg_mail").val(),
                'reg_pwd':$("#reg_pwd").val(),
                'reg_yanzheng':$("#reg_yanzheng").val()
            },function(info){
            if(-1 == info){
                alert("注册失败");
            }else if(0 == info){
                $("#reg_yanzheng_msg").css('color','red');
                $("#reg_yanzheng_msg").html("验证码错误");
            }else if(1 == info){
                window.location.href = "/user/login";
            }
        },"json");
        });
}
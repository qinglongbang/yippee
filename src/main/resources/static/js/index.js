/**
 * Created by Akina on 2017-5-15.
 */

$(document).ready(function () {
    init();
});


/***
 *页面初始化
 */
function init() {
    //手机菜单折叠初始化
    $(".button-collapse").sideNav();
    //初始化loading组件
    $('.modal').modal({
            dismissible: false, // 模态可以通过点击外部的模态
            opacity: 1, // 模态背景不透明度
            in_duration: 300, // 过渡期动画
            out_duration: 200, // 转型期的持续时间
            starting_top: '4%', // 启动顶部样式属性
            ending_top: '10%', //结束顶端样式属性
            ready: function (modal, trigger) {
                // 模式打开回调。模态和触发参数可用。
            },
            complete: function () {
                //模态关闭的回调
            }
        }
    );


    //打开loding
    // $('#loding').modal('open');
    //关闭loding
    //$('#loding').modal('close');
}




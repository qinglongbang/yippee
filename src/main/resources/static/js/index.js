/**
 * Created by Akina on 2017-5-15.
 */

$(document).ready(function () {
    init();
});


/***
 *  $('#loading').modal('open');
 *页面初始化
 */
function init() {
    //百叶窗插件初始化
    slider.init();
    // 初始化
    $('.modal').modal({
        dismissible: false,
        opacity: 0.6
    });
    //手机菜单折叠初始化
    $(".button-collapse").sideNav();
    $('.slider').slider({full_width: true});
    $('.carousel.carousel-slider').carousel({full_width: true});

}




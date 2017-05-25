/**
 * Created by Akina on 2017-5-23.
 */
$(document).ready(function () {
    init();
});


/**
 * 初始化方法
 */
function init() {
    //瀑布流插件初始化
    var $container = $('#masonry');
    $container.imagesLoaded(function () {
        $container.masonry({
            itemSelector: '.box',
            gutter:4,
            isAnimated: true,
        });
    });
    //弹出展示初始化
    $('.modal').modal();
}

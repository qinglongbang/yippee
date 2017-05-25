/**
 * Created by Akina on 2017-5-15.
 */

$(document).ready(function () {
    init();
});


function init() {
    //瀑布流插件初始化
    var $container = $('#masonry');
    $container.imagesLoaded(function () {
        $container.masonry({
            itemSelector: '.box',
            gutter: 4,
            isAnimated: true,
        });
    });
}
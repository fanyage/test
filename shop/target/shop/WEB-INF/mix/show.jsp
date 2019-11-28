<%--
  Created by IntelliJ IDEA.
  User: LZ
  Date: 2019/10/7
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mix</title>
    <link rel="stylesheet" type="text/css" href="/library/layui/css/layui.css"/>
</head>
<script src="/library/jquery-3.3.1.min.js"></script>
<script src="/library/layui/layui.all.js"></script>
<script>
    layui.config({
        base: '/library/layuinotice/dist/'
    });
    layui.use(['notice'], function () {
        var notice = layui.notice;
        notice.options = {
            closeButton: true,//显示关闭按钮
            debug: false,//启用debug
            positionClass: "toast-bottom-right",//弹出的位置
            showDuration: "300",//显示的时间
            hideDuration: "1000",//消失的时间
            timeOut: "2000",//停留的时间
            extendedTimeOut: "1000",//控制时间
            showEasing: "swing",//显示时的动画缓冲方式
            hideEasing: "linear",//消失时的动画缓冲方式
            iconClass: 'toast-info',// 自定义图标，有内置，如不需要则传空 支持layui内置图标/自定义iconfont类名
            onclick: null,//点击关闭回调
        };
    });
    layui.use(['notice'], function () {
        var notice = layui.notice;
        notice.info("你好");
    });
</script>
<script>
    function judge(){
        var asd = $("#asd").val();
        $.ajax({
            url:"/mix/judge",
            dataType:"json",
            data:{"str": asd},
            async:false,
            success:function(result){
                console.log(result);
                layui.use(['notice'], function () {
                    var notice = layui.notice;
                    notice.info(result.hi);
                });
            },error:function(error){

            }
        })
    }
</script>
<body>
<input type="text" id="asd">
<button onclick="judge()">test</button>
</body>
<script>
    var a_idx = 0;
    jQuery(document).ready(function ($) {
        $("body").click(function (e) {
            var a = new Array("富强", "民主", "文明", "和谐", "自由", "平等", "公正", "法治", "爱国", "敬业", "诚信", "友善");
            var $i = $("<span/>").text(a[a_idx]);
            a_idx = (a_idx + 1) % a.length;
            var x = e.pageX,
                y = e.pageY;
            $i.css({
                "z-index": 999999999999999999999999999999999999999999999999999999999999999999999,
                "top": y - 20,
                "left": x,
                "position": "absolute",
                "font-weight": "bold",
                "color": "#ff6651"
            });
            $("body").append($i);
            $i.animate({
                    "top": y - 180,
                    "opacity": 0
                },
                1500,
                function () {
                    $i.remove();
                });
        });
    });
</script>
</html>

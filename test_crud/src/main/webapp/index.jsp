<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/5/31
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="${PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${PATH}/static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="${PATH}/static/layui/css/layui.css">
    <script type="text/javascript" src="${PATH}/static/layui/layui.js"></script>


</head>
<body>

    <h1> test_crud </h1>

    <a href="${PATH}/emp/bootstrapUI"> bootstrap </a>

    <!-- Standard button -->
    <button type="button" class="btn btn-default">（默认样式）Default</button>

    <!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
    <button type="button" class="btn btn-primary">（首选项）Primary</button>



    <!-- 你的HTML代码 -->

    <script>
        //一般直接写在一个js文件中
        layui.use(['layer', 'form'], function(){
            var layer = layui.layer
                ,form = layui.form;

            layer.msg('Hello World');
        });
    </script>

    <a href="${PATH}/layuiController/layuiUI"> 开始你的 layui 之旅 </a>


</body>
</html>

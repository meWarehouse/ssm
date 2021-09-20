<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/6/3
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="${PATH}/statics/layui/css/layui.css" media="all">
    <script src="${PATH}/statics/layui/layui.js"></script>
    <script src="${PATH}/statics/js/jquery-3.3.1.min.js"></script>
    <script>
        layui.use('element', function () {
            var element = layui.element;
        });
    </script>

</head>


<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">

    <jsp:include page="../models/head.jsp"/>

    <jsp:include page="../models/left.jsp"/>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <form class="layui-form" action="${PATH}/login/modifyHead" method="post" enctype="multipart/form-data">
                <div class="layui-form-item">
                    <label class="layui-form-label">头像</label>
                    <div class="layui-input-inline">
                        <input type="file" name="icon" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>

        </div>

        <jsp:include page="../models/foot.jsp"/>

    </div>

</body>


</html>

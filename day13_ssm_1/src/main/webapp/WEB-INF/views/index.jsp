<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/6/3
  Time: 0:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="${PATH}/statics/layui/css/layui.css">
    <script src="${PATH}/statics/layui/layui.js"></script>
    <script type="text/javascript" src="${PATH}/statics/layui/lay/modules/jquery.js"></script>

    <script>
        //JavaScript代码区域
        layui.use('element', function () {
            var element = layui.element;
        });
    </script>

</head>


<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include page="../models/head.jsp"></jsp:include>
    <jsp:include page="../models/left.jsp"></jsp:include>

    <div class="layui-body">
        <h1 style="color: #00FF00">非权限用户无法查看</h1>
    </div>
    <jsp:include page="../models/foot.jsp"></jsp:include>
</div>
</body>


</html>

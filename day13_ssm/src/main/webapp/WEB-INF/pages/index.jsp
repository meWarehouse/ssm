<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/5/27
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="${path}/layui/css/layui.css" media="all">
    <script src="${path}/layui/layui.js"></script>
    <script src="${path}/js/jQuery-3.1.1.js"></script>

    <script>
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });
    </script>

</head>

<body class="layui-layout-body">

    <div class="layui-layout layui-layout-admin">

        <jsp:include page="../model/head.jsp"/>

        <jsp:include page="../model/left.jsp"/>

        <div class="layui-body">
            <div style="padding: 15px;">内容主体区域 </div>
        </div>

        <jsp:include page="../model/foot.jsp"/>

    </div>

</body>

</html>

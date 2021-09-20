<%--  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/6/3
  Time: 18:06
  To change this template use File | Settings | File Templates.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

        <table>
            <tr>
                <td>id：</td>
                <td>${user.id}</td>
            </tr>
            <tr>
                <td>userName：</td>
                <td>${user.userName}</td>
            </tr>
            <tr>
                <td>userPassword：</td>
                <td>${user.userPassword}</td>
            </tr>
            <tr>
                <td>birthday：</td>
                <td><f:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/></td>
            </tr>
            <tr>
                <td>gender：</td>
                <td>${user.gender}</td>
            </tr>
            <tr>
                <td>headIcon：</td>
                <td>
                    <img src="${PATH}${user.headIcon}">
                </td>
            </tr>
        </table>
    </div>
    <jsp:include page="../models/foot.jsp"></jsp:include>
</div>
</body>
</html>

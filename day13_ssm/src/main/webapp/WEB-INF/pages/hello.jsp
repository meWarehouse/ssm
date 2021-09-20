<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/5/25
  Time: 0:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="${path}/layui/css/layui.css" media="all">


    <!-- 你的HTML代码 -->

    <script src="${path}/layui/layui.js"></script>
    <script>
        //一般直接写在一个js文件中
        layui.use(['layer', 'form'], function () {
            var layer = layui.layer
                , form = layui.form;

            layer.msg('Hello World');
        });
    </script>

</head>
<body>

    <h2> springMVC Test </h2>

    <table>
        <tr>
            <td>id}</td>
            <td>lastName</td>
            <td>age</td>
            <td>gender</td>
            <td>eamil</td>
            <td>did</td>
        </tr>
        <c:forEach items="${emps}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.lastName}</td>
                <td>${emp.age}</td>
                <td>${emp.gender}</td>
                <td>${emp.email}</td>
                <td>${emp.did}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>

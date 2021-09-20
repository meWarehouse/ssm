<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/5/24
  Time: 2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <h2> 所有员工信息 </h2>

    <table>
        <tr>
            <td>ID</td>
            <td>lastName</td>
            <td>age</td>
            <td>gender</td>
            <td>email</td>
        </tr>

        <c:forEach items="${allEmps}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.lastName}</td>
                <td>${emp.age}</td>
                <td>${emp.gender}</td>
                <td>${emp.email}</td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>

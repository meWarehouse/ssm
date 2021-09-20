<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/5/18
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="user/t1" method="post">

        姓名：<input type="text" name="name" />
        年龄：<input type="text" name="age" />
        性别：<input type="text" name="gender" />

        <input type="submit" value="提交" />

    </form>

    <hr/>

    <form action="user/t2" method="post">

        <input type="hidden" value="1" name="id"/>

        <input type="submit" value="提交" />

    </form>

    <hr/>


</body>
</html>

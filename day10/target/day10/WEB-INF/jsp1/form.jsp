<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/5/17
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="t2" method="post">
        性别：<input type="text" name="gender"/><br>
        姓名：<input type="text" name="name"/><br>
        年龄：<input type="text" name="age" /><br>

        兴趣：
        <input type="checkbox" name="interests" value="lanqui" /> 篮球
        <input type="checkbox" name="interests" value="yumaoqui" /> 羽毛球
        <input type="checkbox" name="interests" value="pingpangqui" /> 乒乓球
        <input type="checkbox" name="interests" value="zuqui" /> 足球


        <input type="submit" value="提交" />
    </form>

</body>
</html>

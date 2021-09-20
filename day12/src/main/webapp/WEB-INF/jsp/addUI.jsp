<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/5/22
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="test/layui/css/layui.css"/>

    <script src="test/layui/layui.js" type="text/javascript" charset="utf-8"></script>


    <script>
        //一般直接写在一个js文件中
        layui.use(['layer', 'form'], function(){
            var layer = layui.layer
                ,form = layui.form;

            layer.msg('Hello World');
        });
    </script>

</head>
<body>

<h2> 添加操作 </h2>

<form action="add" method="post">

    lastName:<input type="text" name="name" /><br>
    age:<input type="text" name="age" /><br>
    gender:<input type="text" name="gender" /><br>

    <input type="submit" value="submit">

</form>

<a href=""> new.html </a>

</body>
</html>

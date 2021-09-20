<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/5/18
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

    <form action="upload" method="post" enctype="multipart/form-data">

        名称：<input type="text" name="name" />
        文件：<input type="file" name="file" multiple="multiple"/>

        <input type="submit" value="上传" />
    </form>


</body>
</html>

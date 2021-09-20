<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/5/11
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="stuservlet?method=get1" method="post">

        姓名：<input type="text" name="name" /><br/>
        学号：<input type="text" name="no" /><br/>
        性别：<input type="text" name="gender" /><br/>


        <input type="submit" value="点击查询" />

    </form>

    <hr/>

    <form action="stuservlet?method=get2" method="post">

        收索内容：<input type="text" name="searchContent" /><br/>
        名称：<input type="radio" name="searchType"  value="name" checked="checked"/>
        学号：<input type="radio" name="searchType"  value="no"/>


        <input type="submit" value="点击查询" />

    </form>

    <hr/>

    <form action="stuservlet?method=update" method="post">

       no:<input type="text"name="no" /><br>
       name:<input type="text"name="name" /><br>
       gender:<input type="text"name="gender" /><br>
       sid:<input type="text"name="id" /><br>


        <input type="submit" value="点击更新" />

    </form>

    <hr/>

    <form action="stuservlet?method=delete" method="post">

        输入要删除的sid：<input type="text" name="ids" />

        <input type="submit" value="点击删除" />

    </form>


</body>
</html>

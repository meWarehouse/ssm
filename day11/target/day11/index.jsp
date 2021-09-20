<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<script src="js/jQuery-3.1.1.js" type="text/javascript"></script>
<script type="text/javascript">
    
   function sendJson() {
        $.post("json/t1",{id:1},function (data) {
            alert(data);
            alert(data.name);
            alert(data.gender);
            alert(data.id);
            alert(data.birthday);


        },"json");
   }
    
</script>

<body>


    <input type="button" onclick="sendJson()" value="button" />


</body>
</html>

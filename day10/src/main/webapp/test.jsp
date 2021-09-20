<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/5/19
  Time: 0:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

	<a href="springmvc/testRestParam?username=atwen&age=11"> Test Rest
		Get</a>

	<br>
	<br>

	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT" /> <input
			type="submit" value="TestRest PUT" />
	</form>

	<br>
	<br>


	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE" /> <input
			type="submit" value="TestRest DELETE" />
	</form>

	<br>
	<br>

	<form action="springmvc/testRest" method="post">
		<input type="submit" value="TestRest POST" />
	</form>

	<br>
	<br>
	<a href="springmvc/testRest/1"> Test Rest GET </a>


</body>
</html>

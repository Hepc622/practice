<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<form action="login" method="post">
		userName:<input type="text"> <br> <br> <input
			type="submit" value="Submit">
	</form>
	<a href="result?code=1">resultLogin</a>
	<a href="result?code=2">resultSuccess</a>
	<a href="result?code=3">resultRegister</a>
	<a href="result?code=4">resultFail</a>
	<br>
	<br>
	<form action="info">
		userName:<input type="text" name="person.userName"> <br>
		<br> userSex:<input type="text" name="person.userSex"> <br>
		<br> userAge:<input type="text" name="person.userAge"> <br>
		<br> <input type="submit" value="Submit">
	</form>
	<br> URL中调用action方法：
	<a href="url_method!urlMethod.action">调用</a>
	<br>
	<form action="user_login">
		userName:<input type="text" name="person.userName"> <br>
		<br> userSex:<input type="text" name="person.userSex"> <br>
		<br> userAge:<input type="text" name="person.userAge"> <br>
		<br> <input type="submit" value="Submit">
	</form>
	<br>
	<form action="user_register">
		userName:<input type="text" name="person.userName"> <br>
		<br> userSex:<input type="text" name="person.userSex"> <br>
		<br> userAge:<input type="text" name="person.userAge"> <br>
		<br> <input type="submit" value="Submit">
	</form>
	<br>
	<a href="math">math</a>
</body>
</html>

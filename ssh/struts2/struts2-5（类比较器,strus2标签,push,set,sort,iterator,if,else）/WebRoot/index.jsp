
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
	<a href="practice-login">点击登录</a>
	<br>
	<!-- sort标签，用于将list,map,数组,进行排序 -->
	sort标签，用于将list,map,数组,进行排序
	<form action="Ognl_sort">
		userName:<input type="text" name="user.name"><br>
		userSex:<input type="text"name="user.sex"><br>
		userAge:<input type="text"name="user.age"><br>
		<input type="submit" value="Submit">
	</form>
	<br>
	<!-- iterator标签，用于遍历list,map,数组 -->
	iterator标签，用于遍历list,map,数组
	<form action="Ognl_iterator">
		userName:<input type="text" name="user.name"><br>
		userSex:<input type="text"name="user.sex"><br>
		userAge:<input type="text"name="user.age"><br>
		<input type="submit" value="Submit">
	</form>
	<br>
	<!-- if_else_if标签 -->
	if_else_if标签
	<form action="Ognl_if_else_if">
		userName:<input type="text" name="user.name"><br>
		userSex:<input type="text"name="user.sex"><br>
		userAge:<input type="text"name="user.age"><br>
		<input type="submit" value="Submit">
	</form>
	<br>
	<!-- push标签 -->
	push标签
	<form action="Ognl_push">
		userName:<input type="text" name="user.name"><br>
		userSex:<input type="text"name="user.sex"><br>
		userAge:<input type="text"name="user.age"><br>
		<input type="submit" value="Submit">
	</form>
	<br>
	<!-- set标签 -->
	set标签
	<form action="Ognl_set">
		userName:<input type="text" name="user.name"><br>
		userSex:<input type="text"name="user.sex"><br>
		userAge:<input type="text"name="user.age"><br>
		<input type="submit" value="Submit">
	</form>
	<br>
	<!-- property -->
	property
	<%
		request.setAttribute("request", request);
	%>
	<a href="Ognl_property">property</a>
	<br>
	<form action="Ognl_property">
		userName:<input type="text" name="user.name"><br>
		userSex:<input type="text"name="user.sex"><br>
		userAge:<input type="text"name="user.age"><br>
		<input type="submit" value="Submit">
	</form>
	<form action="Ognl_property">
		userName:<input type="text" name="user.name"><br>
		userSex:<input type="text"name="user.sex"><br>
		userAge:<input type="text"name="user.age"><br>
		<input type="submit" value="Submit">
	</form>
	<!-- url标签的使用 -->
	url标签的使用
	<form action="Ognl_url" method="post">
		userName:<input type="text" name="user.name"><br>
		userSex:<input type="text"name="user.sex"><br>
		userAge:<input type="text"name="user.age"><br>
		<input type="submit" value="Submit">
	</form>
	
</body>
</html>

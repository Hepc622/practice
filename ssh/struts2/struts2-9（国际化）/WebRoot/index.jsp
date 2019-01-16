<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
	<s:debug></s:debug>
	<!-- 通过设置request_locale的参数值来更改中英语言 -->
	<a href="internationalization?request_locale=zh_CN">中文</a>
	<a href="internationalization?request_locale=en_US">英文</a>
	<s:form action="internationalization" theme="simple">
		<s:text name="userName" />
		<s:textfield name="userName" key="userName"></s:textfield>
		<s:text name="password" />
		<s:textfield name="password" key="password"></s:textfield>
		<s:submit></s:submit>
	</s:form>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
	<s:fielderror name="up"></s:fielderror>
	<s:actionerror />
	<s:form action="upload" method="post" enctype="multipart/form-data"
		theme="simple">
		<s:file name="up" label="文件上传"></s:file>
		<br>
		<s:file name="up" label="文件上传"></s:file>
		<br>

		<s:file name="up" label="文件上传"></s:file>
		<br>

		<s:file name="up" label="文件上传"></s:file>
		<br>

		<s:submit />
	</s:form>
</body>
</html>

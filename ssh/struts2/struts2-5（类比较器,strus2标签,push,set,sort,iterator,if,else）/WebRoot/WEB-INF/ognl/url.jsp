<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'url.jsp' starting page</title>

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

	<s:url value="/hpc" var="myurl"></s:url>
	${myurl }
	<br>
	<br> 将参数追加到后面 ,将表单的数据自动封装好,要写param
	<br>
	<s:url value="/hpc" var="myurl">
		<!-- value就是对象栈或者是map栈它将自动解析出来 -->
		<s:param name="name" value="user.name" />
		<s:param name="sex" value="user.sex" />
		<s:param name="age" value="user.age" />
	</s:url>
	${myurl }
	<br>
	<br> 将参数追加到后面 get,就会将表单的数据自动封装好,不要写param
	<br>
	<s:url value="/hpc" var="myurl" includeParams="get">
	</s:url>
	${myurl }
	<br>
	<br> 将参数追加到后面 post,不要写param,如果想将参数显示的话就要设置includeParams为all
	<br>
	<s:url value="/hpc" var="myurl" includeParams="all">
	</s:url>
	${myurl }
	<br>
	<br>
	指namespace,action,method的url,如果写了指定的value，那将会把后面指定的给覆盖（namespace,action,method）
	<br>
	<s:url var="myurl" namespace="/test" action="url" method="save" />
	<br> ${myurl }
</body>
</html>

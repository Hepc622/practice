<%@page import="freemarker.ext.jsp.TaglibFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:debug/>
	<!-- 从request中获取数据 -->
	<s:property value="#request.request"/><br>	
	<!-- 从栈对象获取属性 -->
	Name:<s:property value="[0].user.name"/><br>	
	Sex:<s:property value="[0].user.sex"/><br>	
	Age:<s:property value="[0].user.age"/><br>
	<!-- el表达式从栈对象中获取对象 -->
	Name:${user.name }<br>
	Sex:${user.sex }<br>
	Age:${user.age }<br>
</body>
</html>
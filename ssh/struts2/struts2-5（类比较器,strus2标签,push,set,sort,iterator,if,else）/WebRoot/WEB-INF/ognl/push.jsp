<%@ page language="java" import="com.hniu.user.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:debug></s:debug>
	<%
		User user = new User();
		user.setName("lyl");
		user.setSex("women");
		user.setAge(21);
		request.setAttribute("obj", user);
	 %>
	push将一个属性压入栈中，在push标签开始压入，在push标签结束时弹栈
	<br>
	<s:push value="#request.obj">
		<s:property value="name"/>
		<s:property value="user.name"/>
	</s:push>
	
</body>
</html>
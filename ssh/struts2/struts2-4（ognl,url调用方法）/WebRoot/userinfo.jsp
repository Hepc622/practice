<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	ognl表达式 
		调用静态属性(@对象@属性名)
		调用静态方法(@对象@方法名)
	-->
	<br>
	<br> userName:
	<s:property value="person.userName" />
	<br>
	<br> userSex:
	<s:property value="person.userSex" />
	<br>
	<br> userAge:
	<s:property value="person.userAge" />
	<br> 
	<!-- el表达式 -->
	${person.userName } 
	<br>
	${person.userAge } 
	<br>
	${person.userSex }
	<br>
</body>
</html>
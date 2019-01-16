<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"
	import="org.springframework.context.ApplicationContext"
	import="com.hniu.spring.strus.bean.User"
%>
<%@ page language="java" isELIgnored="true" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(application);
		User user = ac.getBean(User.class);
		out.write(user.getName());
		
	%>
</body>
</html>
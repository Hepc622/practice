<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> 
	springmvcValid: 
	<form:form action="springmvcValid" method="POST"
		modelAttribute="employee">
		Nmae:<form:input path="name" />  
		<form:errors path="name" />
		<br>
		Sex:<form:input path="sex" />
		<form:errors  path="sex" />
		<br>
		Age:<form:input path="age" />
		<form:errors path="age" />
		<br>
		Email:<form:input path="email" />
		<form:errors path="email" />
		<br>
		<input type="submit" value="springmvcValid" />
	</form:form>
</body>
</html>
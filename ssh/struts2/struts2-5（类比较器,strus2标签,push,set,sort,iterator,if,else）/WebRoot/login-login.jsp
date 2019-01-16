<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:debug></s:debug>
	<s:form action="practice-show">
		<s:textfield name="loginParameters.userName" label="userName" />
		<s:password name="loginParameters.password" label="password" />
		<s:radio name="gender" list="#{'1':'Male','2':'Female'} "
			label="Gender" />
		<s:checkboxlist name="role" list="#request.role" listKey="roleId"
			listValue="roleName" label="Role" />
		<s:select name="department" label="Department" list="#request.dpt"
			listKey="departmentId" listValue="departmentName" />
		<s:textarea name="intro" label="Intro" />
		<s:submit label="Submit" />
	</s:form>
</body>
</html>

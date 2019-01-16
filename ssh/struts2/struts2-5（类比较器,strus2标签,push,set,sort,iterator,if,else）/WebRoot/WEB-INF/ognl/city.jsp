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
	<s:debug></s:debug>
	<!-- checkbox是一个boolean类型的 -->
	<s:form action="Ognl_city">
		<s:textfield name="user.name" label="userName" />
		<s:textfield name="user.sex" label="userSex" />
		<s:textfield name="user.age" label="userAge" />
		<s:password name="user.password" label="password" />
		<s:checkbox name="user.agree" label="Agree">
		</s:checkbox>
		<s:submit label="提交" />

	</s:form>
</body>
</html>
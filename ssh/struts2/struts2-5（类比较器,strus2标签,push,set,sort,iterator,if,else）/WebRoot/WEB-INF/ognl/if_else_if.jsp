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
	<s:if test="user.age >=50">
		事业正高峰期
	</s:if>
	<s:elseif test="user.age>30">
		事业真正的时期才到
	</s:elseif>
	<s:else>
		为事业铺路中。。。
	</s:else>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.hniu.user.*,com.hniu.comparator.*,java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<s:sort comparator="user.comparator" source="user.list" var="u" />
	<s:iterator value="#attr.u">
		${name }
		${age }
		${sex }
		<br>
	</s:iterator>
</body>
</html>
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
	<s:include value="hread.jsp"></s:include>
	<br/>
	<form action="Sms_pa_addOrEditPage" method="post">
		<s:hidden name="page_id" />
		<s:hidden name="surveyId" />
		<table align="center" border="1">
			<tr>
				<td>页面标题：</td>
				<td><s:textfield name="page_title" /></td>
			</tr>
			<tr>
				<td>页面描述：</td>
				<td><s:textarea name="page_description" /></td>
			</tr>
			<tr>
				<td></td>
				<td><s:submit value="确认" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
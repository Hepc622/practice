<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<s:debug></s:debug>
	<s:include value="hread.jsp" /><br/>

	<s:form action="/Sms_re_register" theme="simple" method="POST">
		<table border="1" style="border: thin; width: 100%; top: 30px;">
			<tr>
				<td align="right">用户名：</td>
				<td><s:textfield name="user_name" /> <s:fielderror
						fieldName="user_name"></s:fielderror></td>
			</tr>
			<tr>
				<td align="right">昵称：</td>
				<td><s:textfield name="user_nickname" /> <s:fielderror
						fieldName="user_nickname" /></td>
			</tr>
			<tr>
				<td align="right">邮箱：</td>
				<td><s:textfield name="user_email" /> <s:fielderror
						fieldName="user_email" /></td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td><s:password name="user_password" /> <s:fielderror
						fieldName="user_password" /></td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td><s:password name="re_user_password" />${errorMessages[0] }</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><s:submit value="提交" /> <s:reset
						value="重置" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
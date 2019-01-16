<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>I nsert title here</title>
</head>
<body>
	<div align="center">
		<s:include value="hread.jsp" />
		<br /> ${sessionScope.user.user_name }
		<s:form action="Sms_lo_login" method="POST">
			<table border="1" style="border: thin; width: 100%; top: 30px;">
				<tr>
					<td align="right">邮箱：</td>
					<td><s:textfield name="user_email" value="123@qq.com" /> <s:fielderror
							fieldName="user_email" /></td>
				</tr>
				<tr>
					<td align="right">密码：</td>
					<td><s:password name="user_password" value="123123" /> <s:fielderror
							fieldName="user_password" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><s:submit value="提交" /> <s:reset
							value="重置" /></td>
				</tr>
			</table>
		</s:form>
	</div>
</body>
</html>
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
	<s:include value="hread.jsp" />
	<br />
	<div align="center">
		<font style="font-size: 30px; font-weight: bolder;">添加权限</font><br />
		<s:form action="Sms_ri_addRight" method="post">
			<table>
				<s:hidden name="right_id"></s:hidden>
				<tr>
					<td>权限名称：</td>
					<td><s:textfield name="right_name" /></td>
				</tr>
				<tr>
					<td>权限位：</td>
					<td><s:textfield name="right_pos" readonly="true" /></td>
				</tr>
				<tr>
					<td>权限码：</td>
					<td><s:textfield name="right_code" readonly="true" /></td>
				</tr>
				<tr>
					<td>URL：</td>
					<td><s:textfield name="right_url" /></td>
				</tr>
				<tr>
					<td>简介：</td>
					<td><s:textarea name="right_desc" /></td>
				</tr>
				<tr>
					<td></td>
					<td><s:submit value="提交"></s:submit></td>
				</tr>
			</table>
		</s:form>
	</div>
</body>
</html>
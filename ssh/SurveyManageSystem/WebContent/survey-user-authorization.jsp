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
	<table align="center" width="800px" border="1" style="border: solid;">
		<s:if test="user.size()>0">
			<tr align="center">
				<th>ID</th>
				<th>用户名称</th>
				<th>用户昵称</th>
				<th>授权</th>
				<th>清楚授权</th>
			</tr>
			<s:iterator value="user" var="u">
				<tr align="center">
					<td><s:property value="#u.user_id" /></td>
					<td align="center"><s:property value="#u.user_email" /></td>
					<td align="center"><s:property value="#u.user_nickname" /></td>
					<td><s:a
							action="Sms_us_toEditAuthorization?user_id=%{#u.user_id}">编辑</s:a></td>
					<td><s:a
							action="Sms_us_clearAuthorization?user_id=%{#u.user_id}">删除</s:a></td>
				</tr>
			</s:iterator>
		</s:if>
	</table>
</body>
</html>
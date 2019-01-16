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
		<tr align="right">
			<th colspan="7"><s:a action="Sms_ro_toAddRole">添加角色</s:a></th>
		</tr>
		<s:if test="list.size()>0">
			<tr align="center">
				<th>ID</th>
				<th>角色名称</th>
				<th>角色值</th>
				<th>角色简介</th>
				<th>修改</th>
				<th>删除</th>
			</tr>
			<s:iterator value="list" var="role">
				<tr align="center">
					<td><s:property value="#role.role_id" /></td>
					<td align="center"><s:property value="#role.role_name" /></td>
					<td align="center"><s:property value="#role.role_value" /></td>
					<td><s:property value="#role.role_desc" /></td>
					<td><s:a action="Sms_ro_toEditRole?role_id=%{#role.role_id}">编辑</s:a></td>
					<td><s:a action="Sms_ro_deleteRole?role_id=%{#role.role_id}">删除</s:a></td>
				</tr>
			</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<th colspan="7">没有任何角色！</th>
			</tr>
		</s:else>
	</table>
</body>
</html>
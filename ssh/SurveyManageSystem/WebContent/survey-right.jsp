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
			<th colspan="7"><s:a action="Sms_ri_toAddRight">添加</s:a></th>
		</tr>
		<s:if test="list.size()>0">
			<tr align="center">
				<th>ID</th>
				<th>权限名称</th>
				<th>URL</th>
				<th>简介</th>
				<th>权限位</th>
				<th>权限码</th>
				<th>操作</th>
			</tr>
			<s:iterator value="list" var="right">
				<tr align="center">
					<td><s:property value="#right.right_id" /></td>
					<td align="left"><s:property value="#right.right_name" /></td>
					<td align="left"><s:property value="#right.right_url" /></td>
					<td><s:property value="#right.right_desc" /></td>
					<td><s:property value="#right.right_pos" /></td>
					<td align="left"><s:property value="#right.right_code" /></td>
					<td><s:a
							action="Sms_ri_toEditRight?right_id=%{#right.right_id}">编辑</s:a></td>
				</tr>
			</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<th colspan="7">没有任何权限！</th>
			</tr>
		</s:else>
	</table>
</body>
</html>
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
	<h2 align="center">员工信息管理</h2>
	<table border="1" align="center">
		<thead>
			<tr>
				<td>EmpolyeeId</td>
				<td>FirstName</td>
				<td>LastName</td>
				<td>Edit</td>
				<td>Delete</td>
				<td>Add</td>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="#attr.show">
				<tr>
					<td>${employeeId}</td>
					<td>${firstName}</td>
					<td>${lastName}</td>
					<td><a href="employee-edit?employee.employeeId=${employeeId }">Edit</a>
					</td>
					<td><a href="employee-delete?employee.employeeId=${employeeId }">Delete</a>
					</td>
					<td><a href="employee-add">Add</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>
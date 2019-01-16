<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 导入sel标签库 -->
<%@   taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery3.1.0.js"></script>
<script type="text/javascript">
	$(function() {
		$('a.delete').click(function() {
			//获取当前a标签的行
			var $tr = $(this).parent().parent();
			if (confirm("你要删除" + $(this).attr("name") + "的信息？")) {
				//发送请求
				$.post(this.href, {
					"time" : new Date()
				}, function(data) {
					if (data == "1") {
						$tr.remove();
					} else {
						alert("删除失败");
					}
				});

			}
			return false;
		});

		$('a.edit').click(function() {
			var url = this.href;
			if (confirm("你要修改" + $(this).attr("name") + "的信息？")) {
				$.load(url, {
					"time" : new Date()
				});
			}
			return false;
		});

	});
</script>
</head>
<body>

	<h4>Employee List Page</h4>
	<s:if
		test="#request.employees == null || #request.employees.size() == 0">
		没有任何员工信息
	</s:if>
	<s:else>
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>ID</td>
				<td>LASTNAME</td>
				<td>EMAIL</td>
				<td>BIRTH</td>
				<td>CREATETIME</td>
				<td>DEPT</td>
				<td>DELETE</td>
				<td>EDIT</td>
			</tr>
			<s:iterator value="#request.employees">
				<tr>
					<td>${employee_id }</td>
					<td>${employee_name }</td>
					<td>${employee_email }</td>
					<td><s:date name="employee_date" format="yyyy-MM-dd" /></td>
					<td><s:date name="employee_date" format="yyyy-MM-dd hh:mm:ss" /></td>
					<td>${dep_id.department_name }</td>
					<td><a href="emp-deleteEmp?id=${employee_id }"
						name="${employee_name }" class="delete">Delete</a></td>
					<td><a href="emp-editEmp?id=${employee_id }" class="edit"
						id="${employee_id }" name="${employee_name }">Edit</a></td>
				</tr>
			</s:iterator>
		</table>
	</s:else>
</body>
</html>
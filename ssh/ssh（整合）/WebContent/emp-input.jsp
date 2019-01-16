<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery3.1.0.js"></script>
<script type="text/javascript">
	$(function() {
		$(":input[name='employee_name']").change(function() {
			/* 删除输入框后面的标签，确保下次正常的显示提示 */
			$(this).next().remove();
			/* 获取输入框的值 */
			var name = $(this).val();
			/* 将当前对象复制给一个变量，在function中使用this，this是指向调用function的对象 */
			var $this = $(this);
			/* 判断name是否为空 */
			if (name != null && name != "") {
				var url = "emp-userIsExist";
				var args = {
					"name" : name,
					"time" : new Date()};
				$.post(url, args, function(data) {
					//表示可用
					if (data == "1") {
						$this.after("<font color='green'>该用户可用</font>");
					}
					//不可用
					else if (data == "0") {
						$this.after("<font color='red'>该用户存在</font>");
					}
					//服务器错误
					else {
						alert("服务器错误!");
					}
				});
			} else {
				$(this).after("<font color='red'>用户名不能为空</font>");
			}
		});
	});
</script>
</head>
<body>

	<s:debug></s:debug>

	<h4>Employee Input Page</h4>

	<s:form action="emp-saveEmp" method="post">
		<s:if test="id != null">
			<s:textfield name="employee_name" label="LastName" disabled="true"></s:textfield>
			<s:hidden name="id"></s:hidden>
			<%-- 
			<!-- 通过添加隐藏域的方式把未显式提交的字段值提交到服务器 -->
			<s:hidden name="lastName"></s:hidden>
			<s:hidden name="createTime"></s:hidden>
			--%>
		</s:if>
		<s:else>
			<s:textfield name="employee_name" label="LastName"></s:textfield>
		</s:else>

		<s:textfield name="employee_email" label="Email"></s:textfield>
		<s:textfield name="employee_date" label="Birth"></s:textfield>

		<s:select list="#request.departments" listKey="department_id"
			listValue="department_name" name="dep_id.department_id"
			label="Department"></s:select>
		<s:submit></s:submit>
	</s:form>

</body>
</html>
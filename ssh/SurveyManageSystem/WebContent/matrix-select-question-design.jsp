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
	<s:include value="hread.jsp"></s:include><br/>
	<div align="center">
		<s:form action="Sms_qu_addQuestion" method="post">
			<table>
				<s:hidden name="surveyId"></s:hidden>
				<s:hidden name="pageId"></s:hidden>
				<s:hidden name="question_id"></s:hidden>
				<s:hidden name="question_type"></s:hidden>
				<tr>
					<td colspan="2">矩阵问题设计</td>
				</tr>
				<tr>
					<td>问题标题：</td>
					<td><s:textfield name="question_title" /></td>
				</tr>
				<tr>
					<td>行标题：</td>
					<td><s:textarea name="question_other_matrix_row_titles" /></td>
				</tr>
				<tr>
					<td>列标题：</td>
					<td><s:textarea name="question_other_matrix_col_titles" /></td>
				</tr>
				<tr>
					<td>下拉列表集合：</td>
					<td><s:textarea name="question_other_matrix_select_options" /></td>
				</tr>
				<tr>
					<td></td>
					<td><s:submit></s:submit></td>
				</tr>
			</table>
		</s:form>
	</div>
</body>
</html>
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
			<s:hidden name="surveyId"></s:hidden>
			<s:hidden name="pageId"></s:hidden>
			<s:hidden name="question_id"></s:hidden>
			<s:hidden name="question_type"></s:hidden>
			<table>
				<tr>
					<td colspan="2">非矩阵问题设计</td>
				</tr>
				<tr>
					<td>问题标题：</td>
					<td><s:textfield name="question_title" /></td>
				</tr>
				<tr>
					<td>问题选项：</td>
					<td><s:textarea name="question_options" /></td>
				</tr>
				<tr>
					<td>是否含有"其它"项：</td>
					<td><s:checkbox name="question_other" /></td>
				</tr>
				<tr>
					<td>"其它"项类型：</td>
					<td><s:radio list="#{0:'无',1:'文本',2:'下拉框'} " listKey="key"
							listValue="value" name="question_other_style"></s:radio></td>
				</tr>
				<tr>
					<td>"其它"项类型的下拉框选项：</td>
					<td><s:textarea name="question_other_select_options" /></td>
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
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
	<br/>
	<s:form action="Sms_su_editSurvey" method="POST">
		<s:textfield type="hidden" name="survey_id" />
		<s:textfield type="hidden" name="survey_logo" />
		<s:textfield type="hidden" name="survey_creatTime" />
		<table align="center">
			<tr>
				<td>调查标题：</td>
				<td><s:textfield name="survey_title" /></td>
			</tr>
			<tr>
				<td>"下一步"提示文本：</td>
				<td><s:textfield name="survey_nextText" /></td>
			</tr>
			<tr>
				<td>"上一步"提示文本：</td>
				<td><s:textfield name="survey_preText" /></td>
			</tr>
			<tr>
				<td>"完成"提示文本：</td>
				<td><s:textfield name="survey_doneText" /></td>
			</tr>
			<tr>
				<td>"退出"提示文本：</td>
				<td><s:textfield name="survey_exitText" /></td>
			</tr>
			<tr>
				<td></td>
				<td><s:submit value="确认" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
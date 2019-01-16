<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:include value="hread.jsp"></s:include>
	<br />
	<table align="center" border="1" style="border: solid;">
		<tr>
			<th>ID</th>
			<th>调查表题</th>
			<th>创建时间</th>
			<th>状态</th>
			<th>设计</th>
			<th>收集信息</th>
			<th>分析</th>
			<th>打开/关闭</th>
			<th>清楚调查</th>
			<th>删除</th>
		</tr>
		<s:iterator value="#session.survey" var="survey">
			<tr>
				<td><s:property value="#survey.survey_id" /></td>
				<td><s:property value="#survey.survey_title" /></td>
				<td><s:date name="#survey.survey_creatTime"
						format="yyyy-MM-dd HH:mm:ss" /></td>
				<td><s:if test="#survey.survey_closed==1">
						开启
					</s:if> <s:else>
						关闭
					</s:else></td>
				<td><s:a
						action="Sms_su_toDesign?surveyId=%{#survey.survey_id }">设计</s:a></td>
				<td><s:a action="CollectAction?surveyId=%{#survey.survey_id }">收集信息</s:a></td>
				<td><s:a
						action="Sms_su_toAnalysis?surveyId=%{#survey.survey_id }">分析</s:a></td>
				<td><s:a
						action="Sms_su_statusSurvey?surveyId=%{#survey.survey_id }">打开/关闭</s:a></td>
				<td><s:a
						action="Sms_su_clearSurvey?surveyId=%{#survey.survey_id }">清楚调查</s:a></td>
				<td><s:a
						action="Sms_su_deleteSurvey?surveyId=%{#survey.survey_id }">删除</s:a></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>
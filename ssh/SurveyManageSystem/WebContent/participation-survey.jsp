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
	<br />
	<s:if test="surveys.size()==0">目前没有可用的调查!</s:if>
	<s:else>
		<table>
			<tr>
				<td colspan="2" style="height: 5px"></td>
			</tr>
			<tr>
				<td colspan="2" class="tdHeader">参与调查:请选择要参与的调查</td>
			</tr>
			<tr>
				<td colspan="2" style="height: 5px"></td>
			</tr>
			<tr>
				<s:iterator var="s" value="surveys">
					<td><s:property value="#s.survey_title" /><br /> <img
						src='<s:url value="%{#s.survey_logo}"></s:url>' width="70px"
						height="70px" /><br /> <s:a
							action="Sms_par_participation?survey_id=%{#s.survey_id}">我要参与</s:a>
					</td>
				</s:iterator>
			</tr>
		</table>
	</s:else>
</body>
</html>
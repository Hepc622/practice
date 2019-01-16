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
	<s:debug></s:debug>
	<s:include value="hread.jsp"></s:include><br/>
	<table align="center">
		<s:iterator value="list" var="survey">
			<s:if test="#survey.page.size()>0">
				<tr>
					<td><s:property value="#survey.survey_title" /></td>
					<td><s:iterator value="#survey.page" var="page">
							<s:if test="#page.page_id==pageId">
								<tr>
									<td>
										<table border="5">
											<tr background="blue">
												<td><s:property value="#page.page_title" /></td>
												<td></td>
											</tr>
										</table>
									</td>
								</tr>
							</s:if>
							<s:else>
								<tr>
									<td>
										<table border="1">
											<tr>
												<td><s:property value="#page.page_title" /></td>
												<td><s:property value="#survey.survey_id" /> <s:property
														value="#page.page_id" /> <s:form method="post"
														action="Sms_pa_moveOrCopyPage">
														<s:hidden name="surveyId" value="%{#survey.survey_id}" />
														<s:hidden name="pageId" />
														<s:hidden name="pageStarget" value="%{#page.page_id}" />
														<s:radio list="#{0:'之前',1:'之后'} " listValue="value"
															listKey="key" name="location" />
														<s:submit label="确认" />
													</s:form></td>
											</tr>
										</table>
									</td>
								</tr>
							</s:else>
						</s:iterator></td>
				</tr>
			</s:if>
		</s:iterator>
	</table>
</body>
</html>
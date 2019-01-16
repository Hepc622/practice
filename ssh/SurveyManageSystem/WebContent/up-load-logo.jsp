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
	<s:form action="Sms_su_upLoadLogo" method="post"
		enctype="multipart/form-data">
		<s:hidden name="surveyId"></s:hidden>
		<table border="1" align="center">
			<tr>
				<td><s:file name="upload" label="上传"></s:file></td>
				<td><s:fielderror name="upload" /></td>
			</tr>
			<tr>
				<td><s:submit value="上传"></s:submit></td>
				<td></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
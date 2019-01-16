<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<s:debug></s:debug>
	<s:form action="login" theme="simple">
		<table>
			<tr>
				<td><s:text name="userName"/></td>
				<td><s:textfield name="userName" />
				</td>
				<td><font color="red">${fieldErrors.userName[0]}</font></td>
			</tr>
			<tr>
				<td><s:text name="password"/></td>
				<td><s:password name="passwordOne" />
				</td>
				<td><font color="red">${fieldErrors.passwordOne[0]}</font></td>
			</tr>
			<tr>
				<td><s:text name="password"/></td>
				<td><s:password name="passwordTwo" />
				</td>
				<td><font color="red">${errorMessages[0] }</font></td>
			</tr>
			<tr>
				<td><s:text name="age"/></td>
				<td><s:textfield name="age" />
				</td>
				<td><font color="red">${fieldErrors.age[0]}</font></td>
			</tr>
			<tr>
				<td><s:text name="birthDay"/></td>
				<td><s:textfield name="birthDay" />
				</td>
				<td><font color="red">${fieldErrors.birthDay[0]}</font></td>
			</tr>

			<tr>
				<td><s:text name="idCard"/></td>
				<td><s:textfield name="idCard" /></td>
				<td><font color="red">${fieldErrors.idCard[0]}</font></td>
			</tr>

			<tr>
				<td><s:text name="phoneNumber"/></td>
				<td><s:textfield name="phoneNumber" />
				</td>
			</tr>

			<tr>
				<td><s:text name="userEail"/></td>
				<td><s:textfield name="userEail" />
				</td>
				<td><font color="red">${fieldErrors.eail[0]}</font></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><s:submit />
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>This is ServeyManagerSystem head</title>
</head>
<body>
	<div align="center">
		<h1>欢迎使用ServeyDoor调查系统</h1>
		<div>
			<s:a action="Sms_lo_toLogin" namespace="/">[首页]</s:a>
			<s:a action="Sms_su_toNewSurvey">[新建调查]</s:a>
			<s:a action="Sms_su_toMySurvey">[我的调查]</s:a>
			<s:a action="Sms_par_toParticipation">[参与调查]</s:a>
			<s:a action="Sms_re_toRegister">[用户注册]</s:a>
			<s:a action="Sms_us_toAuthorization">[用户授权管理]</s:a>
			<s:a action="Sms_ro_toRole">[角色管理]</s:a>
			<s:a action="Sms_ri_toRight">[权限管理]</s:a>
		</div>
	</div>
</body>
</html>
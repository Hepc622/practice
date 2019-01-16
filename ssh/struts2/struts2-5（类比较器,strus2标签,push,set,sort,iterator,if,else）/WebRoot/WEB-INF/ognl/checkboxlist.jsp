<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,com.hniu.city.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Object> list = new ArrayList<Object>();
		list.add(new City(1, "长沙"));
		list.add(new City(2, "武汉"));
		list.add(new City(3, "广州"));
		list.add(new City(4, "南昌"));
		request.setAttribute("list", list);
	%>
	<s:form action="Ognl_checkboxlist">
		<s:textfield name="user.name" label="userName" />
		<s:textfield name="user.sex" label="userSex" />
		<s:textfield name="user.age" label="userAge" />
		<s:password name="user.password" label="password" />
		<s:checkbox name="user.agree" label="Agree" />
		<s:radio name="check" list="#{'1':'why','2':'who','3':'lyl'} "/>
		<s:checkboxlist name="city" label="City" list="#attr.list"
			listKey="id" listValue="name" />
		<s:select list="{1,2,3,4,5,6,7,8,9,0}" headerKey="" headerValue="请选择"
			name="age" label="Age">
			<!-- optgroup是select的子标签 -->
			<s:optgroup label="10-20"
				list="#{11:11,12:12,13:13,14:14,15:15,16:16,17:17,18:18,19:19,20:20} " />
			<s:optgroup label="20-30"
				list="#{21:21,22:22,23:23,24:24,25:25,26:26,27:27,28:28,29:29,30:30} " />
		</s:select>
		<s:submit label="提交" />
	</s:form>
</body>
</html>
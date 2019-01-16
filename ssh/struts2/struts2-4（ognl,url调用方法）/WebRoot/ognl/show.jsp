<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
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
  <%
  		String[] str = new String[]{"aa","bb","cc"};
  		request.setAttribute("str", str);
   %>
   		<s:debug></s:debug>
  		<!-- 调用静态方法@对象@属性 -->
    	方法：<s:property value="@com.hniu.ognl.Ognl@save()"/><br><br>
    	属性：<s:property value="@java.util.Calendar@DECEMBER"/><br><br>
    	<!-- 访问集合中的静态属性 -->
    	<!-- 指定了与对象 -->
    	<s:property value="#request.str.length"/><br><br>
 		<!-- 没指定域对象，将一一的去每个域中去查找 -->
    	<s:property value="#attr.str.length"/><br><br>
    	<!-- str的第二个值 -->
    	<s:property value="#attr.str[1]"/><br><br>
    	<!-- 调用栈对象的属性和方法 -->
    	<s:property value="user.name"/><br><br>
    	<s:property value="user.age"/><br><br>
    	<s:property value="user.sex"/><br><br>
    	<s:property value="user.setName('hpc')"/><br><br>
    	<s:property value="user.name"/><br><br>
    	
    	
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>河北九洲普惠风机销售分公司</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/addlay.css" />
</head>
<body>
	<div class="theme-popover-login">
		<div class="theme-poptit">
			<a href="javascript:;" title="关闭" class="close">×</a>
			<h3>登陆</h3>
		</div>
		<div class="theme-popbod dform">
			<form class="theme-signin" name="loginform"
				action="${pageContext.request.contextPath}/loginUser" method="post">
				<ol>
					<li></li>
					<li><strong>用户名：</strong><input class="ipt" type="text"
						name="user_name" size="20" /></li>
					<li><strong>密 码：</strong><input class="ipt" type="password"
						name="user_pwd" size="20" /></li>
					<li><input class="btn btn-primary" type="submit" name="submit"
						value=" 登 录" /></li>
				</ol>
			</form>
		</div>
	</div>
	<div class="theme-popover-mask-login"></div>
</body>
</html>
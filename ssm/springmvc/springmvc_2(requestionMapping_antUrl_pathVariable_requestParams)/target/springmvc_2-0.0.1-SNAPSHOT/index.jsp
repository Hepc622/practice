<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="deleteRequest/1" method="post">
		<input type="hidden" name="_method" value="DELETE"> <input
			type="submit" value="DELETE">
	</form>
	<br>
	<form action="putRequest/2" method="post">
		<input type="hidden" name="_method" value="PUT"> <input
			type="submit" value="PUT">
	</form>
	
	<a href="paramsRequest?userName=hpc&age=21">params Request</a>
	<br>
	<form action="methodRequest" method="post">
		<input type="submit" value="post">
	</form>
	<a href="methodRequest">get metohd request</a>
	<a href="springmvc/abc/2">PathVariable Request</a>
	<br>
	<a href="requstMapping">hello springmvc</a>
	<a href="springmvc/2/antUrl1">? 匹配任意字符</a>
	<br>
	<br>
	<a href="springmvc/1*/antUrl2">* 匹配任意字符</a>
	<br>
	<br>
	<a href="springmvc/1**/antUrl3">** 匹配多层任意字符</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery3.1.0.js"></script>
<script type="text/javascript">
	$(function() {
		$("#testJson").click(
				function() {
					var url = this.href;
					$.get(url, {}, function(data) {
						alert(data.name+" : "+data.sex+" : "+data.age+" : "+data.email);
						for (var i = 0; i < data.length; i++) {
							alert(data[i].name + "-" + data[i].age + "-"
									+ data[i].sex + "-" + data[i].email);
						}
					});
					return false;
				});
	});
</script>
</head>
<body>
	<a href="springmvcResponseBodyAndRequestBody?name=hpc" >Test springmvc ResponseBody And RequestBody</a>
	<br>
	<a href="springmvcJson" id="testJson">Test Springmvc json</a>
	<br>
	<a href="input">springmvcValid</a>
	<br> springmvcFormat：
	<form action="springmvcFormat" method="post">
		Nmae:<input type="text" name="userName"> <br> Sex:<input
			type="text" name="userSex"> <br> Age:<input type="text"
			name="userAge"> <br> Number:<input type="text"
			name="userNumber"> <br> Birthdy:<input type="text"
			name="userBirthdy"> <br> <input type="submit"
			value="springmvcFormat">
	</form>
	springmvcInitBinder：
	<form action="springmvcInitBinder">
		Nmae:<input type="text" name="userName"> <br> Sex:<input
			type="text" name="userSex"> <br> Age:<input type="text"
			name="userAge"> <br> Number:<input type="text"
			name="userNumber"> <br> <input type="submit"
			value="springmvcInitBinder">
	</form>
	<br>
	<form action="converterStringToDate">
		<input type="text" name="date"> <input type="submit"
			value="converterStringToDate">
	</form>

</body>
</html>
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
	<s:include value="hread.jsp" />
	<br />
	<div align="center">
		<font style="font-size: 30px; font-weight: bolder;">添加角色</font><br />
		<s:form action="Sms_us_editAuthorization" method="post">
			<table>
				<s:hidden name="user_id"></s:hidden>
				<tr>
					<td>用户名称：</td>
					<td><s:textfield name="user_name" /></td>
				</tr>
				<tr>
					<td>权限值：</td>
					<td><s:textfield readonly="true" name="user_value" /></td>
				</tr>
				<tr>
					<td><s:select name="inc" list="include" listKey="role_id"
							listValue="role_name" multiple="true" size="20"
							cssStyle="width:120px;">
						</s:select></td>
					<td align="center">
						<button name="left" onclick="moveRole(this);return false;"
							style="width: 120px">左移</button> <br> <br>
						<button name="right" onclick="moveRole(this);return false;"
							style="width: 120px">右移</button>
					</td>
					<td><s:select name="notinc" list="notInclude"
							listKey="role_id" listValue="role_name" multiple="true" size="20"
							cssStyle="width:120px;">
						</s:select></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><s:submit
							onclick="changeSelected();" style="width: 120px" value="提交"></s:submit></td>
				</tr>
			</table>
		</s:form>
	</div>
</body>
<script type="text/javascript">
	var not = document.getElementsByName("notinc")[0];
	var inc = document.getElementsByName("inc")[0];
	var iop = inc.options;
	var nop = not.options;
	function moveRole(b) {
		if (b.name == "left") {
			for (var i = 0; i < nop.length; i++) {
				if (nop[i].selected == true) {
					inc.appendChild(new Option(nop[i].text, nop[i].value));
					not.removeChild(nop[i]);
				}
			}
		} else {
			for (var i = 0; i < iop.length; i++) {
				if (iop[i].selected == true) {
					not.appendChild(new Option(iop[i].text, iop[i].value));
					inc.removeChild(iop[i]);
				}
			}
		}
		return false;
	}
	function changeSelected() {
		for (var i = 0; i < iop.length; i++) {
			iop[i].selected = "selected";
		}
		return true;
	}
</script>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>矩阵式问题图表分析</title>
<link rel="stylesheet" type="text/css"
	href='<s:url value="/styles.css" />'>
<style type="text/css">
.divLegend {
	border: 1px solid blue;
	overflow: hidden;
	display: inline;
	width: 15px;
	height: 15px;
}
</style>
</head>
<body>
	<s:include value="/hread.jsp" />
	<br>
	<s:set var="qt" value="qs.question.question_type" />
	<table border="1px" align="center">
		<tr>
			<td colspan="2" class="tdWhiteLine"></td>
		</tr>
		<tr>
			<td colspan="2" class="tdHeader">矩阵式题型调查结果分析:</td>
		</tr>
		<tr>
			<td colspan="2" class="tdWhiteLine"></td>
		</tr>
		<tr>
			<td colspan="2" class="tdHeader"><s:property
					value="qs.question.question_title" /></td>
		</tr>
		<tr>
			<td colspan="2" class="tdWhiteLine"></td>
		</tr>
		<tr>
			<td>
				<table border="1px">
					<!-- 画表头 -->
					<tr>
						<td width="30px"></td>
						<s:iterator value="qs.question.question_other_matrix_col_titleArr">
							<td><s:property /></td>
						</s:iterator>
					</tr>
					<s:iterator var="row"
						value="qs.question.question_other_matrix_row_titleArr"
						status="rowStatus">
						<tr>
							<td><s:property value="#row" /></td>
							<s:iterator var="col"
								value="qs.question.question_other_matrix_col_titleArr"
								status="colStatus">
								<td>
									<!-- ognl不仅可以访问属性,还可以直接调方法 --> <s:property
										value='getScale(#rowStatus.index,#colStatus.index)' />
								</td>
							</s:iterator>
						</tr>
					</s:iterator>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: left;">共有&nbsp;<s:property
					value="qs.question_count" />&nbsp;人参与问卷!
			</td>
		</tr>
	</table>
</body>
</html>
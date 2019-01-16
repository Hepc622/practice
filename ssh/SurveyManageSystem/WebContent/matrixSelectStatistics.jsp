<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>矩阵式问题图表分析</title>
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
			<td colspan="2" class="tdHeader">矩阵式下拉列表题型调查结果分析:</td>
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
			<td colspan="2" style="text-align: left; display: inline">
				<!-- 创建左上角颜色块,用不同颜色代表不同下拉列表选项 --> <s:iterator
					value="qs.question.question_other_matrix_select_optionArr" status="optionStatus">
					<!-- 设置颜色变量,始终处于0-255之间 -->
					<s:set var="color" value="(#optionStatus.index * 25) % 255" />
					<!-- 对文本框进行修饰,产生颜色块的特效 -->
					<input type="text"
						style="border:1px solid blue;background-color: rgb(0 <s:property value='255-#color'/> <s:property value='#color'/>);width: 12px;height: 12px">
					<s:property />
				</s:iterator>
			</td>
		</tr>
		<tr>
			<td>
				<table border="1px">
					<!-- 输出表头 -->
					<tr>
						<td width="30px"></td>
						<s:iterator value="qs.question.question_other_matrix_col_titleArr">
							<!-- 集合中每个元素都是字符串,直接通过s:property 方式输出 -->
							<td><s:property /></td>
						</s:iterator>
					</tr>
					<!-- 遍历行标题数组 -->
					<s:iterator var="row"
						value="qs.question.question_other_matrix_row_titleArr"
						status="rowStatus">
						<tr>
							<td><s:property value="#row" /></td>
							<!--  遍历列表数组 -->
							<s:iterator var="col"
								value="qs.question.question_other_matrix_col_titleArr"
								status="colStatus">
								<td style="text-align: left;">
									<!-- 遍历下拉选项数组 --> <s:iterator var="option"
										value="qs.question.question_other_matrix_select_optionArr"
										status="optionStatus">
										<s:set var="color" value="(#optionStatus.index * 25) % 255" />
										<!--  -->
										<input type="text"
											style="border:1px solid blue;
																		  background-color: rgb(0 <s:property value='255-#color'/> <s:property value='#color'/>);
																		  width: 0<s:property value='getPercentage(#rowStatus.index,#colStatus.index,#optionStatus.index)'/>px;
																		  height: 12px">
										<!-- 动态调用action中的方法 -->
										<s:property
											value='getScale(#rowStatus.index,#colStatus.index,#optionStatus.index)' />
										<br>
									</s:iterator>
								</td>
							</s:iterator>
						</tr>
					</s:iterator>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: left;">共有&nbsp;<s:property
					value="qs.question_count" />&nbsp;人参与问卷
			</td>
		</tr>
	</table>
</body>
</html>
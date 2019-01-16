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
	<s:include value="/hread.jsp"></s:include>
	<br />
	<s:set var="sId" value="survey_id" />
	<table align="center">
		<tr>
			<td colspan="2" class="tdWhiteLine"></td>
		</tr>
		<tr>
			<td colspan="2" class="tdHeader">分析调查:</td>
		</tr>
		<tr>
			<td colspan="2" class="tdWhiteLine"></td>
		</tr>
		<tr>
			<td colspan="2" class="tdHeader"><s:property
					value="survey.survey_title" /></td>
		</tr>
		<tr>
			<td colspan="2" class="tdWhiteLine"></td>
		</tr>
		<!-- 遍历调查的页面集合 -->
		<s:iterator var="p" value="page" status="pStatus">
			<!-- 设置变量,对当前的Page的id属性进行保持 -->
			<s:set var="pId" value="#p.page_id" />
			<tr>
				<td colspan="2" class="tdPHeaderL"><s:property
						value="#p.page_title" /></td>
			</tr>
			<tr>
				<td width="30px"></td>
				<td>
					<table>
						<!-- 遍历问题集合 -->
						<s:iterator var="q" value="#p.question" status="qStatus">
							<s:set var="qId" value="#q.question_id" />
							<s:set var="qt" value="#q.question_type" />
							<!-- 定义矩阵式题型变量(6,7,8) -->
							<s:set var="qtMatrix" value='"6,7,8"' />
							<tr>
								<!-- count:从1开始 index:从0开始 -->
								<td class="tdQHeaderL" style="border-bottom: 1px solid white"><s:property
										value="#qStatus.count" />.<s:property
										value="#q.question_title" /></td>
								<td class="tdQHeaderR" style="border-bottom: 1px solid white">
									<s:form action='AnalysisAction' method="post" target="_blank">
										<input type="hidden" name="questionId"
											value='<s:property value="#qId" />'>
										<!-- 判断当前题型是否矩阵式题型 -->
										<s:if test='#qtMatrix.indexOf(#qt + "") > -1'>
											<!-- 提交给另外一个action,改变form的提交地址 -->
											<s:submit onclick="this.form.action='AnalysisMatrixAction'"
												value="查看矩阵式问题统计结果" />
										</s:if>
										<s:elseif test='#qt != 5'>
											<select name="chartType">
												<option value="-1">--选择图表类型--</option>
												<option value="0">平面饼图</option>
												<option value="1">立体饼图</option>
												<option value="2">横向平面柱状图</option>
												<option value="3">纵向平面柱状图</option>
												<option value="4">横向立体柱状图</option>
												<option value="5">纵向立体柱状图</option>
												<option value="6">平面折线图</option>
												<option value="7">立体折线图</option>
											</select>
											<s:submit value="查看统计结果" />
										</s:elseif>
									</s:form>
								</td>
							</tr>
						</s:iterator>
					</table>
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:include value="hread.jsp"></s:include><br/>
	调查设计
	<div>
		<!-- 调查头信息 -->
		<div>
			<s:if test="isVaild()">
				<img width="25px" height="25px"
					src="<s:url  value="%{survey_logo}" />">
			</s:if>
			<s:property value="survey_title" />
			<s:a action="Sms_su_toUpLoadLogo?surveyId=%{survey_id}">添加Logo</s:a>
			<s:a action="Sms_su_toEditSurvey?surveyId=%{survey_id}">编辑调查</s:a>
			<s:a action="Sms_pa_toAddPage?surveyId=%{survey_id}">增加页面</s:a>
		</div>
		<!-- 调查信息 -->
		<s:iterator var="p" value="page">
			<div style="width: 800px;" align="center">
				<!-- 页面头信息 -->
				<div>
					<s:property value="#p.page_title" />
					<div align="right">
						<s:a
							action="Sms_pa_toEditPage?surveyId=%{survey_id}&pageId=%{#p.page_id }">编辑页标题</s:a>
						<s:a
							action="Sms_pa_toMoveOrCopyPage?surveyId=%{survey_id}&pageId=%{#p.page_id }">移动/复制页</s:a>
						<s:a
							action="Sms_pa_deletePage?surveyId=%{survey_id}&pageId=%{#p.page_id }">删除页</s:a>
						<s:a
							action="Sms_qu_toQuestionTypeChoosePage?surveyId=%{survey_id}&pageId=%{#p.page_id }">增加问题</s:a>
					</div>
				</div>
				<!-- 问题信息 -->
				<div>
					<s:iterator var="q" value="#p.question" status="questionStatus">
						<!-- 问题头 -->
						<div>
							<s:property value="#q.question_title" />
							<div>
								<s:a
									action="Sms_qu_toEditQuestion?questionId=%{#q.question_id}&surveyId=%{survey_id}&pageId=%{#p.page_id }">编辑问题</s:a>
								<s:a
									action="Sms_qu_deleteQuestion?questionId=%{#q.question_id}&surveyId=%{survey_id}&pageId=%{#p.page_id }">删除问题</s:a>
							</div>
							<div>
								<s:set var="type" value="#q.question_type" />
								<s:if test="#type<4">
									<s:iterator value="#q.question_optionArr" var="qo">
										<s:if test="#type<2">
											<input type="radio"
												name="q<s:property value='#q.question_id'/>_raido"
												value="<s:property value='#qo'/>">
										</s:if>
										<s:else>
											<input type="checkbox"
												name="q<s:property value='#q.question_id'/>_checkbox"
												value="<s:property value='#qo'/>">
										</s:else>
										<s:property value="#qo" />
										<!-- 换行 -->
										<s:if test="#type==1||#type==3">
											<br />
										</s:if>
									</s:iterator>
									<!-- 是否有其他项 -->
									<s:if test="#q.question_other">
										<!-- 换行 -->
										<s:if test="#type==1||#type==3">
											<br />
										</s:if>
										<!-- 其他项为文本 -->
										<s:if test="#q.question_other_style == 1">
											其他：<input type="text"
												name="q<s:property value='#q.question_id'/>_other_text">
										</s:if>
										<!-- 其他项为下拉列 -->
										<s:if test="#q.question_other_style == 2">
											其他：<select
												name="q<s:property value='#q.question_id'/>_other_select">
												<s:iterator value="#q.question_other_select_optionArr"
													status="qoso">
													<option value="<s:property value='#qoso.index' />"><s:property /></option>
												</s:iterator>
											</select>
										</s:if>
									</s:if>
								</s:if>
								<s:elseif test="#q.question_type ==4 || #q.question_type ==5">
									<s:if test="#q.question_type ==4">
										<select name="q<s:property value='#q.question_id'/>_select">
											<s:iterator value="#q.question_other_select_optionArr"
												status="qoso">
												<option value="<s:property value='#qoso.index' />"><s:property /></option>
											</s:iterator>
										</select>
									</s:if>
									<s:if test="#q.question_type ==5">
										<input type="text"
											name='q<s:property value='#q.question_id'/>_text'>
									</s:if>
								</s:elseif>
								<s:elseif test="#q.question_type>5">
									<table>
										<tr>
											<td></td>
											<s:iterator value="#q.question_other_matrix_col_titleArr"
												status="qomct" var="colStatus">
												<td><s:property /></td>
											</s:iterator>
										</tr>
										<s:iterator value="#q.question_other_matrix_row_titleArr"
											status="rowStatus">
											<tr>
												<td><s:property /></td>
												<s:if test="#q.question_type==6">
													<s:iterator value="#q.question_other_matrix_col_titleArr"
														status="qomct" var="colStatus">
														<td><input type="radio"
															name="q<s:property value='#q.question_id'/>_<s:property value='#rowStatus.index'/>_radio"
															value="<s:property/>" /></td>
													</s:iterator>
												</s:if>
												<s:if test="#q.question_type==7">
													<s:iterator
														value="#q.question_other_matrix_select_optionArr">
														<td><input type="checkbox"
															name="q<s:property value='#q.question_id'/>_<s:property value='#rowStatus.index'/>_checkbox"
															value="<s:property/>" /></td>
													</s:iterator>
												</s:if>
												<s:if test="#q.question_type==8">
													<s:iterator value="#q.question_other_matrix_col_titleArr">
														<td><select
															name="q<s:property value='#q.question_id'/>_<s:property value='#rowStatus.index'/>_select">
																<s:iterator
																	value="#q.question_other_matrix_select_optionArr"
																	status="optionStatus">
																	<option
																		value="<s:property value='#optionStatus.index'/>"><s:property /></option>
																</s:iterator>
														</select></td>
													</s:iterator>
												</s:if>
											</tr>
										</s:iterator>
									</table>
								</s:elseif>
							</div>
						</div>
					</s:iterator>
				</div>

			</div>
		</s:iterator>
	</div>
</body>
</html>
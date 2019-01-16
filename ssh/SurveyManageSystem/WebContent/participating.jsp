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
	<s:include value="hread.jsp"></s:include><br/>
	<s:property value="#session.survey.survey_title" />
	<s:form action="Sms_par_participationOption" method="post">
		<div>
			<s:hidden name="currentPageId" value="%{echoPage.page_id}" />
			<s:hidden name="currentPageOrder" value="%{echoPage.page_order}" />
			<!-- 调查头信息 -->
			<div style="width: 800px;" align="center">
				<!-- 页面头信息 -->
				<div>
					<s:iterator var="q" value="echoPage.question"
						status="questionStatus">
						<!-- 问题头 -->
						<div>
							<s:property value="#q.question_title" />
							<div>
								<s:set var="type" value="#q.question_type" />
								<s:if test="#type<4">
									<s:iterator value="#q.question_optionArr" var="qo"
										status="option">
										<s:if test="#type<2">
											<input type="radio"
												<s:property value="setAttribute('q'+#q.question_id,#option.index,'checked')"/>
												name="q<s:property value='#q.question_id'/>"
												value="<s:property value='#option.index'/>">
										</s:if>
										<s:else>
											<input type="checkbox"
												<s:property value="setAttribute('q'+#q.question_id,#option.index,'checked')"/>
												name="q<s:property value='#q.question_id'/>"
												value="<s:property value='#option.index'/>">
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
												value="<s:property value="setAttribute('q'+#q.question_id+'other',#qo,'text')"/>"
												name="q<s:property value='#q.question_id'/>other">
										</s:if>
										<!-- 其他项为下拉列 -->
										<s:if test="#q.question_other_style == 2">
											其他：<select name="q<s:property value='#q.question_id'/>other">
												<s:iterator value="#q.question_other_select_optionArr"
													status="qoso" var="option">
													<option value="<s:property value='#qoso.index' />"
														<s:property value="setAttribute('q'+#q.question_id+'other',#qoso.index,'selected')" />>
														<s:property /></option>
												</s:iterator>
											</select>
										</s:if>
									</s:if>
								</s:if>
								<s:elseif test="#q.question_type ==4 || #q.question_type ==5">
									<s:if test="#q.question_type ==4">
										<select name="q<s:property value='#q.question_id'/>">
											<s:iterator value="#q.question_other_select_optionArr"
												status="qoso" var="option">
												<option value="<s:property value='#qoso.index' />"
													<s:property value="setAttribute('q'+#q.question_id,#qoso.index,'selected')" />><s:property /></option>
											</s:iterator>
										</select>
									</s:if>
									<s:if test="#q.question_type ==5">
										<input type="text"
											name='q<s:property value='#q.question_id'/>'
											value="<s:property value="setAttribute('q'+#q.question_id,'','text')" />">
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
														status="colStatus">
														<td><input type="radio"
															name="q<s:property value='#q.question_id'/>_<s:property value='#rowStatus.index'/>"
															value="<s:property value="#colStatus.index"/>"
															<s:property value="setAttribute('q' +#q.question_id+'_'+#rowStatus.index,#colStatus.index,'checked')"/> /></td>
													</s:iterator>
												</s:if>
												<s:if test="#q.question_type==7">
													<s:iterator value="#q.question_other_matrix_col_titleArr"
														status="colStatus">
														<td><input type="checkbox"
															name="q<s:property value='#q.question_id'/>_<s:property value='#rowStatus.index'/>"
															<s:property value="setAttribute('q' +#q.question_id+'_'+#rowStatus.index,#colStatus.index,'checked')"/>
															value="<s:property value="#colStatus.index"/>" /></td>
													</s:iterator>
												</s:if>
												<s:if test="#q.question_type==8">
													<s:iterator
														value="#q.question_other_matrix_col_titleArr"
														status="qomso">
														<td><select
															name="q<s:property value='#q.question_id'/>_<s:property value='#rowStatus.index'/>_<s:property value='#qomso.index'/>">
																<s:iterator
																	value="#q.question_other_matrix_select_optionArr"
																	status="optionStatus" var="option">
																	<option
																		value="<s:property value='#optionStatus.index'/>"
																		<s:property value="setAttribute('q' +#q.question_id+'_'+#rowStatus.index+'_'+#qomso.index,#optionStatus.index,'selected')"/>><s:property /></option>
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
					<br />
					<!-- 上一步 -->
					<s:if test="#session.survey.minPageNumber < echoPage.page_order">
						<s:submit name="submit_last"
							value="%{#session.survey.survey_preText}" />
					</s:if>
					<!-- 下一步 -->
					<s:if test="#session.survey.maxPageNumber > echoPage.page_order">
						<s:submit name="submit_next"
							value="%{#session.survey.survey_nextText}" />
					</s:if>
					<!-- 完成 -->
					<s:if test="#session.survey.maxPageNumber == echoPage.page_order">
						<s:submit name="submit_done"
							value="%{#session.survey.survey_doneText}" />
					</s:if>
					<!-- 退出 -->
					<s:submit name="submit_cancel"
						value="%{#session.survey.survey_exitText}" />
				</div>
			</div>
		</div>
	</s:form>
</body>
</html>
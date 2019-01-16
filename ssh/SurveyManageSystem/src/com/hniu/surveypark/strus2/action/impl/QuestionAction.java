package com.hniu.surveypark.strus2.action.impl;

import com.hniu.surveypark.model.Question;
import com.hniu.surveypark.service.SurveyService;
import com.hniu.surveypark.strus2.action.BaseAction;

public class QuestionAction extends BaseAction<Question> {
	private static final long serialVersionUID = -1500477769034346804L;
	private SurveyService surveyService;

	public void setSurveyService(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	private Integer pageId;
	private Integer surveyId;
	private Integer questionId;

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
		this.model.getPage().setPage_id(pageId);
	}

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
		this.model.getPage().getSurvey().setSurvey_id(surveyId);
	}

	/**
	 * 选择问题类型
	 */
	public String toQuestionTypeChoosePage() {
		return "toQuestionTypeChoosePage";
	}

	/**
	 * 去添加问题页面
	 */
	public String toAddQuestion() {
		return this.model.getQuestion_type() + "";
	}

	/**
	 * 添加问题
	 */
	public String addQuestion() {
		surveyService.saveOrUpdateQuestion(model);
		return "toDesignAction";
	}

	/**
	 * 删除问题
	 */
	public String deleteQuestion() {
		String hql = "delete from Question q where q.question_id=?";
		surveyService.deleteQuestionBatchEntityByHQL(hql, questionId);
		return "toDesignAction";
	}

	/**
	 * 去问题编辑页面
	 */
	public String toEditQuestion() {
		this.model = surveyService.getQuestion(questionId);
		return this.model.getQuestion_type() + "";
	}

	/**
	 * 问题编辑
	 */
	public String editQuestion() {
		surveyService.saveOrUpdateQuestion(model);
		return "toDesignAction";
	}
}

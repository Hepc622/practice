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
	 * ѡ����������
	 */
	public String toQuestionTypeChoosePage() {
		return "toQuestionTypeChoosePage";
	}

	/**
	 * ȥ�������ҳ��
	 */
	public String toAddQuestion() {
		return this.model.getQuestion_type() + "";
	}

	/**
	 * �������
	 */
	public String addQuestion() {
		surveyService.saveOrUpdateQuestion(model);
		return "toDesignAction";
	}

	/**
	 * ɾ������
	 */
	public String deleteQuestion() {
		String hql = "delete from Question q where q.question_id=?";
		surveyService.deleteQuestionBatchEntityByHQL(hql, questionId);
		return "toDesignAction";
	}

	/**
	 * ȥ����༭ҳ��
	 */
	public String toEditQuestion() {
		this.model = surveyService.getQuestion(questionId);
		return this.model.getQuestion_type() + "";
	}

	/**
	 * ����༭
	 */
	public String editQuestion() {
		surveyService.saveOrUpdateQuestion(model);
		return "toDesignAction";
	}
}

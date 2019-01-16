package com.hniu.surveypark.strus2.action.impl;

import java.util.List;

import com.hniu.surveypark.model.Page;
import com.hniu.surveypark.model.Survey;
import com.hniu.surveypark.model.User;
import com.hniu.surveypark.service.SurveyService;
import com.hniu.surveypark.strus2.action.BaseAction;
import com.hniu.surveypark.strus2.action.UserAware;

public class PageAction extends BaseAction<Page> implements UserAware {
	private static final long serialVersionUID = 1L;
	private SurveyService surveyService;
	private Integer surveyId;// ����surveyId
	private Integer pageId;// ҳ��pageId
	private Integer pageStarget;
	private Integer location;// ֮ǰ֮��
	private User user;
	private List<Survey> list;

	public List<Survey> getList() {
		return list;
	}

	public Integer getPageStarget() {
		return pageStarget;
	}

	public void setPageStarget(Integer pageStarget) {
		this.pageStarget = pageStarget;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	public void setSurveyService(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
		if (this.model.getSurvey() != null)
			this.model.getSurvey().setSurvey_id(surveyId);
	}

	/**
	 * ȥ���ҳ��
	 */
	public String toAddPage() {
		return "toAddPage";
	}

	/**
	 * ��ӻ����ҳ��
	 */
	public String addOrEditPage() {
		surveyService.saveOrUpdatePage(model);
		return "toDesignAction";
	}

	/**
	 * ȥ�༭ҳ�����
	 */
	public String toEditPage() {
		this.model = surveyService.getPage(pageId);
		return "toEditPage";
	}

	/**
	 * ɾ��ҳ��
	 */
	public String deletePage() {
		String hql = "";
		// ɾ����
		hql = "delete from Question q where q.page.page_id = ?";
		// ɾ������
		surveyService.deleteQuestionBatchEntityByHQL(hql, pageId);
		hql = "delete from Page p where p.page_id=?";
		// ɾ��ҳ��
		surveyService.deletePageBatchEntityByHQL(hql, pageId);
		return "toDesignAction";
	}

	/**
	 * ȥ����ҳ���ƶ�ҳ
	 */
	public String toMoveOrCopyPage() {
		this.list = surveyService.moveOrCopyAllChildren(user);
		return "toMoveOrCopyPage";
	}

	/**
	 * ����ҳ���ƶ�ҳ
	 */
	public String moveOrCopyPage() {
		surveyService.moveOrCopyPage(surveyId, pageId, pageStarget, location);
		return "toDesignAction";
	}

	/**
	 * ע��user�û�
	 */
	public void setUser(User user) {
		this.user = user;
	}
}

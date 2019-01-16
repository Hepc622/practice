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
	private Integer surveyId;// 接受surveyId
	private Integer pageId;// 页面pageId
	private Integer pageStarget;
	private Integer location;// 之前之后
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
	 * 去添加页面
	 */
	public String toAddPage() {
		return "toAddPage";
	}

	/**
	 * 添加或更新页面
	 */
	public String addOrEditPage() {
		surveyService.saveOrUpdatePage(model);
		return "toDesignAction";
	}

	/**
	 * 去编辑页面标题
	 */
	public String toEditPage() {
		this.model = surveyService.getPage(pageId);
		return "toEditPage";
	}

	/**
	 * 删除页面
	 */
	public String deletePage() {
		String hql = "";
		// 删除答案
		hql = "delete from Question q where q.page.page_id = ?";
		// 删除问题
		surveyService.deleteQuestionBatchEntityByHQL(hql, pageId);
		hql = "delete from Page p where p.page_id=?";
		// 删除页面
		surveyService.deletePageBatchEntityByHQL(hql, pageId);
		return "toDesignAction";
	}

	/**
	 * 去复制页或移动页
	 */
	public String toMoveOrCopyPage() {
		this.list = surveyService.moveOrCopyAllChildren(user);
		return "toMoveOrCopyPage";
	}

	/**
	 * 复制页或移动页
	 */
	public String moveOrCopyPage() {
		surveyService.moveOrCopyPage(surveyId, pageId, pageStarget, location);
		return "toDesignAction";
	}

	/**
	 * 注入user用户
	 */
	public void setUser(User user) {
		this.user = user;
	}
}

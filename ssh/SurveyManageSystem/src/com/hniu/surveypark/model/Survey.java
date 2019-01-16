package com.hniu.surveypark.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Survey {
	private Integer survey_id;
	private String survey_title = "未命名";
	private String survey_preText = "上一步";
	private String survey_nextText = "下一步";
	private String survey_exitText = "退出";
	private String survey_doneText = "完成";
	private Date survey_creatTime = new Date();
	private boolean survey_closed;
	private String survey_logo;
	private User user;
	private Float maxPageNumber;// 最大页面数
	private Float minPageNumber;// 最小页面数
	private Set<Page> page = new HashSet<Page>();

	public Float getMaxPageNumber() {
		return maxPageNumber;
	}

	public void setMaxPageNumber(Float maxPageNumber) {
		this.maxPageNumber = maxPageNumber;
	}

	public Float getMinPageNumber() {
		return minPageNumber;
	}

	public void setMinPageNumber(Float minPageNumber) {
		this.minPageNumber = minPageNumber;
	}


	public boolean getSurvey_closed() {
		return survey_closed;
	}

	public void setSurvey_closed(boolean survey_closed) {
		this.survey_closed = survey_closed;
	}

	public Set<Page> getPage() {
		return page;
	}

	public void setPage(Set<Page> page) {
		this.page = page;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSurvey_logo() {
		return survey_logo;
	}

	public void setSurvey_logo(String survey_logo) {
		this.survey_logo = survey_logo;
	}

	public Integer getSurvey_id() {
		return survey_id;
	}

	public void setSurvey_id(Integer survey_id) {
		this.survey_id = survey_id;
	}

	public String getSurvey_title() {
		return survey_title;
	}

	public void setSurvey_title(String survey_title) {
		this.survey_title = survey_title;
	}

	public String getSurvey_preText() {
		return survey_preText;
	}

	public void setSurvey_preText(String survey_preText) {
		this.survey_preText = survey_preText;
	}

	public String getSurvey_nextText() {
		return survey_nextText;
	}

	public void setSurvey_nextText(String survey_nextText) {
		this.survey_nextText = survey_nextText;
	}

	public String getSurvey_exitText() {
		return survey_exitText;
	}

	public void setSurvey_exitText(String survey_exitText) {
		this.survey_exitText = survey_exitText;
	}

	public String getSurvey_doneText() {
		return survey_doneText;
	}

	public void setSurvey_doneText(String survey_doneText) {
		this.survey_doneText = survey_doneText;
	}

	public Date getSurvey_creatTime() {
		return survey_creatTime;
	}

	public void setSurvey_creatTime(Date survey_creatTime) {
		this.survey_creatTime = survey_creatTime;
	}

}

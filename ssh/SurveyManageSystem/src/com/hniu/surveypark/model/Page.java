package com.hniu.surveypark.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 页面类
 */
public class Page implements Serializable {
	private static final long serialVersionUID = -3383989451409738466L;
	private transient Integer page_id;
	private String page_title = "未命名";
	private String page_description;// 描述
	private Float page_order;
	// 从page到question 一对多
	private Set<Question> question = new HashSet<Question>();// 题目
	private transient Survey survey = new Survey();// 不进行序列化
	
	public Float getPage_order() {
		return page_order;
	}

	public void setPage_order(Float page_order) {
		this.page_order = page_order;
	}

	public Set<Question> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Question> question) {
		this.question = question;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public Integer getPage_id() {
		return page_id;
	}

	public void setPage_id(Integer page_id) {
		this.page_id = page_id;
		if (page_id != null) {
			this.page_order = page_id.floatValue();
		}
	}

	public String getPage_title() {
		return page_title;
	}

	public void setPage_title(String page_title) {
		this.page_title = page_title;
	}

	public String getPage_description() {
		return page_description;
	}

	public void setPage_description(String page_description) {
		this.page_description = page_description;
	}
}

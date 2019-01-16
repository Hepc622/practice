package com.hniu.surveypark.model;

import java.util.Date;

public class Answer {
	private Integer answer_id;
	private Integer question_id;
	private Integer survey_id;
	private String uuId;
	private String question_answer;
	private String question_other_answer;
	private Date createDate;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(Integer answer_id) {
		this.answer_id = answer_id;
	}

	public Integer getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}

	public Integer getSurvey_id() {
		return survey_id;
	}

	public void setSurvey_id(Integer survey_id) {
		this.survey_id = survey_id;
	}

	public String getUuId() {
		return uuId;
	}

	public void setUuId(String uuId) {
		this.uuId = uuId;
	}

	public String getQuestion_answer() {
		return question_answer;
	}

	public void setQuestion_answer(String question_answer) {
		if (question_answer != null)
			this.question_answer = question_answer;
	}

	public String getQuestion_other_answer() {
		return question_other_answer;
	}

	public void setQuestion_other_answer(String question_other_answer) {
		if (question_other_answer != null)
			this.question_other_answer = question_other_answer;
	}

	@Override
	public String toString() {
		return "Answer [answer_id=" + answer_id + ", question_id=" + question_id + ", survey_id=" + survey_id
				+ ", uuId=" + uuId + ", question_answer=" + question_answer + ", question_other_answer="
				+ question_other_answer + ", createDate=" + createDate + "]";
	}

}

package com.hniu.surveypark.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题统计
 */
public class QuestionStatistics {
	private Question question;
	private Integer question_count;

	private List<OptionStatics> question_option = new ArrayList<OptionStatics>();

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Integer getQuestion_count() {
		return question_count;
	}

	public void setQuestion_count(Integer question_count) {
		this.question_count = question_count;
	}

	public List<OptionStatics> getQuestion_option() {
		return question_option;
	}

	public void setQuestion_option(List<OptionStatics> question_option) {
		this.question_option = question_option;
	}

	@Override
	public String toString() {
		return "QuestionStatistics [question=" + question + ", question_count=" + question_count + ", question_option="
				+ question_option + "]";
	}

}

package com.hniu.surveypark.service;

import com.hniu.surveypark.model.QuestionStatistics;

/**
 * 统计服务
 */
public interface StatisticsService {
	/**
	 * 统计问题
	 */
	public QuestionStatistics statisticsQuestion(Integer question_id);
}

package com.hniu.surveypark.service;

import com.hniu.surveypark.model.QuestionStatistics;

/**
 * ͳ�Ʒ���
 */
public interface StatisticsService {
	/**
	 * ͳ������
	 */
	public QuestionStatistics statisticsQuestion(Integer question_id);
}

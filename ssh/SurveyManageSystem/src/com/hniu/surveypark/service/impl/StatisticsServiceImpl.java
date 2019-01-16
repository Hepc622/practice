package com.hniu.surveypark.service.impl;

import com.hniu.surveypark.dao.BaseDao;
import com.hniu.surveypark.model.Answer;
import com.hniu.surveypark.model.OptionStatics;
import com.hniu.surveypark.model.Question;
import com.hniu.surveypark.model.QuestionStatistics;
import com.hniu.surveypark.service.StatisticsService;

/**
 * 统计实现
 */
public class StatisticsServiceImpl implements StatisticsService {
	private BaseDao<Question> questionDao;
	private BaseDao<Answer> answerDao;

	public void setAnswerDao(BaseDao<Answer> answerDao) {
		this.answerDao = answerDao;
	}

	public void setQuestionDao(BaseDao<Question> questionDao) {
		this.questionDao = questionDao;
	}

	/**
	 * 统计问题
	 */
	public QuestionStatistics statisticsQuestion(Integer question_id) {
		QuestionStatistics statistics = new QuestionStatistics();
		Question question = questionDao.getEntity(question_id);
		statistics.setQuestion(question);
		String hql = "select count(*) from Answer a where a.question_id=?";
		// 统计问题回答人数
		Long qCount = (Long) answerDao.uniqueResult(hql, question_id);// 统计语句将其值转成long型
		// 统计该答案选择的人有多少 concat(',',a.question_answer,',') 在某一个列前后加上指定的符号
		hql = "select count(*) from Answer a where a.question_id=? and concat(',',a.question_answer,',') like ? ";
		statistics.setQuestion_count(qCount.intValue());
		// 统计问题选项
		if (question.getQuestion_type() < 6) {// 非矩阵
			OptionStatics optionStatics = null;
			String[] optionArr = question.getQuestion_optionArr();
			for (int i = 0; i < optionArr.length; i++) {
				optionStatics = new OptionStatics();
				optionStatics.setOption_label(optionArr[i]);
				optionStatics.setOption_index(i);
				Long oCount = (Long) answerDao.uniqueResult(hql, question_id, "%," + i + ",%");
				optionStatics.setOption_count(oCount.intValue());
				// 放入到选项集合中
				statistics.getQuestion_option().add(optionStatics);
			}
			// 是否有其他项
			if (question.getQuestion_other_style() != null) {
				optionStatics = new OptionStatics();
				optionStatics.setOption_label("other");
				Long oCount = (Long) answerDao.uniqueResult(hql, question_id, "%,other,%");
				optionStatics.setOption_count(oCount.intValue());
				// 放入到选项集合中
				statistics.getQuestion_option().add(optionStatics);
			}
		} else {// 矩阵
			OptionStatics optionStatics = null;
			String[] qomrt = question.getQuestion_other_matrix_row_titleArr();
			String[] qomct = question.getQuestion_other_matrix_col_titleArr();
			String[] qoso = question.getQuestion_other_matrix_select_optionArr();
			for (int i = 0; i < qomrt.length; i++) {
				for (int j = 0; j < qomct.length; j++) {
					if (question.getQuestion_type() != 8) {
						optionStatics = new OptionStatics();
						optionStatics.setMatrix_row_label(qomrt[i]);
						optionStatics.setMatrix_row_index(i);
						optionStatics.setMatrix_col_label(qomct[j]);
						optionStatics.setMatrix_col_index(j);
						Long oCount = (Long) answerDao.uniqueResult(hql, question_id, ",%" + i + "_" + j + ",%");
						optionStatics.setOption_count(oCount.intValue());
						// 添加到集合中去
						statistics.getQuestion_option().add(optionStatics);
					} else {

						for (int k = 0; k < qoso.length; k++) {
							optionStatics = new OptionStatics();
							optionStatics.setMatrix_row_label(qomrt[i]);
							optionStatics.setMatrix_row_index(i);
							optionStatics.setMatrix_col_label(qomct[j]);
							optionStatics.setMatrix_col_index(j);
							optionStatics.setOption_index(k);
							Long oCount = (Long) answerDao.uniqueResult(hql, question_id,
									"%," + i + "_" + j + "_" + k + ",%");
							optionStatics.setOption_count(oCount.intValue());
							// 添加到集合中去
							statistics.getQuestion_option().add(optionStatics);
						}
					}
				}
			}
		}
		return statistics;
	}

}

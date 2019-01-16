package com.hniu.surveypark.service.impl;

import com.hniu.surveypark.dao.BaseDao;
import com.hniu.surveypark.model.Answer;
import com.hniu.surveypark.model.OptionStatics;
import com.hniu.surveypark.model.Question;
import com.hniu.surveypark.model.QuestionStatistics;
import com.hniu.surveypark.service.StatisticsService;

/**
 * ͳ��ʵ��
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
	 * ͳ������
	 */
	public QuestionStatistics statisticsQuestion(Integer question_id) {
		QuestionStatistics statistics = new QuestionStatistics();
		Question question = questionDao.getEntity(question_id);
		statistics.setQuestion(question);
		String hql = "select count(*) from Answer a where a.question_id=?";
		// ͳ������ش�����
		Long qCount = (Long) answerDao.uniqueResult(hql, question_id);// ͳ����佫��ֵת��long��
		// ͳ�Ƹô�ѡ������ж��� concat(',',a.question_answer,',') ��ĳһ����ǰ�����ָ���ķ���
		hql = "select count(*) from Answer a where a.question_id=? and concat(',',a.question_answer,',') like ? ";
		statistics.setQuestion_count(qCount.intValue());
		// ͳ������ѡ��
		if (question.getQuestion_type() < 6) {// �Ǿ���
			OptionStatics optionStatics = null;
			String[] optionArr = question.getQuestion_optionArr();
			for (int i = 0; i < optionArr.length; i++) {
				optionStatics = new OptionStatics();
				optionStatics.setOption_label(optionArr[i]);
				optionStatics.setOption_index(i);
				Long oCount = (Long) answerDao.uniqueResult(hql, question_id, "%," + i + ",%");
				optionStatics.setOption_count(oCount.intValue());
				// ���뵽ѡ�����
				statistics.getQuestion_option().add(optionStatics);
			}
			// �Ƿ���������
			if (question.getQuestion_other_style() != null) {
				optionStatics = new OptionStatics();
				optionStatics.setOption_label("other");
				Long oCount = (Long) answerDao.uniqueResult(hql, question_id, "%,other,%");
				optionStatics.setOption_count(oCount.intValue());
				// ���뵽ѡ�����
				statistics.getQuestion_option().add(optionStatics);
			}
		} else {// ����
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
						// ��ӵ�������ȥ
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
							// ��ӵ�������ȥ
							statistics.getQuestion_option().add(optionStatics);
						}
					}
				}
			}
		}
		return statistics;
	}

}

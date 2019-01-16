package com.hniu.surveypark.strus2.action.impl;

import java.text.DecimalFormat;
import java.util.List;

import com.hniu.surveypark.model.OptionStatics;
import com.hniu.surveypark.model.Question;
import com.hniu.surveypark.model.QuestionStatistics;
import com.hniu.surveypark.service.StatisticsService;
import com.hniu.surveypark.strus2.action.BaseAction;

public class AnalysisMatrixAction extends BaseAction<Question> {
	private static final long serialVersionUID = -8115632930533975339L;
	private QuestionStatistics qs;
	private StatisticsService statisticsService;
	private Integer questionId;

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public void setStatisticsService(StatisticsService statisticsService) {
		this.statisticsService = statisticsService;
	}

	public QuestionStatistics getQs() {
		return qs;
	}

	/**
	 * ��������ʽ�Ĵ�
	 */
	public String execute() throws Exception {
		// ������Ŀ
		qs = statisticsService.statisticsQuestion(questionId);
		return qs.getQuestion().getQuestion_type() + "";
	}

	/**
	 * ���ٷֱȼ���ã��ٷ�����ʾ����
	 */
	public String getScale(int r, int c) {
		List<OptionStatics> list = qs.getQuestion_option();
		for (OptionStatics o : list) {
			if (o.getMatrix_col_index() == c && o.getMatrix_row_index() == r) {
				Float qCount = (float) qs.getQuestion_count();
				Float oCount = (float) o.getOption_count();
				if (oCount > 0) {
					Float percentage = (oCount / qCount) * 100;
					DecimalFormat format = new DecimalFormat(".##");
					return oCount.intValue() + "(" + format.format(percentage) + ")%";
				}

				break;
			}
		}
		return "";
	}

	/**
	 * ��ȡ������İٷ�֮
	 */
	public String getScale(int r, int c, int o) {
		List<OptionStatics> list = qs.getQuestion_option();
		for (OptionStatics os : list) {
			if (os.getMatrix_col_index() == c && os.getMatrix_row_index() == r && os.getOption_index() == o) {
				Float qCount = (float) qs.getQuestion_count();
				Float oCount = (float) os.getOption_count();
				if (oCount > 0) {
					Float percentage = (oCount / qCount) * 100;
					DecimalFormat format = new DecimalFormat(".##");
					return oCount.intValue() + "(" + format.format(percentage) + ")%";
				}

				break;
			}
		}
		return "";
	}

	public String getPercentage(int r, int c, int o) {
		List<OptionStatics> list = qs.getQuestion_option();
		for (OptionStatics os : list) {
			if (os.getMatrix_col_index() == c && os.getMatrix_row_index() == r && os.getOption_index() == o) {
				Float qCount = (float) qs.getQuestion_count();
				Float oCount = (float) os.getOption_count();
				if (qCount > 0) {
					Float percentage = (oCount / qCount) * 100;
					DecimalFormat format = new DecimalFormat(".##");
					return format.format(percentage);
				}

				break;
			}
		}
		return "";
	}
}

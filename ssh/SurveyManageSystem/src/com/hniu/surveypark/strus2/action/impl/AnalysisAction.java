package com.hniu.surveypark.strus2.action.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jfree.chart.JFreeChart;

import com.hniu.surveypark.model.Answer;
import com.hniu.surveypark.model.OptionStatics;
import com.hniu.surveypark.model.QuestionStatistics;
import com.hniu.surveypark.service.StatisticsService;
import com.hniu.surveypark.strus2.action.BaseAction;
import com.hniu.surveypark.util.JfreeChartUtil;

public class AnalysisAction extends BaseAction<Answer> {
	private static final long serialVersionUID = 1L;
	private Integer chartType;
	private Integer questionId;
	private StatisticsService statisticsService;
	private JFreeChart chart;

	public void setStatisticsService(StatisticsService statisticsService) {
		this.statisticsService = statisticsService;
	}

	public void setChartType(Integer chartType) {
		this.chartType = chartType;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String excute() throws Exception {
		return SUCCESS;
	}

	/**
	 * �������ҳ��
	 */
	public JFreeChart getChart() {
		// ������Ŀ
		QuestionStatistics statistics = statisticsService.statisticsQuestion(questionId);
		// ��ȡ����
		String title = statistics.getQuestion().getQuestion_title();
		// ��ȡͼ������
		List<Object[]> list = getBarOrLineData(statistics);
		// ���ݶ���
		if (chartType < 2) {
			chart = JfreeChartUtil.creatPie(title, getPieData(statistics), null, chartType, 0, 0, 0);
		} else if (chartType < 6) {
			chart = JfreeChartUtil.creatBar(title, "", "", list, null, chartType, 0, 0, 0);
		} else {
			chart = JfreeChartUtil.creatLine(title, "", "", list, null, chartType, 0, 0, 0);
		}
		return chart;
	}

	/**
	 * ��ȡ��ͼ����
	 */
	private Map<String, Number> getPieData(QuestionStatistics statistics) {
		List<OptionStatics> list = statistics.getQuestion_option();
		Map<String, Number> map = new HashMap<String, Number>();
		for (OptionStatics option : list) {
			map.put(option.getOption_label(), option.getOption_count());
		}
		return map;
	}

	/**
	 * ��ȡ���ͻ�����������
	 */
	private List<Object[]> getBarOrLineData(QuestionStatistics statistics) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (OptionStatics o : statistics.getQuestion_option()) {
			if (o != null) {
				Object[] object = new Object[3];
				object[0] = o.getOption_count();
				object[1] = o.getOption_label();
				if (o.getOption_index() == null) {
					object[2] = "other";
				} else {
					object[2] = o.getOption_index();
				}
				list.add(object);
			}
		}
		return list;
	}

}

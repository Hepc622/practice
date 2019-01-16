package com.hniu.surveypark.service;

import java.util.List;
import java.util.Map;

import com.hniu.surveypark.model.Answer;
import com.hniu.surveypark.model.Page;
import com.hniu.surveypark.model.Question;
import com.hniu.surveypark.model.Survey;
import com.hniu.surveypark.model.User;

/**
 * 调查service
 */
public interface SurveyService {

	/**
	 * 我的调查
	 */
	public List<Survey> mySurvey(User user);

	/**
	 * 新建调查
	 */
	public Survey newSurvey(User user);

	/**
	 * 获取Survey
	 */
	public Survey getSurvey(Integer surveyId);

	/**
	 * 获取Survey，及其子数据page,question
	 */
	public Survey getSurveyWithChild(Integer surveyId);

	/**
	 * 更新survey
	 */
	public void updateSurvey(Survey survey);

	/**
	 * 添加页面
	 */
	public void saveOrUpdatePage(Page page);

	/**
	 * 获取页面
	 */
	public Page getPage(Integer pageId);

	/**
	 * 通过调查获取调查的第一个页面
	 */
	public Page getFirstPageOfSurvey(Survey survey);

	/**
	 * 保存问题
	 */
	public void saveOrUpdateQuestion(Question model);

	/**
	 * 获取问题
	 */
	public Question getQuestion(Integer questionId);

	/**
	 * 批量删除问题
	 */
	public void deleteQuestionBatchEntityByHQL(String hql, Object... str);

	/**
	 * 批量删除页面
	 */
	public void deletePageBatchEntityByHQL(String hql, Object... str);

	/**
	 * 删除调查
	 */
	public void deleteSurveyBatchEntityByHQL(String hql, Object... str);

	/**
	 * 保存logo的路径
	 */
	public void saveSurveyLogoPath(String hql, Object... str);

	/**
	 * 获取所有survey的所有子类
	 */
	public List<Survey> moveOrCopyAllChildren(User user);

	/**
	 * 移动或者复制
	 */
	public void moveOrCopyPage(Integer surveyId, Integer pageId, Integer pageStarget, Integer location);

	/**
	 * 通过指定的survey获取当前页面的前一个页面或者后一个页面
	 */
	public Page getFirstOrNextOrderOfPage(Integer survey_id, Float currentPageOrder, Integer first);

	/**
	 * 保存所有的答案
	 */
	public void saveAnswer(Map<String, Object> session, String allparameters, String currentsurvey);

	/**
	 * 查询以开放的调查
	 */
	public List<Survey> ableSurvey(User user, Boolean i);

	/**
	 * 收集所有的调查答案
	 */
	public List<Answer> allAnwser(Integer surveyId);

	/**
	 * 获取当前survey有多少个题目
	 */
	public List<Question> getAllQuestion(Integer surveyId);

	/**
	 * 清楚调查
	 */
	public void clearSurvey(Integer surveyId);
}

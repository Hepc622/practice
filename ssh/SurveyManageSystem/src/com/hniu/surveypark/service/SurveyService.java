package com.hniu.surveypark.service;

import java.util.List;
import java.util.Map;

import com.hniu.surveypark.model.Answer;
import com.hniu.surveypark.model.Page;
import com.hniu.surveypark.model.Question;
import com.hniu.surveypark.model.Survey;
import com.hniu.surveypark.model.User;

/**
 * ����service
 */
public interface SurveyService {

	/**
	 * �ҵĵ���
	 */
	public List<Survey> mySurvey(User user);

	/**
	 * �½�����
	 */
	public Survey newSurvey(User user);

	/**
	 * ��ȡSurvey
	 */
	public Survey getSurvey(Integer surveyId);

	/**
	 * ��ȡSurvey������������page,question
	 */
	public Survey getSurveyWithChild(Integer surveyId);

	/**
	 * ����survey
	 */
	public void updateSurvey(Survey survey);

	/**
	 * ���ҳ��
	 */
	public void saveOrUpdatePage(Page page);

	/**
	 * ��ȡҳ��
	 */
	public Page getPage(Integer pageId);

	/**
	 * ͨ�������ȡ����ĵ�һ��ҳ��
	 */
	public Page getFirstPageOfSurvey(Survey survey);

	/**
	 * ��������
	 */
	public void saveOrUpdateQuestion(Question model);

	/**
	 * ��ȡ����
	 */
	public Question getQuestion(Integer questionId);

	/**
	 * ����ɾ������
	 */
	public void deleteQuestionBatchEntityByHQL(String hql, Object... str);

	/**
	 * ����ɾ��ҳ��
	 */
	public void deletePageBatchEntityByHQL(String hql, Object... str);

	/**
	 * ɾ������
	 */
	public void deleteSurveyBatchEntityByHQL(String hql, Object... str);

	/**
	 * ����logo��·��
	 */
	public void saveSurveyLogoPath(String hql, Object... str);

	/**
	 * ��ȡ����survey����������
	 */
	public List<Survey> moveOrCopyAllChildren(User user);

	/**
	 * �ƶ����߸���
	 */
	public void moveOrCopyPage(Integer surveyId, Integer pageId, Integer pageStarget, Integer location);

	/**
	 * ͨ��ָ����survey��ȡ��ǰҳ���ǰһ��ҳ����ߺ�һ��ҳ��
	 */
	public Page getFirstOrNextOrderOfPage(Integer survey_id, Float currentPageOrder, Integer first);

	/**
	 * �������еĴ�
	 */
	public void saveAnswer(Map<String, Object> session, String allparameters, String currentsurvey);

	/**
	 * ��ѯ�Կ��ŵĵ���
	 */
	public List<Survey> ableSurvey(User user, Boolean i);

	/**
	 * �ռ����еĵ����
	 */
	public List<Answer> allAnwser(Integer surveyId);

	/**
	 * ��ȡ��ǰsurvey�ж��ٸ���Ŀ
	 */
	public List<Question> getAllQuestion(Integer surveyId);

	/**
	 * �������
	 */
	public void clearSurvey(Integer surveyId);
}

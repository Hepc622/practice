package com.hniu.surveypark.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import com.hniu.surveypark.dao.BaseDao;
import com.hniu.surveypark.model.Answer;
import com.hniu.surveypark.model.Page;
import com.hniu.surveypark.model.Question;
import com.hniu.surveypark.model.Survey;
import com.hniu.surveypark.model.User;
import com.hniu.surveypark.service.SurveyService;
import com.hniu.surveypark.util.DataUtil;
import com.hniu.surveypark.util.StringUtil;

public class SurveyServiceImpl implements SurveyService {
	private BaseDao<Survey> surveyDao;

	private BaseDao<Page> pageDao;

	private BaseDao<Question> questionDao;

	private BaseDao<Answer> answerDao;

	public void setAnswerDao(BaseDao<Answer> answerDao) {
		this.answerDao = answerDao;
	}

	public void setQuestionDao(BaseDao<Question> questionDao) {
		this.questionDao = questionDao;
	}

	public void setSurveyDao(BaseDao<Survey> surveyDao) {
		this.surveyDao = surveyDao;
	}

	public void setPageDao(BaseDao<Page> pageDao) {
		this.pageDao = pageDao;
	}

	/**
	 * �ҵĵ���
	 */
	public List<Survey> mySurvey(User user) {
		String hql = "from Survey s where s.user=?";
		return surveyDao.findEntityByHQL(hql, user);
	}

	/**
	 * �½�����
	 */
	public Survey newSurvey(User user) {
		Survey s = new Survey();
		s.setUser(user);
		surveyDao.saveEntity(s);
		return s;
	}

	/**
	 * ��ȡsurvey����
	 */
	public Survey getSurvey(Integer surveyId) {
		return surveyDao.getEntity(surveyId);
	}

	/**
	 * ��ȡsurvey�����������page,question
	 */
	public Survey getSurveyWithChild(Integer surveyId) {
		Survey survey = this.getSurvey(surveyId);
		// ��ʼ��user
		survey.getUser();
		// ǿ�н�question��ʼ��
		for (Page page : survey.getPage()) {
			page.getQuestion().size();
		}
		return survey;
	}

	/**
	 * ����survey
	 */
	public void updateSurvey(Survey survey) {
		surveyDao.saveOrUpdateEntity(survey);
	}

	/**
	 * ���ҳ��
	 */
	public void saveOrUpdatePage(Page page) {
		pageDao.saveOrUpdateEntity(page);
	}

	/**
	 * ��ȡҳ��
	 */
	public Page getPage(Integer pageId) {
		return pageDao.getEntity(pageId);
	}

	/**
	 * ͨ�������ȡ������ĵ�һ��ҳ��
	 */
	public Page getFirstPageOfSurvey(Survey survey) {
		// ��ȡ�����е�id
		Integer survey_id = survey.getSurvey_id();
		// ͨ��id����ȡ�õ���ĵ�һ��ҳ��
		String hql = "from Page p where p.survey.survey_id=? order by p.page_order asc";
		List<Page> list = pageDao.findEntityByHQL(hql, survey_id);
		// ǿ�г�ʼ��
		for (Page page : list) {
			page.getQuestion().size();
		}
		return list.get(0);
	}

	/**
	 * ��������
	 */
	public void saveOrUpdateQuestion(Question question) {

		questionDao.saveOrUpdateEntity(question);
	}

	/**
	 * ����ɾ������
	 */
	public void deleteQuestionBatchEntityByHQL(String hql, Object... str) {
		questionDao.batchEntityByHQL(hql, str);
	}

	/**
	 * ��ȡ����
	 */
	public Question getQuestion(Integer questionId) {
		return questionDao.getEntity(questionId);
	}

	/**
	 * ����ɾ��ҳ��
	 */
	public void deletePageBatchEntityByHQL(String hql, Object... str) {
		pageDao.batchEntityByHQL(hql, str);
	}

	/**
	 * ɾ������
	 */
	public void deleteSurveyBatchEntityByHQL(String hql, Object... str) {
		surveyDao.batchEntityByHQL(hql, str);
	}

	/**
	 * ����logoͼ��·��
	 */
	public void saveSurveyLogoPath(String hql, Object... str) {
		surveyDao.batchEntityByHQL(hql, str);
	}

	/**
	 * ��ȡ���е�survey������֮��
	 */
	public List<Survey> moveOrCopyAllChildren(User user) {
		String hql = "from Survey s where s.user.user_id=?";
		List<Survey> list = surveyDao.findEntityByHQL(hql, user.getUser_id());
		for (Survey survey : list) {
			survey.getPage().size();
		}
		return list;
	}

	/**
	 * ���ƻ��ƶ�
	 */
	public void moveOrCopyPage(Integer surveyId, Integer pageId, Integer pageStarget, Integer location) {
		// ��ȡ��ҳ���Ƿ���survey��
		Page page = pageDao.getEntity(pageId);
		for (Question question : page.getQuestion()) {
			question.toString();
		}
		if (location != null) {
			if (page.getSurvey().getSurvey_id() == surveyId) {// �����飬ֱ�Ӹ���page�����
				// ����ҳ���
				Page movePage = movePage(surveyId, location, pageStarget, page);
				// �������µ����ݿ���ȥ
				pageDao.saveOrUpdateEntity(movePage);
			} else {// �Ǳ����飬�Ƚ�����ȸ��ƣ��ٽ��и���page�����
				Survey survey = surveyDao.getEntity(surveyId);
				// ��ȸ���
				Page copyPage = (Page) DataUtil.copyObejct(page);
				// ����ҳ��
				Page movePage = movePage(surveyId, location, pageStarget, copyPage);
				// ��survey���뵽ҳ����
				movePage.setSurvey(survey);
				// �������µ����ݿ���ȥ
				pageDao.saveOrUpdateEntity(movePage);
			}
		}

	}

	/**
	 * �ƶ�ҳ��
	 */
	private Page movePage(Integer surveyId, Integer location, Integer pageStarget, Page page) {
		Page starget = pageDao.getEntity(pageStarget);
		Float stargetOrder = starget.getPage_order();
		if (location == 1) {// ֮�����
			setAfterOrBeforePageOrder(surveyId, location, stargetOrder, page);
		} else {// ֮ǰ����
			setAfterOrBeforePageOrder(surveyId, location, stargetOrder, page);
		}
		return page;
	}

	/**
	 * ��ȡָ��ҳ���ǰһ�����һ��ҳ��
	 */
	private void setAfterOrBeforePageOrder(Integer surveyId, Integer location, Float stargetOrder, Page page) {
		String hql;
		List<Page> list;
		if (location == 1) {
			hql = "from Page p where p.page_order>?+0.001f and p.survey.survey_id=? order by p.page_order asc";
		} else {
			hql = "from Page p where p.page_order<? and p.survey.survey_id=? order by p.page_order desc";
		}
		list = pageDao.findEntityByHQL(hql, stargetOrder, surveyId);
		if (list.size() > 0) {// ȡ������ҳ��֮���ƽ��ֵ
			page.setPage_order((stargetOrder + list.get(0).getPage_order()) / 2);
		} else {
			if (location == 1) {// ��ָ��ҳ����Ŀ��ҳ��Ļ����ϼӸ�0.001
				page.setPage_order(stargetOrder + 0.001f);
			} else {// ��ָ��ҳ����Ŀ��ҳ��Ļ����ϼ���0.001
				page.setPage_order(stargetOrder - 0.001f);
			}
		}
	}

	/**
	 * ͨ��ָ����survey��ȡ��ǰҳ���ǰһ��ҳ����ߺ�һ��ҳ��
	 */
	public Page getFirstOrNextOrderOfPage(Integer survey_id, Float currentPageOrder, Integer first) {
		String hql;
		List<Page> list;
		if (first == 1) {
			hql = "from Page p where p.page_order>?+0.001f and p.survey.survey_id=? order by p.page_order asc";
		} else {
			hql = "from Page p where p.page_order<? and p.survey.survey_id=? order by p.page_order desc";
		}
		list = pageDao.findEntityByHQL(hql, currentPageOrder, survey_id);
		if (list.size() > 0) {
			for (Page page : list) {
				page.getQuestion().size();
			}
		}
		return list.size() > 0 ? list.get(0) : null;
	}

	/**
	 * �������еĴ�
	 */
	public void saveAnswer(Map<String, Object> session, String allparameters, String currentsurvey) {
		// �������������
		String uuid = UUID.randomUUID().toString();
		// ���������ʱ��
		Date date = new Date();
		for (Answer answer : getAnswerList(session, allparameters, currentsurvey)) {
			// ���ý�ȥ
			answer.setCreateDate(date);
			answer.setUuId(uuid);
			answerDao.saveEntity(answer);
		}
	}

	/**
	 * ��ȡ��ǰ��survey���е������
	 */
	@SuppressWarnings("unchecked")
	private List<Answer> getAnswerList(Map<String, Object> session, String allparameters, String currentsurvey) {
		// ��session�л�ȡ����map
		Map<String, Map<String, String[]>> allparameter = (Map<String, Map<String, String[]>>) session
				.get(allparameters);
		// list
		List<Answer> list = new ArrayList<Answer>();
		// ��ȡ���еĴ�map
		for (Entry<String, Map<String, String[]>> map : allparameter.entrySet()) {
			// ��ȡ��Ӧҳ���mapֵ
			Map<String, String[]> value = (Map<String, String[]>) map.getValue();
			// ȡ��map��Ĵ𰸼�ֵ��
			for (Entry<String, String[]> entry : value.entrySet()) {
				// ��ȡkey
				String key = entry.getKey();
				// ��ȡֵ
				String[] values = entry.getValue();
				// ��ȡ����id
				Survey survey = (Survey) session.get(currentsurvey);
				Integer survey_id = survey.getSurvey_id();
				// �Ǿ�����
				if (key.startsWith("q") && !key.contains("_") && !key.contains("other")) {
					// �����𰸶���
					Answer answer = new Answer();
					// ȡ������id
					String qustion_id = StringUtil.splitQustionId(key, key.indexOf("q") + 1);
					// ���������ַ���
					String answerStr = StringUtil.ArrayToString(values, ",");
					// ����answer����
					answer.setQuestion_id(Integer.parseInt(qustion_id));
					answer.setSurvey_id(survey_id);
					String otherAnswer = getOtherAnswer(qustion_id, value);
					if (otherAnswer != null) {
						answer.setQuestion_answer(answerStr + ",other");
					} else {
						answer.setQuestion_answer(answerStr);
					}
					answer.setQuestion_other_answer(otherAnswer);
					// ��ӵ�������ȥ
					list.add(answer);
				} else if (key.contains("_") && key.contains("q")) {// ����ʽ��
					// ��ȡq���±�
					int begin = key.indexOf("q");
					// ��ȡ'_'���±�
					int end = key.indexOf("_");
					String qustion_id = StringUtil.splitQustionId(key, (begin + 1), end);
					// �жϼ�������û���������id�Ķ��󣬾Ͳ������
					if (getCountQuestionIdfromList(qustion_id, list) == 0) {
						// �����𰸶���
						Answer answer = new Answer();
						answer.setQuestion_id(Integer.parseInt(qustion_id));
						answer.setSurvey_id(survey_id);
						answer.setQuestion_answer(getMatrxAnswer(qustion_id, value));
						// ��ӵ�������
						list.add(answer);
					}
				}
			}
		}
		return list;
	}

	/**
	 * ��ȡ�������Ƿ��и�����Ĵ���
	 */
	private Integer getCountQuestionIdfromList(String id, List<Answer> list) {
		Integer count = 0;
		for (Answer answer : list) {
			String question_id = answer.getQuestion_id().toString();
			if (question_id.equals(id)) {
				count = count + 1;
			}
		}
		return count;
	}

	/**
	 * ��ȡ����ʽ��
	 */
	private String getMatrxAnswer(String question_id, Map<String, String[]> value) {
		String answer = "";
		for (Entry<String, String[]> entry : value.entrySet()) {
			String key = entry.getKey();
			String[] values = entry.getValue();
			if (key.contains(question_id)) {
				int begin = key.indexOf("_");
				for (String string : values) {
					// ��ƴ��
					answer = answer + StringUtil.splitQustionId(key, begin + 1) + "_" + string + ",";
				}
			}
		}
		answer = answer.substring(0, answer.length() - 1);
		return answer;
	}

	/*
	 * ��ȡ������
	 */
	private String getOtherAnswer(String question_id, Map<String, String[]> value) {
		for (Entry<String, String[]> entry : value.entrySet()) {
			String key = entry.getKey();
			String[] values = entry.getValue();
			if (key.contains("other") && key.contains(question_id)) {
				String str = StringUtil.ArrayToString(values, ",");
				if (str != null && !str.equals(""))
					return str;
			}
		}
		return null;
	}

	/**
	 * �ѿ��ŵĵ���
	 */
	public List<Survey> ableSurvey(User user, Boolean i) {
		String hql = "from Survey s where s.user=? and s.survey_closed=?";
		return surveyDao.findEntityByHQL(hql, user, i);
	}

	/**
	 * �ռ�������Ϣ
	 */
	public List<Answer> allAnwser(Integer surveyId) {
		String hql = "from Answer a where a.survey_id=?";
		return answerDao.findEntityByHQL(hql, surveyId);
	}

	/**
	 * ��ȡsurvey�ж��ٸ�����
	 */
	public List<Question> getAllQuestion(Integer surveyId) {
		String hql = "from Question q where q.page.survey=(from Survey s where s.survey_id=?)";
		return questionDao.findEntityByHQL(hql, surveyId);
	}

	@Override
	public void clearSurvey(Integer surveyId) {
		String hql = "delete Answer.* form Answer a where a.survey_id=?";
		answerDao.batchEntityByHQL(hql, surveyId);
	}
}

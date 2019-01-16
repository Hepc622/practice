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
	 * 我的调查
	 */
	public List<Survey> mySurvey(User user) {
		String hql = "from Survey s where s.user=?";
		return surveyDao.findEntityByHQL(hql, user);
	}

	/**
	 * 新建调查
	 */
	public Survey newSurvey(User user) {
		Survey s = new Survey();
		s.setUser(user);
		surveyDao.saveEntity(s);
		return s;
	}

	/**
	 * 获取survey对象
	 */
	public Survey getSurvey(Integer surveyId) {
		return surveyDao.getEntity(surveyId);
	}

	/**
	 * 获取survey对象及子类对象page,question
	 */
	public Survey getSurveyWithChild(Integer surveyId) {
		Survey survey = this.getSurvey(surveyId);
		// 初始化user
		survey.getUser();
		// 强行将question初始化
		for (Page page : survey.getPage()) {
			page.getQuestion().size();
		}
		return survey;
	}

	/**
	 * 更新survey
	 */
	public void updateSurvey(Survey survey) {
		surveyDao.saveOrUpdateEntity(survey);
	}

	/**
	 * 添加页面
	 */
	public void saveOrUpdatePage(Page page) {
		pageDao.saveOrUpdateEntity(page);
	}

	/**
	 * 获取页面
	 */
	public Page getPage(Integer pageId) {
		return pageDao.getEntity(pageId);
	}

	/**
	 * 通过调查获取到调查的第一个页面
	 */
	public Page getFirstPageOfSurvey(Survey survey) {
		// 获取调查中的id
		Integer survey_id = survey.getSurvey_id();
		// 通过id来获取该调查的第一个页面
		String hql = "from Page p where p.survey.survey_id=? order by p.page_order asc";
		List<Page> list = pageDao.findEntityByHQL(hql, survey_id);
		// 强行初始化
		for (Page page : list) {
			page.getQuestion().size();
		}
		return list.get(0);
	}

	/**
	 * 保存问题
	 */
	public void saveOrUpdateQuestion(Question question) {

		questionDao.saveOrUpdateEntity(question);
	}

	/**
	 * 批量删除问题
	 */
	public void deleteQuestionBatchEntityByHQL(String hql, Object... str) {
		questionDao.batchEntityByHQL(hql, str);
	}

	/**
	 * 获取问题
	 */
	public Question getQuestion(Integer questionId) {
		return questionDao.getEntity(questionId);
	}

	/**
	 * 批量删除页面
	 */
	public void deletePageBatchEntityByHQL(String hql, Object... str) {
		pageDao.batchEntityByHQL(hql, str);
	}

	/**
	 * 删除调查
	 */
	public void deleteSurveyBatchEntityByHQL(String hql, Object... str) {
		surveyDao.batchEntityByHQL(hql, str);
	}

	/**
	 * 保存logo图标路径
	 */
	public void saveSurveyLogoPath(String hql, Object... str) {
		surveyDao.batchEntityByHQL(hql, str);
	}

	/**
	 * 获取所有的survey的所有之类
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
	 * 复制或移动
	 */
	public void moveOrCopyPage(Integer surveyId, Integer pageId, Integer pageStarget, Integer location) {
		// 获取该页面是否在survey中
		Page page = pageDao.getEntity(pageId);
		for (Question question : page.getQuestion()) {
			question.toString();
		}
		if (location != null) {
			if (page.getSurvey().getSurvey_id() == surveyId) {// 本调查，直接更改page的序号
				// 更改页面号
				Page movePage = movePage(surveyId, location, pageStarget, page);
				// 将他更新到数据库中去
				pageDao.saveOrUpdateEntity(movePage);
			} else {// 非本调查，先进行深度复制，再进行更改page的序号
				Survey survey = surveyDao.getEntity(surveyId);
				// 深度复制
				Page copyPage = (Page) DataUtil.copyObejct(page);
				// 更换页面
				Page movePage = movePage(surveyId, location, pageStarget, copyPage);
				// 将survey插入到页面中
				movePage.setSurvey(survey);
				// 将他更新到数据库中去
				pageDao.saveOrUpdateEntity(movePage);
			}
		}

	}

	/**
	 * 移动页面
	 */
	private Page movePage(Integer surveyId, Integer location, Integer pageStarget, Page page) {
		Page starget = pageDao.getEntity(pageStarget);
		Float stargetOrder = starget.getPage_order();
		if (location == 1) {// 之后操作
			setAfterOrBeforePageOrder(surveyId, location, stargetOrder, page);
		} else {// 之前操作
			setAfterOrBeforePageOrder(surveyId, location, stargetOrder, page);
		}
		return page;
	}

	/**
	 * 获取指定页面的前一个或后一个页面
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
		if (list.size() > 0) {// 取出两个页面之间的平均值
			page.setPage_order((stargetOrder + list.get(0).getPage_order()) / 2);
		} else {
			if (location == 1) {// 让指定页面在目标页面的基础上加个0.001
				page.setPage_order(stargetOrder + 0.001f);
			} else {// 让指定页面在目标页面的基础上减个0.001
				page.setPage_order(stargetOrder - 0.001f);
			}
		}
	}

	/**
	 * 通过指定的survey获取当前页面的前一个页面或者后一个页面
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
	 * 保存所有的答案
	 */
	public void saveAnswer(Map<String, Object> session, String allparameters, String currentsurvey) {
		// 创建答案入库批次
		String uuid = UUID.randomUUID().toString();
		// 创建答案入库时间
		Date date = new Date();
		for (Answer answer : getAnswerList(session, allparameters, currentsurvey)) {
			// 设置进去
			answer.setCreateDate(date);
			answer.setUuId(uuid);
			answerDao.saveEntity(answer);
		}
	}

	/**
	 * 获取当前的survey所有的问题答案
	 */
	@SuppressWarnings("unchecked")
	private List<Answer> getAnswerList(Map<String, Object> session, String allparameters, String currentsurvey) {
		// 从session中获取参数map
		Map<String, Map<String, String[]>> allparameter = (Map<String, Map<String, String[]>>) session
				.get(allparameters);
		// list
		List<Answer> list = new ArrayList<Answer>();
		// 获取所有的答案map
		for (Entry<String, Map<String, String[]>> map : allparameter.entrySet()) {
			// 获取对应页面的map值
			Map<String, String[]> value = (Map<String, String[]>) map.getValue();
			// 取出map你的答案键值对
			for (Entry<String, String[]> entry : value.entrySet()) {
				// 获取key
				String key = entry.getKey();
				// 获取值
				String[] values = entry.getValue();
				// 获取调查id
				Survey survey = (Survey) session.get(currentsurvey);
				Integer survey_id = survey.getSurvey_id();
				// 非矩阵题
				if (key.startsWith("q") && !key.contains("_") && !key.contains("other")) {
					// 创建答案对象
					Answer answer = new Answer();
					// 取出问题id
					String qustion_id = StringUtil.splitQustionId(key, key.indexOf("q") + 1);
					// 将数组变成字符串
					String answerStr = StringUtil.ArrayToString(values, ",");
					// 设置answer属性
					answer.setQuestion_id(Integer.parseInt(qustion_id));
					answer.setSurvey_id(survey_id);
					String otherAnswer = getOtherAnswer(qustion_id, value);
					if (otherAnswer != null) {
						answer.setQuestion_answer(answerStr + ",other");
					} else {
						answer.setQuestion_answer(answerStr);
					}
					answer.setQuestion_other_answer(otherAnswer);
					// 添加到集合里去
					list.add(answer);
				} else if (key.contains("_") && key.contains("q")) {// 矩阵式答案
					// 获取q的下表
					int begin = key.indexOf("q");
					// 获取'_'的下表
					int end = key.indexOf("_");
					String qustion_id = StringUtil.splitQustionId(key, (begin + 1), end);
					// 判断集合你有没有这个问题id的对象，就不添加了
					if (getCountQuestionIdfromList(qustion_id, list) == 0) {
						// 创建答案对象
						Answer answer = new Answer();
						answer.setQuestion_id(Integer.parseInt(qustion_id));
						answer.setSurvey_id(survey_id);
						answer.setQuestion_answer(getMatrxAnswer(qustion_id, value));
						// 添加到集合里
						list.add(answer);
					}
				}
			}
		}
		return list;
	}

	/**
	 * 获取集合中是否有该问题的答案类
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
	 * 获取矩阵式答案
	 */
	private String getMatrxAnswer(String question_id, Map<String, String[]> value) {
		String answer = "";
		for (Entry<String, String[]> entry : value.entrySet()) {
			String key = entry.getKey();
			String[] values = entry.getValue();
			if (key.contains(question_id)) {
				int begin = key.indexOf("_");
				for (String string : values) {
					// 组拼答案
					answer = answer + StringUtil.splitQustionId(key, begin + 1) + "_" + string + ",";
				}
			}
		}
		answer = answer.substring(0, answer.length() - 1);
		return answer;
	}

	/*
	 * 获取其他答案
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
	 * 已开放的调查
	 */
	public List<Survey> ableSurvey(User user, Boolean i) {
		String hql = "from Survey s where s.user=? and s.survey_closed=?";
		return surveyDao.findEntityByHQL(hql, user, i);
	}

	/**
	 * 收集调查信息
	 */
	public List<Answer> allAnwser(Integer surveyId) {
		String hql = "from Answer a where a.survey_id=?";
		return answerDao.findEntityByHQL(hql, surveyId);
	}

	/**
	 * 获取survey有多少个问题
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

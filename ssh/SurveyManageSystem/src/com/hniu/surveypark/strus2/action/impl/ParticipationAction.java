package com.hniu.surveypark.strus2.action.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;

import com.hniu.surveypark.model.Page;
import com.hniu.surveypark.model.Survey;
import com.hniu.surveypark.model.User;
import com.hniu.surveypark.service.SurveyService;
import com.hniu.surveypark.strus2.action.BaseAction;
import com.hniu.surveypark.strus2.action.UserAware;
import com.hniu.surveypark.util.StringUtil;

public class ParticipationAction extends BaseAction<Survey> implements UserAware, SessionAware, ParameterAware {
	private static final long serialVersionUID = 8200585375206120088L;
	private User user;// 接受用户
	private SurveyService surveyService;// 接受SurveyService
	private List<Survey> surveys;// 调查集合
	private Float currentPageOrder;
	private Integer currentPageId;
	private Page echoPage;
	private Map<String, Object> session;
	private Map<String, String[]> parameters;
	private static final String CURRENTSURVEY = "survey";
	private static final String ALLPARAMETERS = "allparameters";
	private static final Integer First = 0;
	private static final Integer NEXT = 1;

	public Integer getCurrentPageId() {
		return currentPageId;
	}

	public Float getCurrentPageOrder() {
		return currentPageOrder;
	}

	public void setCurrentPageOrder(Float currentPageOrder) {
		this.currentPageOrder = currentPageOrder;
	}

	public void setCurrentPageId(Integer currentPageId) {
		this.currentPageId = currentPageId;
	}

	public Page getEchoPage() {
		return echoPage;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveyService(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * 去参与调查页面
	 */
	public String toParticipation() {
		// 移除出user外的所有数据
		removeSession();
		// 获取在线用户的所有调查
		this.surveys = surveyService.ableSurvey(user, true);
		return "toParticipation";
	}

	/**
	 * 参与调查
	 */
	public String participation() {
		Survey survey = surveyService.getSurvey(this.model.getSurvey_id());
		// 获取该调查的第一个页面
		this.echoPage = surveyService.getFirstPageOfSurvey(survey);
		// 将标题设计在session中
		session.put(CURRENTSURVEY, survey);
		session.put(ALLPARAMETERS, new HashMap<String, Map<String, String[]>>());
		// 将第一个页面获取出来
		return "participation";
	}

	/**
	 * 调查操作
	 */
	public String participationOption() {
		// 获取当前的survey
		Survey survey = (Survey) session.get(CURRENTSURVEY);
		// 明确是哪一个按钮
		String buttomName = getButtomName();
		if (buttomName != null) {
			if (buttomName.endsWith("_last")) {// 上一步
				// 获取当前页面的上一个页面
				this.echoPage = surveyService.getFirstOrNextOrderOfPage(survey.getSurvey_id(), currentPageOrder, First);
				// 将提交过的数据回显
				saveDataToSession(currentPageId + "", parameters);
			} else if (buttomName.endsWith("_next")) {// 下一步
				// 获取当前页面的下一个页面
				this.echoPage = surveyService.getFirstOrNextOrderOfPage(survey.getSurvey_id(), currentPageOrder, NEXT);
				// 将当前页面的结果保存在session中
				saveDataToSession(currentPageId + "", parameters);
			} else if (buttomName.endsWith("_done")) {// 完成
				// 将当前页面的结果保存在session中
				saveDataToSession(currentPageId + "", parameters);
				// 将答案入库
				surveyService.saveAnswer(session, ALLPARAMETERS, CURRENTSURVEY);
				// 清楚session
				removeSession();
				return "cancelToParticipation";
			} else if (buttomName.endsWith("_cancel")) {// 取消
				// 退出，清楚session的所有数据
				removeSession();
				return "cancelToParticipation";
			}
		}
		return "participation";
	}

	/**
	 * 将表单数据保存在session中以页面id为key
	 */
	@SuppressWarnings("unchecked")
	private void saveDataToSession(String key, Map<String, String[]> value) {
		// 获取session的所有参数MAP
		Map<String, Map<String, String[]>> parameters = (Map<String, Map<String, String[]>>) session.get(ALLPARAMETERS);
		// 设置参数进去
		parameters.put(key, value);
	}

	/**
	 * 移除出user外的所有session数据
	 */
	private void removeSession() {
		for (String key : session.keySet()) {
			// 清除除用户为的所有session数据
			if (!key.equals("user")) {
				session.remove(key);
			}
		}
	}

	/**
	 * 获取按钮的名字
	 */
	private String getButtomName() {
		for (String key : parameters.keySet()) {
			// 判断是哪一个按钮提交的
			if (key.startsWith("submit_")) {
				// 取出按钮名称
				return key;
			}
		}
		return null;
	}

	/**
	 * 设置标签属性
	 */
	@SuppressWarnings("unchecked")
	public String setAttribute(String name, String value, String tag) {
		// 从session中获取所有的参数
		Map<String, Map<String, String[]>> parametersAll = (Map<String, Map<String, String[]>>) session
				.get(ALLPARAMETERS);
		Map<String, String[]> map = parametersAll.get(echoPage.getPage_id() + "");
		// 从session中获取出对应的页面数据
		// 返回属性
		return StringUtil.isExistAttr(map, name, value, tag);
	}

	// 注入user
	public void setUser(User user) {
		this.user = user;
	}

	// 注入session
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	// 注入parameter所有提交过来的参数
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}
}

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
	private User user;// �����û�
	private SurveyService surveyService;// ����SurveyService
	private List<Survey> surveys;// ���鼯��
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
	 * ȥ�������ҳ��
	 */
	public String toParticipation() {
		// �Ƴ���user�����������
		removeSession();
		// ��ȡ�����û������е���
		this.surveys = surveyService.ableSurvey(user, true);
		return "toParticipation";
	}

	/**
	 * �������
	 */
	public String participation() {
		Survey survey = surveyService.getSurvey(this.model.getSurvey_id());
		// ��ȡ�õ���ĵ�һ��ҳ��
		this.echoPage = surveyService.getFirstPageOfSurvey(survey);
		// �����������session��
		session.put(CURRENTSURVEY, survey);
		session.put(ALLPARAMETERS, new HashMap<String, Map<String, String[]>>());
		// ����һ��ҳ���ȡ����
		return "participation";
	}

	/**
	 * �������
	 */
	public String participationOption() {
		// ��ȡ��ǰ��survey
		Survey survey = (Survey) session.get(CURRENTSURVEY);
		// ��ȷ����һ����ť
		String buttomName = getButtomName();
		if (buttomName != null) {
			if (buttomName.endsWith("_last")) {// ��һ��
				// ��ȡ��ǰҳ�����һ��ҳ��
				this.echoPage = surveyService.getFirstOrNextOrderOfPage(survey.getSurvey_id(), currentPageOrder, First);
				// ���ύ�������ݻ���
				saveDataToSession(currentPageId + "", parameters);
			} else if (buttomName.endsWith("_next")) {// ��һ��
				// ��ȡ��ǰҳ�����һ��ҳ��
				this.echoPage = surveyService.getFirstOrNextOrderOfPage(survey.getSurvey_id(), currentPageOrder, NEXT);
				// ����ǰҳ��Ľ��������session��
				saveDataToSession(currentPageId + "", parameters);
			} else if (buttomName.endsWith("_done")) {// ���
				// ����ǰҳ��Ľ��������session��
				saveDataToSession(currentPageId + "", parameters);
				// �������
				surveyService.saveAnswer(session, ALLPARAMETERS, CURRENTSURVEY);
				// ���session
				removeSession();
				return "cancelToParticipation";
			} else if (buttomName.endsWith("_cancel")) {// ȡ��
				// �˳������session����������
				removeSession();
				return "cancelToParticipation";
			}
		}
		return "participation";
	}

	/**
	 * �������ݱ�����session����ҳ��idΪkey
	 */
	@SuppressWarnings("unchecked")
	private void saveDataToSession(String key, Map<String, String[]> value) {
		// ��ȡsession�����в���MAP
		Map<String, Map<String, String[]>> parameters = (Map<String, Map<String, String[]>>) session.get(ALLPARAMETERS);
		// ���ò�����ȥ
		parameters.put(key, value);
	}

	/**
	 * �Ƴ���user�������session����
	 */
	private void removeSession() {
		for (String key : session.keySet()) {
			// ������û�Ϊ������session����
			if (!key.equals("user")) {
				session.remove(key);
			}
		}
	}

	/**
	 * ��ȡ��ť������
	 */
	private String getButtomName() {
		for (String key : parameters.keySet()) {
			// �ж�����һ����ť�ύ��
			if (key.startsWith("submit_")) {
				// ȡ����ť����
				return key;
			}
		}
		return null;
	}

	/**
	 * ���ñ�ǩ����
	 */
	@SuppressWarnings("unchecked")
	public String setAttribute(String name, String value, String tag) {
		// ��session�л�ȡ���еĲ���
		Map<String, Map<String, String[]>> parametersAll = (Map<String, Map<String, String[]>>) session
				.get(ALLPARAMETERS);
		Map<String, String[]> map = parametersAll.get(echoPage.getPage_id() + "");
		// ��session�л�ȡ����Ӧ��ҳ������
		// ��������
		return StringUtil.isExistAttr(map, name, value, tag);
	}

	// ע��user
	public void setUser(User user) {
		this.user = user;
	}

	// ע��session
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	// ע��parameter�����ύ�����Ĳ���
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}
}

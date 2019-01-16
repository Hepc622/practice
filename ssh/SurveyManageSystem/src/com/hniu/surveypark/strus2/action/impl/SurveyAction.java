package com.hniu.surveypark.strus2.action.impl;

import java.io.File;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.hniu.surveypark.model.Survey;
import com.hniu.surveypark.model.User;
import com.hniu.surveypark.service.SurveyService;
import com.hniu.surveypark.strus2.action.BaseAction;
import com.hniu.surveypark.strus2.action.UserAware;
import com.hniu.surveypark.util.ValidateUtil;

public class SurveyAction extends BaseAction<Survey> implements UserAware, SessionAware {
	private static final long serialVersionUID = 1L;
	private SurveyService surveyService;
	private User user;// ����user
	private Map<String, Object> session;// ����session
	private Integer surveyId;// ����id
	private File upload;// �ϴ��ļ�
	private String uploadFileName;// �ϴ��ļ���
	private String uploadPage;// ����ҳ��url

	public SurveyService getSurveyService() {
		return surveyService;
	}

	public User getUser() {
		return user;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadPage(String uploadPage) {
		this.uploadPage = uploadPage;
	}

	public String getUploadPage() {
		return uploadPage;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public File getUpload() {
		return upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	public void setSurveyService(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	/**
	 * �����ҵĵ���ҳ��
	 */
	public String toMySurvey() {
		// ��ѯ�ҵĵ���
		session.put("survey", surveyService.mySurvey(user));
		return "toMySurvey";
	}

	/**
	 * �½�����
	 */
	public String toNewSurvey() {
		// ��������
		this.model = surveyService.newSurvey(user);
		return "toNewSurvey";
	}

	// public void prepareToDesign() {
	// this.model = surveyService.getSurvey(this.surveyId);
	// } ���ַ�ʽ����ʵ�֣�����model����ѹ��ջ�������������ص���prepare�����ı�ը

	/**
	 * ��Ƶ���
	 */
	public String toDesign() {
		// ǿ�н�������ļ��ϳ�ʼ��
		this.model = surveyService.getSurveyWithChild(this.surveyId);
		return "toDesign";
	}

	/**
	 * ȥ�༭surveyҳ��
	 */
	public String toEditSurvey() {
		// ��ȡ��Ӧ��survey���ݽ��л��Գ���
		this.model = surveyService.getSurvey(surveyId);
		return "toEditSurvey";
	}

	/**
	 * �༭����
	 */
	public String editSurvey() {
		// ��user���뵽survey��
		this.model.setUser(user);

		this.surveyId = this.model.getSurvey_id();
		// �����ݸ���
		surveyService.updateSurvey(model);
		return "toDesignAction";
	}

	/**
	 * ɾ������
	 */
	public String deleteSurvey() {
		String hql = "";
		// ɾ����
		// ɾ������ д����ֻ����������
		hql = "delete from Question q where q.page.page_id in (select p.page_id from Page p where p.survey.survey_id=?)";
		surveyService.deleteQuestionBatchEntityByHQL(hql, surveyId);
		// ɾ��ҳ��
		hql = "delete from Page p where p.survey.survey_id=?";
		surveyService.deletePageBatchEntityByHQL(hql, surveyId);
		// ɾ������
		hql = "delete from Survey s where s.survey_id=?";
		surveyService.deleteSurveyBatchEntityByHQL(hql, surveyId);
		return "deleteSurvey";
	}

	/**
	 * ���µ���״̬
	 */
	public String statusSurvey() {
		Survey survey = surveyService.getSurvey(surveyId);
		survey.setSurvey_closed(!survey.getSurvey_closed());
		surveyService.updateSurvey(survey);
		return "statusSurvey";
	}
	/**
	 * �������
	 */
	public String clearSurvey() {
		surveyService.clearSurvey(surveyId);
		return "clearSurvey";
	}

	/**
	 * ȥ�ϴ�ҳ��
	 */
	public String toUpLoadLogo() {
		return "toUpLoadLogo";
	}

	public void prepareUpLoadLogo() {
		this.uploadPage = "/up-load-logo.jsp";
	}

	/**
	 * �ϴ�LOGO
	 */
	public String upLoadLogo() {
		// ��ȡ���������·��
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		// ��ȡ�ļ���չ��
		String indexOf = this.uploadFileName.substring(this.uploadFileName.lastIndexOf("."));
		// ��ȡ��ǰʱ������ʱ��
		long time = System.nanoTime();
		// ���ļ������µ�����
		this.uploadFileName = time + indexOf;
		// �����ļ�
		File file = new File(path, this.uploadFileName);
		// �����ļ�·��
		upload.renameTo(file);
		// ��·���������ݿ�
		String hql = "update Survey s set s.survey_logo=? where s.survey_id=?";
		surveyService.saveSurveyLogoPath(hql, "/upload/" + time + indexOf, surveyId);
		return "toDesignAction";
	}

	/**
	 * �ж�·���Ƿ���Ч��
	 */
	public boolean isVaild() {
		// �ж������Ƿ���Ч
		if (ValidateUtil.isEmpty(this.model.getSurvey_logo())) {
			// �����ļ�
			File file = new File(ServletActionContext.getServletContext().getRealPath(this.model.getSurvey_logo()));
			// �Ƿ���ڸ��ļ�
			return file.exists();
		}
		return false;
	}

	/**
	 * ȥ�������ҳ��
	 */
	public String toAnalysis() {
		this.model = surveyService.getSurveyWithChild(surveyId);
		return "toAnalysis";
	}
	/**
	 * ע��user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * ע��session
	 */
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}

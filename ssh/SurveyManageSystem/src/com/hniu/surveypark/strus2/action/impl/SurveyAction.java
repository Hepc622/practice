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
	private User user;// 接受user
	private Map<String, Object> session;// 接受session
	private Integer surveyId;// 调查id
	private File upload;// 上传文件
	private String uploadFileName;// 上传文件名
	private String uploadPage;// 错误页面url

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
	 * 访问我的调查页面
	 */
	public String toMySurvey() {
		// 查询我的调查
		session.put("survey", surveyService.mySurvey(user));
		return "toMySurvey";
	}

	/**
	 * 新建调查
	 */
	public String toNewSurvey() {
		// 回显数据
		this.model = surveyService.newSurvey(user);
		return "toNewSurvey";
	}

	// public void prepareToDesign() {
	// this.model = surveyService.getSurvey(this.surveyId);
	// } 这种方式可以实现，将新model输入压倒栈顶，但是这样回到是prepare方法的爆炸

	/**
	 * 设计调查
	 */
	public String toDesign() {
		// 强行将关联类的集合初始化
		this.model = surveyService.getSurveyWithChild(this.surveyId);
		return "toDesign";
	}

	/**
	 * 去编辑survey页面
	 */
	public String toEditSurvey() {
		// 获取对应的survey数据进行回显出来
		this.model = surveyService.getSurvey(surveyId);
		return "toEditSurvey";
	}

	/**
	 * 编辑调查
	 */
	public String editSurvey() {
		// 将user存入到survey中
		this.model.setUser(user);

		this.surveyId = this.model.getSurvey_id();
		// 将数据更新
		surveyService.updateSurvey(model);
		return "toDesignAction";
	}

	/**
	 * 删除调查
	 */
	public String deleteSurvey() {
		String hql = "";
		// 删除答案
		// 删除问题 写操作只能两级关联
		hql = "delete from Question q where q.page.page_id in (select p.page_id from Page p where p.survey.survey_id=?)";
		surveyService.deleteQuestionBatchEntityByHQL(hql, surveyId);
		// 删除页面
		hql = "delete from Page p where p.survey.survey_id=?";
		surveyService.deletePageBatchEntityByHQL(hql, surveyId);
		// 删除调查
		hql = "delete from Survey s where s.survey_id=?";
		surveyService.deleteSurveyBatchEntityByHQL(hql, surveyId);
		return "deleteSurvey";
	}

	/**
	 * 更新调查状态
	 */
	public String statusSurvey() {
		Survey survey = surveyService.getSurvey(surveyId);
		survey.setSurvey_closed(!survey.getSurvey_closed());
		surveyService.updateSurvey(survey);
		return "statusSurvey";
	}
	/**
	 * 清除调查
	 */
	public String clearSurvey() {
		surveyService.clearSurvey(surveyId);
		return "clearSurvey";
	}

	/**
	 * 去上传页面
	 */
	public String toUpLoadLogo() {
		return "toUpLoadLogo";
	}

	public void prepareUpLoadLogo() {
		this.uploadPage = "/up-load-logo.jsp";
	}

	/**
	 * 上传LOGO
	 */
	public String upLoadLogo() {
		// 获取服务器相对路径
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		// 获取文件扩展名
		String indexOf = this.uploadFileName.substring(this.uploadFileName.lastIndexOf("."));
		// 获取当前时间纳秒时间
		long time = System.nanoTime();
		// 将文件赋予新的名字
		this.uploadFileName = time + indexOf;
		// 创建文件
		File file = new File(path, this.uploadFileName);
		// 更改文件路径
		upload.renameTo(file);
		// 将路径存入数据库
		String hql = "update Survey s set s.survey_logo=? where s.survey_id=?";
		surveyService.saveSurveyLogoPath(hql, "/upload/" + time + indexOf, surveyId);
		return "toDesignAction";
	}

	/**
	 * 判断路径是否有效性
	 */
	public boolean isVaild() {
		// 判断名字是否有效
		if (ValidateUtil.isEmpty(this.model.getSurvey_logo())) {
			// 创建文件
			File file = new File(ServletActionContext.getServletContext().getRealPath(this.model.getSurvey_logo()));
			// 是否存在该文件
			return file.exists();
		}
		return false;
	}

	/**
	 * 去调查分析页面
	 */
	public String toAnalysis() {
		this.model = surveyService.getSurveyWithChild(surveyId);
		return "toAnalysis";
	}
	/**
	 * 注入user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 注入session
	 */
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}

package com.hniu.surveypark.strus2.action.impl;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hniu.surveypark.model.User;
import com.hniu.surveypark.service.RightService;
import com.hniu.surveypark.service.UserService;
import com.hniu.surveypark.strus2.action.BaseAction;
import com.hniu.surveypark.util.DataUtil;

/**
 * �û���¼
 */
public class LoginAction extends BaseAction<User> implements SessionAware {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private UserService<User> userService;
	private RightService rightService;

	public void setRightService(RightService rightService) {
		this.rightService = rightService;
	}

	public void setUserService(UserService<User> userService) {
		this.userService = userService;
	}

	/**
	 * ȥ��½ҳ��
	 */
	public String toLogin() {
		return "index";
	}

	public String login() {
		if(model!=null){
			return SUCCESS;
		}
		return null;
	}

	/**
	 * ��¼��ϢУ��
	 */
	// ������֤�ķ�ʽ�ж���һ����@SkipValidationһ����validate+Ҫ��֤�ķ�����
	public void validateDoLogin() {
		// ��ѯ��Ӧ���û�
		User user = userService.loginValidate(model.getUser_email(), DataUtil.encryptionMD5(model.getUser_password()));
		// ��֤�Ƿ��и��û�
		if (user != null) {
			// ��ȡ��ǰȨ��λ
			int maxPos = rightService.getMaxPos();
			user.setRightSum(new long[(maxPos + 1)]);//��ʼ��Ȩ��λ��������ֵ
			user.initRigth();
			session.put("user", user);
		} else {
			if (!userService.isExsitEmail(model.getUser_email())) {
				addFieldError("user_email", "û�и�����");
			} else {
				addFieldError("user_password", "�������");
			}
		}
	}

	/**
	 * ע��ԭ��̬session
	 */
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

}

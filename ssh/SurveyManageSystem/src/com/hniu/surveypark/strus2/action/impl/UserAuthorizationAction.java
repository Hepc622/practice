package com.hniu.surveypark.strus2.action.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hniu.surveypark.model.Role;
import com.hniu.surveypark.model.User;
import com.hniu.surveypark.service.RightService;
import com.hniu.surveypark.service.UserService;
import com.hniu.surveypark.strus2.action.BaseAction;
import com.hniu.surveypark.strus2.action.UserAware;

public class UserAuthorizationAction extends BaseAction<User> implements SessionAware ,UserAware{
	private static final long serialVersionUID = 720654877587650911L;
	private UserService<User> userService;
	private List<User> users;
	private List<Role> notInclude;
	private Integer[] inc;
	private RightService rightService;
	private Map<String, Object> session;
	private User user;

	public void setRightService(RightService rightService) {
		this.rightService = rightService;
	}

	public List<Role> getInclude() {
		return new ArrayList<Role>(this.model.getUser_role());
	}

	public void setInc(Integer[] inc) {
		this.inc = inc;
	}

	public List<Role> getNotInclude() {
		return notInclude;
	}

	public List<User> getUser() {
		return this.users;
	}

	public void setUserService(UserService<User> userService) {
		this.userService = userService;
	}

	/**
	 * �û���Ȩ
	 */
	public String toAuthorization() {
		this.users = userService.getAllUser();
		return "toAuthorization";
	}

	/**
	 * ȥ��Ȩҳ��
	 */
	public String toEditAuthorization() {
		this.model = userService.getEntity(this.model.getUser_id());
		this.notInclude = userService.getNotRole(getInclude());
		return "toEditAuthorization";
	}

	/**
	 * ��Ȩ
	 */
	public String editAuthorization() {
		userService.saveOrUpdateEntity(model, inc);
		// �����ݿ��л�ȡ��ȡ�Ѿ����Ĺ���Ȩ�޷���session��
		user=userService.getEntity(user.getUser_id());
		user.setRightSum(new long[(rightService.getMaxPos() + 1)]);
		user.initRigth();
		session.put("user", user);
		return "editAuthorization";
	}

	/**
	 * �����Ȩ
	 */
	public String clearAuthorization() {
		userService.deleteUserRole(model);
		return "clearAuthorization";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}
}

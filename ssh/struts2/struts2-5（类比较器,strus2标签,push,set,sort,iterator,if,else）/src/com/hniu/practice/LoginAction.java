package com.hniu.practice;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

public class LoginAction implements RequestAware {
	private LoginParameters loginParameters;
	private List<Role> role;
	private List<Department> department;

	public LoginParameters getLoginParameters() {
		return loginParameters;
	}

	public void setLoginParameters(LoginParameters loginParameters) {
		this.loginParameters = loginParameters;
	}

	public List<Role> getRole() {
		return role;
	}

	
	public void setRole(List<Role> role) {
		this.role = role;
	}

	public List<Department> getDepartment() {
		return department;
	}

	public void setDepartment(List<Department> department) {
		this.department = department;
	}

	private Map<String, Object> map;

	public String login() {
		map.put("dpt", Dao.getDepartment());
		map.put("role", Dao.getRole());
		return "login";
	}

	public String show() {
		return "show";
	}

	public void setRequest(Map<String, Object> arg0) {
		this.map = arg0;
	}
}

package com.hniu.login;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements ApplicationAware,
		SessionAware {
	private String name;
	private Map<String, Object> application;
	private Map<String, Object> session;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String outLogin() {
		Integer count = (Integer) application.get("count");
		if (count != null && count > 0)
			count--;
		application.put("count", count);
		return "outLogin";
	}

	public String login() {
		// 1 获得session（实现requestAware）
		session.put("userName", name);
		// 2 统计在线人数
		Integer count = (Integer) application.get("count");
		if (count == null)
			count = 0;
		application.put("count", count + 1);
		return "loginSuccess";
	}

	public void setApplication(Map<String, Object> arg0) {
		this.application = arg0;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}

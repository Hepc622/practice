package com.hniu.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class ShowAware implements RequestAware, SessionAware, ApplicationAware {

	public void setRequest(Map<String, Object> arg0) {
		arg0.put("r", "request");
	}

	public void setSession(Map<String, Object> arg0) {
		arg0.put("s", "session");
	}

	public void setApplication(Map<String, Object> arg0) {
		arg0.put("a", "appliction");
	}

	public String execute() {
		return "success";
	}

}

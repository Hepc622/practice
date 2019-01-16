package com.hniu.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

public class TestServletActionContext implements ServletRequestAware {

	public void setServletRequest(HttpServletRequest arg0) {
		arg0.setAttribute("r", "Request");
		arg0.getSession().setAttribute("s", "Session");
	}

	public String execute() {
		return "success";
	}


}

package com.hniu.struts2.action.result;

import com.opensymphony.xwork2.ActionSupport;

public class TestResult extends ActionSupport {
	@Override
	public String execute() throws Exception {
		System.out.println("Execute");
		return super.execute();
	}
}

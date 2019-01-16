package com.hniu.urlexecutemethod;

import com.opensymphony.xwork2.ActionSupport;

public class Url_Execute_Method_Action extends ActionSupport {
	public String execute() throws Exception {
		return super.execute();
	}

	public void urlMethod() {
		System.out.println("url调用这个方法");
	}
}

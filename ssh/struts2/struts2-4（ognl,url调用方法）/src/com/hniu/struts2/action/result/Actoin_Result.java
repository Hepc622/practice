package com.hniu.struts2.action.result;

import com.opensymphony.xwork2.ActionSupport;

public class Actoin_Result extends ActionSupport {
	int code;

	public void setCode(int code) {
		this.code = code;
	}

	public String execute() throws Exception {

		String result = null;
		switch (code) {
		case 1:
			result = "resultLogin";
			break;
		case 2:
			result = "resultSuccess";
			break;
		case 3:
			result = "resultFail";
			break;
		case 4:
			result = "resultRegister";
			break;
		}
		return result;
	}
}

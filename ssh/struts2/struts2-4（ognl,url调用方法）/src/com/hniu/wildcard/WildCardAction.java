package com.hniu.wildcard;

import com.opensymphony.xwork2.ActionSupport;

public class WildCardAction extends ActionSupport {
	public String login() {
		return "login";
	}

	public String register() {
		return "register";
	}

	public String execute() throws Exception {
		return super.execute();
	}
}

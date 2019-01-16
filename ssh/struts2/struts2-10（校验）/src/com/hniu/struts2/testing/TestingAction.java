package com.hniu.struts2.testing;

import com.hniu.struts2.testing.bean.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TestingAction extends ActionSupport implements ModelDriven<User> {

	private User user;

	public String execute() {
		return SUCCESS;
	}

	public User getModel() {
		return new User();
	}

}

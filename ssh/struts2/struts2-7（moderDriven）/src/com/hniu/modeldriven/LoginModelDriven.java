package com.hniu.modeldriven;

import com.hniu.bean.User;
import com.opensymphony.xwork2.ModelDriven;

public class LoginModelDriven implements ModelDriven<User> {
	private User user = new User();

	public String login() {
		return "login";
	}

	public User getModel() {
		return user;
	}
}

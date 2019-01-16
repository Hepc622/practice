package com.hniu.ognl;

import com.opensymphony.xwork2.ActionSupport;

public class Ognl extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception {
		return super.execute();
	}
	public static void save(){
		System.out.println("success...");
	}
}

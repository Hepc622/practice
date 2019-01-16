package com.hniu.token;

import com.opensymphony.xwork2.ActionSupport;

public class TokenAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		System.out.println("token");
		return super.execute();
	}
}

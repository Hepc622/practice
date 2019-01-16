package com.hpc.fan.bean;

import java.util.Date;

/**
 * class：This is User
 * 
 * @author hpc
 * @2017年4月1日下午8:52:43
 */
public class User {
	private Integer user_id;
	private String user_name;
	private String user_pwd;
	private Date create_date;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
}

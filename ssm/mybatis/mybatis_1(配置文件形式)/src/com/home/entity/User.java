package com.home.entity;

/**
 * 此类是：user实体类
 * @author hpc
 * @2017年1月10日下午9:36:59
 */
public class User {
	private Integer user_id;
	private String user_name;
	private String user_pwd;
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
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_pwd=" + user_pwd + "]";
	}
	
}

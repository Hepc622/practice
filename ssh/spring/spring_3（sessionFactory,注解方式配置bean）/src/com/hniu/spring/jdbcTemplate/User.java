package com.hniu.spring.jdbcTemplate;

import org.springframework.stereotype.Component;

@Component
public class User {
	private int user_Id;
	private String user_Name;
	private String user_Pwd;
	private String user_car;
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getUser_Pwd() {
		return user_Pwd;
	}
	public void setUser_Pwd(String user_Pwd) {
		this.user_Pwd = user_Pwd;
	}
	public String getUser_car() {
		return user_car;
	}
	public void setUser_car(String user_car) {
		this.user_car = user_car;
	}
	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", user_Name=" + user_Name
				+ ", user_Pwd=" + user_Pwd + ", user_car=" + user_car + "]";
	}
	public User() {
		super();
	}
	public User( String user_Name, String user_Pwd) {
		super();
		this.user_Name = user_Name;
		this.user_Pwd = user_Pwd;
	}
	
}

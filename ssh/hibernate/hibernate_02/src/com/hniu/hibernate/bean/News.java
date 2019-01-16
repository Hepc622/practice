package com.hniu.hibernate.bean;

import java.util.Date;

public class News {
	private int id;
	private String userName;
	private String password;
	private Date brithDay;
	private int dataNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBrithDay() {
		return brithDay;
	}
	public void setBrithDay(Date brithDay) {
		this.brithDay = brithDay;
	}
	public int getDataNumber() {
		return dataNumber;
	}
	public void setDataNumber(int dataNumber) {
		this.dataNumber = dataNumber;
	}
	public News(String userName, String password, Date brithDay) {
		super();
		this.userName = userName;
		this.password = password;
		this.brithDay = brithDay;
	}
	public News() {
		super();
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", userName=" + userName + ", password="
				+ password + ", brithDay=" + brithDay + ", dataNumber="
				+ dataNumber + "]";
	}
	
}

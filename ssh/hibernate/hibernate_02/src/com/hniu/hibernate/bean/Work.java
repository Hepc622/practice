package com.hniu.hibernate.bean;

public class Work {
	private int id;
	private String userName;
//	值类型 ，没有oid不能被持久化，生命周期依赖持久类
	private Pay pay;
	
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
	public Pay getPay() {
		return pay;
	}
	public void setPay(Pay pay) {
		this.pay = pay;
	}
	public Work(String userName) {
		super();
		this.userName = userName;
	}
	public Work() {
		super();
	}
	@Override
	public String toString() {
		return "Work [id=" + id + ", userName=" + userName + ", pay=" + pay
				+ "]";
	}
}
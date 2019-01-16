package com.hniu.action.stack;

public class Person {
	@Override
	public String toString() {
		return "Person [userName=" + userName + ", userSex=" + userSex
				+ ", userAge=" + userAge + "]";
	}

	private String userName;
	private String userSex;
	private Integer userAge;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
}

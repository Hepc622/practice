package com.hniu.springmvc.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

/**
 * class：This is java bean User
 * 
 * @author hpc
 * @2017年2月23日下午6:45:08
 */
public class User {
	private String userName;
	private String userSex;
	private Integer userAge;
	@NumberFormat(pattern = "#,###,##")
	private Integer userNumber;
	// must be this yyyy/MM/dd format	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date userBirthdy;

	public Date getUserBirthdy() {
		return userBirthdy;
	}

	public void setUserBirthdy(Date userBirthdy) {
		this.userBirthdy = userBirthdy;
	}

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

	public Integer getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(Integer userNubmer) {
		this.userNumber = userNubmer;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userSex=" + userSex + ", userAge=" + userAge + ", userNumber="
				+ userNumber + ", userBirthdy=" + userBirthdy + "]";
	}
}

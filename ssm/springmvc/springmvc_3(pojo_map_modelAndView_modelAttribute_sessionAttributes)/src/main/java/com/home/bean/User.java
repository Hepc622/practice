package com.home.bean;

/**
 * 此类是：实体类
 * @author hpc
 * @2017年2月17日下午7:05:04
 */
public class User {
	private String userName;
	private String userSex;
	private Integer userAge;
	private Address address;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userSex=" + userSex + ", userAge=" + userAge + ", address=" + address
				+ "]";
	}
	
}

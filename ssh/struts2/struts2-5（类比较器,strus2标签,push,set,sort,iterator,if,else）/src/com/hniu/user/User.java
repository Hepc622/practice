package com.hniu.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hniu.comparator.UserComparator;

public class User {
	private String name;
	private String password;
	private String sex;
	private Integer age;
	private List<Object> list = new ArrayList<Object>();
	private UserComparator comparator;
	private Date date;
	private boolean agree;

	public User() {
	}

	public boolean isAgree() {
		return agree;
	}

	public void setAgree(boolean agree) {
		this.agree = agree;
	}

	public User(String name, String sex, Integer age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserComparator getComparator() {
		return comparator;
	}

	public void setComparator(UserComparator comparator) {
		this.comparator = comparator;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", sex=" + sex
				+ ", age=" + age + ", list=" + list + ", comparator="
				+ comparator + ", date=" + date + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}

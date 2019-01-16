package com.hniu.spring.beans.collection;

import java.util.LinkedHashMap;
import java.util.Set;

public class Person {
	private String name;
	private String sex;
	private int age;
	private Set<Phone> phone;
	private LinkedHashMap<String,Phone> phoneMap;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Phone> getPhone() {
		return phone;
	}

	public void setPhone(Set<Phone> phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", age=" + age
				+ ", phone=" + phone + ", phoneMap=" + phoneMap + "]";
	}

	public LinkedHashMap<String, Phone> getPhoneMap() {
		return phoneMap;
	}

	public void setPhoneMap(LinkedHashMap<String, Phone> phoneMap) {
		this.phoneMap = phoneMap;
	}

	public Person() {
		super();
	}

	public Person(String name, String sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		
	}

}

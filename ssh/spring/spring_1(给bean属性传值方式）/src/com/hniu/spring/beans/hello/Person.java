package com.hniu.spring.beans.hello;

public class Person {
	private String name;
	private String sex;
	private int age;
	private Phone phone;
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public Phone getPhone() {
		return phone;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", age=" + age
				+ ", phone=" + phone + "]";
	}
	public Person() {
		super();
	}
	public Person(String name, String sex, int age, Phone phone) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
	}
	
}

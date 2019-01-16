package com.hniu.spring.beans.scope;

public class Person {
	private String name;
	private String sex;
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
	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + "]";
	}
	public Person() {
		System.out.println("我被创建了！");
	}
	
}

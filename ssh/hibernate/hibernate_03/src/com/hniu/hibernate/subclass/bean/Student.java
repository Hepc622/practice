package com.hniu.hibernate.subclass.bean;

public class Student extends Person {
	private String  clazz;

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
}

package com.hniu.hibernate.one2one.bean;

public class Manager {

	private int id;
	private String name;
	private Department department;
	public Manager(String name, Department department) {
		super();
		this.name = name;
		this.department = department;
	}
	public Manager() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}

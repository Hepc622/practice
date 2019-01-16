package com.hniu.hibernate.one2one.bean.primary;

public class Department {
	private int id;
	private String name;
	private Manager manager;
	public Department(String name, Manager manager) {
		super();
		this.name = name;
		this.manager = manager;
	}
	public Department() {
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
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}

	
}

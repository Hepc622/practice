package com.hniu.hibernate.bean.one2more;

public class Customer {
	private int id;
	private String name;
	public Customer(String name) {
		super();
		this.name = name;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
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
	
	
}
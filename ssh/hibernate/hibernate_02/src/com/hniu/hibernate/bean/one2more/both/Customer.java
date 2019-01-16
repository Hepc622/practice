package com.hniu.hibernate.bean.one2more.both;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private int id;
	private String name;

	private Set<Order> orders = new HashSet<Order>();
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
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
}

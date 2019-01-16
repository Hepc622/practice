package com.hniu.hibernate.bean.one2more;

public class Order {
	private int id;
	private String orderName;
	
	private Customer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order() {
		super();
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order(String orderName, Customer customer) {
		super();
		this.orderName = orderName;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderName=" + orderName + ", customer="
				+ customer + "]";
	}
	
}

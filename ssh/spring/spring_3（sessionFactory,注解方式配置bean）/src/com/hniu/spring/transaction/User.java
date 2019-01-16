package com.hniu.spring.transaction;

import org.springframework.stereotype.Component;

@Component
public class User {
	private int user_id;
	private int user_name;
	private double user_balance;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getUser_name() {
		return user_name;
	}
	public void setUser_name(int user_name) {
		this.user_name = user_name;
	}
	public double getUser_balance() {
		return user_balance;
	}
	public void setUser_balance(double user_balance) {
		this.user_balance = user_balance;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name
				+ ", user_balance=" + user_balance + "]";
	}
	
}

package com.hniu.spring.transaction;

import org.springframework.stereotype.Component;

@Component
public class Shop {
	private int book_id;
	private String book_name;
	private int surplus;
	
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getSurplus() {
		return surplus;
	}
	public void setSurplus(int surplus) {
		this.surplus = surplus;
	}
	@Override
	public String toString() {
		return "Shop [book_id=" + book_id + ", book_name=" + book_name
				+ ", surplus=" + surplus + "]";
	}
	
}

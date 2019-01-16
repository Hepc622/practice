package com.hniu.spring.beans.hello;

public class Phone {
	private String screenSize;
	private String brand;
	private double price;
	private String introduce;
	public Phone(String screenSize, String brand, double price, String introduce) {
		super();
		this.screenSize = screenSize;
		this.brand = brand;
		this.price = price;
		this.introduce = introduce;
	}
	public Phone(String screenSize, String brand, double price) {
		super();
		this.screenSize = screenSize;
		this.brand = brand;
		this.price = price;
	}
	public Phone(String screenSize, String brand,String introduce) {
		super();
		this.screenSize = screenSize;
		this.brand = brand;
		this.introduce = introduce;
	}
	@Override
	public String toString() {
		return "Phone [screenSize=" + screenSize + ", brand=" + brand
				+ ", price=" + price + ", introduce=" + introduce + "]";
	}
	public Phone() {
		super();
	}
	public void setPrice(double price) {
		this.price = price;
	}
}

package com.hniu.spring.beans.collection;

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

	@Override
	public String toString() {
		return "Phone [screenSize=" + screenSize + ", brand=" + brand
				+ ", price=" + price + ", introduce=" + introduce + "]";
	}

	public Phone() {
		super();
	}

	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

}

package com.hniu.spring.beans.autowire;

public class Phone {
	private String brand;
	private String screen;
	private double price;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Phone [brand=" + brand + ", screen=" + screen + ", price="
				+ price + "]";
	}
	
}

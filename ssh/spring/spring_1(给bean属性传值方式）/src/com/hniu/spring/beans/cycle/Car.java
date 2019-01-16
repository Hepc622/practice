package com.hniu.spring.beans.cycle;

public class Car {
	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println("car property seting...");
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}
	public void init(){
		System.out.println("car initing...");
	}
	public void destroy(){
		System.out.println("car destroy...");
	}

	public Car() {
		super();
		System.out.println("car被创建");
	}
	
}

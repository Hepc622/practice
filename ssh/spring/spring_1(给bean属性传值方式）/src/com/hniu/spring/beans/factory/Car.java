package com.hniu.spring.beans.factory;

public class Car {
	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}

	public Car() {
		super();
	}

	public Car(String brand) {
		super();
		this.brand = brand;
	}

}

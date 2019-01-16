package com.hniu.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

public class FactoryInstanceGetBean {
	@SuppressWarnings("rawtypes")
	private Map car = new HashMap();
	
	@SuppressWarnings("unchecked")
	public FactoryInstanceGetBean() {
		car.put("audi", new Car("aodi"));
		car.put("ford", new Car("ford"));
	}

	public Car getCar(String brand){
		return (Car) car.get(brand);
	}
}

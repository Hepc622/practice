package com.hniu.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class FactoryStaticGetBean {
	static private Map car=null;
	static {
		car = new HashMap();
		car.put("audi", new Car("audi"));
		car.put("frod", new Car("frod"));
	}
	public static Car getCar(String name){
		return (Car) car.get(name);
	}
}

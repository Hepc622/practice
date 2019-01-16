package com.hniu.spring.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;
//实现工厂bean应该实现Factorybean接口
public class CarFactorybean implements FactoryBean<Car> {
    private String brand;
	
    public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	//	返回bean对象
	@Override
	public Car getObject() throws Exception {	
		return new Car(brand);
	}
//	放回bean类型
	@Override
	public Class<?> getObjectType() {
		
		return Car.class;
	}
//	该类是不是单例
	@Override
	public boolean isSingleton() {
		
		return true;
	}

}

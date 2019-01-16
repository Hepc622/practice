package com.hniu.spring.beans.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanFactory {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_factory.xml");
		Car car = (Car) ac.getBean("car");
		System.out.println(car);
		
	}

}

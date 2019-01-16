package com.hniu.spring.beans.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanFactoryBean {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_factorybean.xml");
		Car car = (Car) ac.getBean("factorybean");
		System.out.println(car);
	}

}

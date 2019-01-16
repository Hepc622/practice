package com.hniu.spring.beans.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanCycle {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_cycle.xml");
		Car car = ac.getBean(Car.class);
		System.out.println(car);
		ac.close();
	}

}

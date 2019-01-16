package com.hniu.spring.beans.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanAnnotation {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans_annotation.xml");		
//		((Car)ac.getBean("c")).GetCar();	
//		System.out.println(ac.getBean("c"));
		System.out.println(ac.getBean("person"));
		
	}
}

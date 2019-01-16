package com.hniu.spring.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAopXml {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans-aop-xml.xml");
		ArithmeticCalculatorImpl ac = (ArithmeticCalculatorImpl) context.getBean("arithmeticCalculatorImpl");
		ac.div(1,1);
		
	}

}


package com.hniu.spring.aop.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAop {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans-aop.xml");
		ArithmeticCalculator ac = (ArithmeticCalculatorImpl) context.getBean("arithmeticCalculatorImpl");
		ac.div(1, 1);
		
	}

}


package com.hniu.spring.aop.order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAop {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans-aop-order.xml");
		ArithmeticCalculator ac = (ArithmeticCalculatorImpl) context.getBean("arithmeticCalculatorImpl");
		ac.add(1,1);
		
	}

}


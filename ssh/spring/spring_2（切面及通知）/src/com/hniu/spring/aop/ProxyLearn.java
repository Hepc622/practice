package com.hniu.spring.aop;

public class ProxyLearn {

	public static void main(String[] args) {
		ArithmeticCalculatorProxy proxy = new ArithmeticCalculatorProxy(new ArithmeticCalculatorImpl());
		ArithmeticCalculator calculator = proxy.getProxy();
		calculator.mul(211, 2);
	}

}

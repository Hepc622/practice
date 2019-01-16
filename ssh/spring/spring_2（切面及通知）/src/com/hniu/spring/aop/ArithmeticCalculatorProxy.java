package com.hniu.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ArithmeticCalculatorProxy {
	private ArithmeticCalculator calculator;

	public ArithmeticCalculatorProxy(ArithmeticCalculator calculator) {
		super();
		this.calculator = calculator;
	}

	public ArithmeticCalculator getProxy() {
		InvocationHandler ih = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println(method.getName() + "：before");
				Object invoke = method.invoke(calculator, args);
				System.out.println(method.getName() + "：after");
				return invoke;
			}
		};
		return (ArithmeticCalculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(),
				calculator.getClass().getInterfaces(), ih);
	}
}

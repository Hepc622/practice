package com.hniu.spring.aop.hello;

import org.springframework.stereotype.Component;

@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

	@Override
	public int add(int x, int y) {
		return(x+y);
	}

	@Override
	public void sub(int x, int y) {
		System.out.println(x-y);
	}

	@Override
	public void mul(int x, int y) {
		System.out.println(x*y);
	}

	@Override
	public void div(int x, int y) {
		System.out.println(x/y);
	}

}

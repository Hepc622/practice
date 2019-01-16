package com.hniu.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

	@Override
	public void add(int x, int y) {
		System.out.println(x+y);
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
		if (y>0||y<0) {
			System.out.println(x/y);
		}else{
			System.out.println("除数不能为零！");
		}
	}

}

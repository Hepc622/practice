package com.hniu.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class ArithmeticCalculatorLoging {

	public void pointCut() {
	}

	// 在执行目标方法之前执行
	public void printLogingBefore(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("the " + method + " method start"
				+ Arrays.asList(args));
	}

	// 不管被执行的方法有没有出错误，都会执行，有点和异常的finally相似
	public void printLogingAfter(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("the " + method + " method end"
				+ Arrays.asList(args));
	}

	// 返回通知，目标方法执行放回结果之后执行
	public Object printResult(Object r) {
		System.out.println("this is result " + r);
		return r;
	}

	// 异常通知，目标方法执行出错之后的时候执行
	public void printErro(Exception e) {
		System.out.println(e);
	}

	// 环绕通知
	public Object around(ProceedingJoinPoint joinPoint) {
		Object proceed = null;
		try {
			// 前置通知
			System.out.println("around 被代理对象方法执行之前");
			proceed = joinPoint.proceed();
			System.out.println("around 被代理对象方法放回结果执行之后");
			return proceed;
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("around " + e);
		}
		System.out.println("around 被代理对象方法执行之后");
		return proceed;
	}
}